package AdrianOlmos.ProyectoFinalBack.Servicio;

import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;
import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class OdontologoServicio {
    private IDao DAOEspecifico;

    @Autowired
    public OdontologoServicio(IDao DAOEspecifico) {
        this.DAOEspecifico = DAOEspecifico;
    }

    public void crearTabla() throws SQLException {
        DAOEspecifico.CrearTabla();
    }

    public Odontologo ListarOdontologo(int matriculaOdontologo) throws SQLException {
        return (Odontologo) DAOEspecifico.listar(matriculaOdontologo);
    }

    public void guardarOdontologo (Odontologo odontologo) throws SQLException {
        DAOEspecifico.agregar(odontologo);
    }

    public void eliminarOdontologo (int matriculaOdontologo) throws SQLException {
        DAOEspecifico.eliminar(matriculaOdontologo);
    }

    public void actualizarOdontologo(Odontologo odontologo, int id) throws SQLException {
        DAOEspecifico.actualizar(odontologo, id);
    }

    public List<Odontologo> listarOdontologos() throws SQLException {
        return DAOEspecifico.listarTodos();
    }
}
