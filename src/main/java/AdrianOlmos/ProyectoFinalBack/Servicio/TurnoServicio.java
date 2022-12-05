package AdrianOlmos.ProyectoFinalBack.Servicio;

import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Modelo.TurnoDTO;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones.TurnoDAOH2;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class TurnoServicio {
    private IDao DAOEspecifico;

    public TurnoServicio(IDao DAOEspecifico) {
        this.DAOEspecifico = new TurnoDAOH2();
    }

    public void crearTabla() throws SQLException {
        DAOEspecifico.CrearTabla();
    }

    public TurnoDTO ListarTurno(int ID) throws SQLException {
        return (TurnoDTO) DAOEspecifico.listar(ID);
    }

    public TurnoDTO guardarTurno (TurnoDTO turno) throws SQLException {
        DAOEspecifico.agregar(turno);
        return turno;
    }

    public void eliminarTurno (int ID) throws SQLException {
        DAOEspecifico.eliminar(ID);
    }

    public TurnoDTO actualizarTurno(TurnoDTO turno) throws SQLException {
        return (TurnoDTO) DAOEspecifico.actualizar(turno);
    }

    public List<TurnoDTO> listarTurnos() throws SQLException {
        return DAOEspecifico.listarTodos();
    }

}
