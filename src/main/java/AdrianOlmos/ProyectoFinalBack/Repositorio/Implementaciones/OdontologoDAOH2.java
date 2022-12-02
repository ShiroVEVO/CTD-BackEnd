package AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Configuracion.Conexion;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoDAOH2 implements IDao<Odontologo> {
    private Conexion conexion = new Conexion();
    private PreparedStatement consulta = null;
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String insert = "INSERT INTO ODONTOLOGO VALUES(?,?,?,?,?);";
    private static final String select = "SELECT * FROM ODONTOLOGO;";
    private static final String select_with_id = "SELECT * FROM ODONTOLOGO WHERE NUMMATRICULA = ?";
    private static final String createTable = "DROP TABLE IF EXISTS ODONTOLOGO;\n"
            + "CREATE TABLE ODONTOLOGO(NUMMATRICULA INT PRIMARY KEY, NOMBRE VARCHAR(255), "
            + "APELLIDO VARCHAR (255), USUARIO VARCHAR(255), PASSWORD VARCHAR(255));";
    private static final String delete = "DELETE FROM ODONTOLOGO WHERE NUMMATRICULA = ?;";
    private static final String update = "UPDATE ODONTOLOGO SET NOMBRE=?, APELLIDO=?, USUARIO=?, PASSWORD=? WHERE NUMMATRICULA = ?;";

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public void CrearTabla() throws SQLException {
        conexion.conectar();
        Statement consulta = null;
        try{
            consulta = conexion.conn.createStatement();
            consulta.execute(createTable);
           //System.out.println("Se creó la tabla");
            logger.info("Se creó la tabla");
        }catch(Exception e){
            logger.error("No se creó la tabla: ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override//"""Listo"""
    public Odontologo listar(int NumMatricula) throws SQLException {
        ResultSet resultados;
        Odontologo odontologo = null;
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(select_with_id);
            consulta.setInt(1,NumMatricula);
            resultados = consulta.executeQuery();
            if(resultados.next()){
                int matri = resultados.getInt(1);
                String nombre =  resultados.getString(2);
                String apellido = resultados.getString(3);
                String user = resultados.getString(4);
                String password = resultados.getString(5);
                odontologo = new Odontologo(user,password,nombre, apellido, matri);
                logger.info("Se trajo el odontologo con matricula: " + matri);
            }
        }catch(Exception e){
            System.out.println("Un problema: " + e);
            logger.info("Se presento un error al traer el odontologo con matricula " + NumMatricula + " ,", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
        return odontologo;
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public Odontologo agregar(Odontologo odontologo) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(insert);
            consulta.setInt(1,odontologo.getMatricula());
            consulta.setString(2,odontologo.getNombre());
            consulta.setString(3,odontologo.getApellido());
            consulta.setString(4, odontologo.getUser());
            consulta.setString(5,odontologo.getPassword());
            consulta.execute();
            logger.info("Se guardo el odontologo:" + odontologo.toString());
        }catch (Exception e){
            logger.error("No se pudo guardar el odontologo, ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
        return odontologo;
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
            logger.info("Se eliminó el odontologo con matricula: " + id);
        }catch(Exception e){
            logger.error("No se pudo eliminar el odontologo, ", e);
        }finally {
            conexion.desconectar();
        }
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public Odontologo actualizar(Odontologo odontologo) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(update);
            consulta.setString(1, odontologo.getNombre());
            consulta.setString(2, odontologo.getApellido());
            consulta.setString(3, odontologo.getUser());
            consulta.setString(4, odontologo.getPassword());
            consulta.setInt(5, odontologo.getMatricula());
            consulta.executeUpdate();
            logger.info("se actualizó el odontologo " + odontologo.getMatricula() + " a " + odontologo);
        }catch (Exception e){
            logger.error("No se pudo actualizar el odontologo, ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
        return odontologo;
    }
    //--------------------------------------------------------------------------------

    //--------------------------------TESTEADO FUNCIONAL------------------------------
    @Override
    public List<Odontologo> listarTodos() throws SQLException {
        Statement consulta = null;
        ResultSet resultados = null;
        List<Odontologo> ListaOdontologos = new ArrayList<>();
        try{
            conexion.conectar();
            consulta = conexion.conn.createStatement();
            resultados = consulta.executeQuery(select);

            while (resultados.next()){
                int NumMatri = resultados.getInt(1);
                String Nombre = resultados.getString(2);
                String Apellido = resultados.getString(3);
                String User = resultados.getString(4);
                String Password = resultados.getString(5);

                Odontologo odontologo = new Odontologo(User,Password,Nombre, Apellido, NumMatri);
                logger.info("Se trajo un odontologo: " + odontologo);
                ListaOdontologos.add(odontologo);
            }
        }catch (Exception e){
            logger.error("Se presento un error al listar odontologos, ", e);
        }finally {
            resultados.close();
            consulta.close();
            conexion.desconectar();
        }
        return ListaOdontologos;
    }
    //--------------------------------------------------------------------------------
}