package AdrianOlmos.ProyectoFinalBack.Servicio;

import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class PacienteServicio {
    private IDao DAOEspecifico;

    public PacienteServicio(IDao DAOEspecifico) {
        this.DAOEspecifico = DAOEspecifico;
    }

    public void crearTabla() throws SQLException {
        DAOEspecifico.CrearTabla();
    }

    public Paciente ListarPaciente(int DNI) throws SQLException {
        return (Paciente) DAOEspecifico.listar(DNI);
    }

    public void guardarPaciente (Paciente paciente) throws SQLException {
        DAOEspecifico.agregar(paciente);
    }

    public void eliminarPaciente (int DNI) throws SQLException {
        DAOEspecifico.eliminar(DNI);
    }

    public void actualizarPaciente(Paciente paciente, int DNI) throws SQLException {
        DAOEspecifico.actualizar(paciente, DNI);
    }

    public List listarPacientes() throws SQLException {
        return DAOEspecifico.listarTodos();
    }
}
