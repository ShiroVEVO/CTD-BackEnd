package AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones;

import AdrianOlmos.ProyectoFinalBack.Modelo.Turno;
import AdrianOlmos.ProyectoFinalBack.Modelo.TurnoDTO;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Configuracion.Conexion;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAOH2 implements IDao<TurnoDTO>{
    private Conexion conexion = new Conexion();
    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);
    private PreparedStatement consulta = null;
    private static final String createTable = "DROP TABLE IF EXISTS TURNO;\n"
            + "CREATE TABLE TURNO(NUMTURNO INT PRIMARY KEY, HORA VARCHAR(255), FECHA VARCHAR(255), "
            + "MATRICULA INT, DNI INT);";
    private static final String select = "SELECT t.NUMTURNO, t.HORA, t.FECHA, t.MATRICULA, o.NOMBRE, o.APELLIDO,t.DNI, p.NOMBRE, p.APELLIDO FROM TURNO AS t JOIN ODONTOLOGO AS o ON t.MATRICULA = o.NUMMATRICULA JOIN PACIENTE AS p ON t.DNI = p.DNI";
    private static final String select_with_id = select + " WHERE NUMTURNO=?";
    private static final String insert = "INSERT INTO TURNO VALUES(?,?,?,?,?);";
    private static final String delete = "DELETE FROM TURNO WHERE NUMTURNO = ?;";
    private static final String update = "";

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

    @Override
    public TurnoDTO listar(int id) throws SQLException {
        ResultSet resultados = null;
        TurnoDTO turno = null;
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(select_with_id);
            consulta.setInt(1,id);
            resultados = consulta.executeQuery();
            if(resultados.next()){
                int numTurno = resultados.getInt(1);
                String hora = resultados.getString(2);
                String fecha = resultados.getString(3);
                int matricula = resultados.getInt(4);
                String nombreOdontologo =  resultados.getString(5) + " " + resultados.getString(6);
                int dni = resultados.getInt(7);
                String nombrePaciente = resultados.getString(8) + " " + resultados.getString(9);
                turno = new TurnoDTO(numTurno,hora,fecha,matricula,nombreOdontologo,dni,nombrePaciente);
            }
            logger.info("Se trajo el turno: " + turno);
        }catch(Exception e){
            logger.error("Se presento un error al traer el turno, ", e);
        }finally {
            resultados.close();
            consulta.close();
            conexion.desconectar();
        }
        return turno;
    }

    @Override
    public TurnoDTO agregar(TurnoDTO turno) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(insert);
            consulta.setInt(1, turno.getNumTurno());
            consulta.setString(2,turno.getHora());
            consulta.setString(3, turno.getFecha());
            consulta.setInt(4, turno.getMatricula());
            consulta.setInt(5,turno.getDNI());
            consulta.execute();
            logger.info("Se guardo el turno:" + turno);
        }catch (Exception e){
            logger.error("No se pudo guardar el turno, ", e);
        }finally {
            consulta.close();
            conexion.desconectar();
        }
        return null;
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try{
            conexion.conectar();
            consulta = conexion.conn.prepareStatement(delete);
            consulta.setInt(1,id);
            consulta.executeUpdate();
            logger.info("Se elimino el turno con numero: " + id);
        }catch(Exception e){
            logger.error("Se presento un error al eliminar el turno, ", e);
        }finally {
            conexion.desconectar();
        }
    }

    @Override
    public TurnoDTO actualizar(TurnoDTO turno) throws SQLException {
        return null;
    }

    @Override
    public List<TurnoDTO> listarTodos() throws SQLException {
        Statement consulta = null;
        ResultSet resultados = null;
        List<TurnoDTO> ListaTurnos = new ArrayList<>();
        try{
            conexion.conectar();
            consulta = conexion.conn.createStatement();
            resultados = consulta.executeQuery(select);
            while (resultados.next()){
                int numTurno = resultados.getInt(1);
                String hora = resultados.getString(2);
                String fecha = resultados.getString(3);
                int matricula = resultados.getInt(4);
                String nombreOdontologo =  resultados.getString(5) + " " + resultados.getString(6);
                int dni = resultados.getInt(7);
                String nombrePaciente = resultados.getString(8) + " " + resultados.getString(9);
                TurnoDTO turno = new TurnoDTO(numTurno,hora,fecha,matricula,nombreOdontologo,dni,nombrePaciente);
                logger.info("Se trajo el turno: " + turno);
                ListaTurnos.add(turno);
            }
        }catch (Exception e){
            logger.error("Se presento un error al listar los turnos, ", e);
        }finally {
            resultados.close();
            consulta.close();
            conexion.desconectar();
        }
        return ListaTurnos;
    }
}
