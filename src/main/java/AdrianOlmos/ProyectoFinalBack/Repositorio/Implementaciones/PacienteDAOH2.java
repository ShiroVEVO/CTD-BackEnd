package AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones;

import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Configuracion.Conexion;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PacienteDAOH2 implements IDao<Paciente> {
    private Conexion conexion = new Conexion();
    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);
    private PreparedStatement consulta = null;
    private static final String createTable = "DROP TABLE IF EXISTs PACIENTE;\n"
            + "CREATE TABLE PACIENTE(DNI INT PRIMARY KEY, ROLE VARCHAR(255), USUARIO VARCHAR(255), PASSWORD VARCHAR(255), "
            + "NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), DOMICILIO VARCHAR(255), FECHAALTA VARCHAR(255));";
    private static final String select = "SELECT * FROM PACIENTE;";
    private static final String select_with_id = "SELECT * FROM PACIENTE WHERE DNI = ?";
    private static final String insert = "INSERT INTO PACIENTE VALUES(?,?,?,?,?,?,?,?);";
    private static final String delete = "DELETE FROM PACIENTE WHERE DNI = ?;";
    private static final String update = "UPDATE PACIENTE SET USUARIO=?, PASSWORD=?, NOMBRE=?, APELLIDO=?, DOMICILIO=?, FECHAALTA=? WHERE DNI = ?;";


    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public void CrearTabla() throws SQLException {
        conexion.conectar();
        Statement consulta = null;
        try{
            consulta = conexion.conn.createStatement();
            consulta.execute(createTable);
            logger.info("Se creó la tabla");
        }catch(Exception e){

            logger.error("Se presento un problema al crear la tabla: ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public Paciente listar(int id) throws SQLException {
        ResultSet resultados = null;
        Paciente paciente = null;
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(select_with_id);
            consulta.setInt(1,id);
            resultados = consulta.executeQuery();
            if(resultados.next()){
                int dni = resultados.getInt(1);
                String role = resultados.getString(2);
                String user = resultados.getString(3);
                String password = resultados.getString(4);
                String nombre =  resultados.getString(5);
                String apellido = resultados.getString(6);
                String domicilio = resultados.getString(7);
                String fechaAlta = resultados.getString(8);
                paciente = new Paciente(role,user,password,nombre, apellido,domicilio,dni,fechaAlta);
            }
            logger.info("Se trajo el paciente: " + paciente);
        }catch(Exception e){
            logger.error("Se presento un error al traer el paciente, ", e);
        }finally {
            resultados.close();
            consulta.close();
            conexion.desconectar();
        }
        return paciente;
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public Paciente agregar(Paciente paciente) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(insert);
            consulta.setInt(1, paciente.getDNI());
            consulta.setString(2, paciente.getROLE());
            consulta.setString(3, paciente.getUser());
            consulta.setString(4, paciente.getPassword());
            consulta.setString(5,paciente.getNombre());
            consulta.setString(6,paciente.getApellido());
            consulta.setString(7,paciente.getDomicilio());
            consulta.setString(8,paciente.getFechaAlta());
            consulta.execute();
            logger.info("Se guardo el paciente:" + paciente);
        }catch (Exception e){
            logger.error("No se pudo guardar el paciente, ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
        return paciente;
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public void eliminar(int id) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(delete);
            consulta.setInt(1,id);
            consulta.executeUpdate();
            logger.info("Se elimino el paciente con DNI: " + id);
        }catch(Exception e){
            logger.error("Se presento un error al eliminar el paciente, ", e);
        }finally {
            conexion.desconectar();
        }
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public Paciente actualizar(Paciente paciente) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(update);
            consulta.setString(1, paciente.getUser());
            consulta.setString(2, paciente.getPassword());
            consulta.setString(3, paciente.getNombre());
            consulta.setString(4, paciente.getApellido());
            consulta.setString(5, paciente.getDomicilio());
            consulta.setString(6, paciente.getFechaAlta());
            consulta.setInt(7,paciente.getDNI());
            consulta.executeUpdate();
            logger.info("Se actualizo el paciente " + paciente.getDNI() + " a " + paciente);
        }catch (Exception e){
            logger.error("No se pudo actualizar el paciente, ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
        return paciente;
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public List<Paciente> listarTodos() throws SQLException {
        Statement consulta = null;
        ResultSet resultados = null;
        List<Paciente> ListaPacientes = new ArrayList<>();
        try{
            conexion.conectar();
            consulta = conexion.conn.createStatement();
            resultados = consulta.executeQuery(select);
            while (resultados.next()){
                int DNI = resultados.getInt(1);
                String role = resultados.getString(2);
                String user = resultados.getString(3);
                String password = resultados.getString(4);
                String nombre = resultados.getString(5);
                String apellido = resultados.getString(6);
                String domicilio = resultados.getString(7);
                String fechaAlta = resultados.getString(8);
                Paciente paciente = new Paciente(role,user,password,nombre,apellido,domicilio,DNI,fechaAlta);
                logger.info("Se trajo el paciente: " + paciente);
                ListaPacientes.add(paciente);
            }
        }catch (Exception e){
            logger.error("Se presento un error al listar los pacientes, ", e);
        }finally {
            resultados.close();
            consulta.close();
            conexion.desconectar();
        }
        return ListaPacientes;
    }
    //--------------------------------------------------------------------------------
}
