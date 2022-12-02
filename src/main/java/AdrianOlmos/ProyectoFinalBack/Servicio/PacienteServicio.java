package AdrianOlmos.ProyectoFinalBack.Servicio;

import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones.PacienteDAOH2;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class PacienteServicio {
    private IDao DAOEspecifico;

    public PacienteServicio(IDao DAOEspecifico) {
        this.DAOEspecifico = new PacienteDAOH2();
    } // ACA ESTA LA INSERCIÓN

    public void crearTabla() throws SQLException {
        DAOEspecifico.CrearTabla();
    }

    public Paciente ListarPaciente(int DNI) throws SQLException {
        return (Paciente) DAOEspecifico.listar(DNI);
    }

    public Paciente guardarPaciente (Paciente paciente) throws SQLException {
        DAOEspecifico.agregar(paciente);
        return paciente;
    }

    public void eliminarPaciente (int DNI) throws SQLException {
        DAOEspecifico.eliminar(DNI);
    }

    public Paciente actualizarPaciente(Paciente paciente) throws SQLException {
        return (Paciente) DAOEspecifico.actualizar(paciente);
    }

    public List listarPacientes() throws SQLException {
        return DAOEspecifico.listarTodos();
    }
}
