package AdrianOlmos.ProyectoFinalBack.Servicio;

import AdrianOlmos.ProyectoFinalBack.Modelo.Turno;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class TurnoServicio {
    private IDao DAOEspecifico;

    public TurnoServicio(IDao DAOEspecifico) {
        this.DAOEspecifico = DAOEspecifico;
    }

    public void crearTabla() throws SQLException {
        DAOEspecifico.CrearTabla();
    }

    public Turno ListarTurno(int ID) throws SQLException {
        return (Turno) DAOEspecifico.listar(ID);
    }

    public void guardarTurno (Turno turno) throws SQLException {
        DAOEspecifico.agregar(turno);
    }

    public void eliminarTurno (int ID) throws SQLException {
        DAOEspecifico.eliminar(ID);
    }

    public void actualizarTurno(Turno turno, int ID) throws SQLException {
        DAOEspecifico.actualizar(turno, ID);
    }

    public List listarTurnos() throws SQLException {
        return DAOEspecifico.listarTodos();
    }

}
