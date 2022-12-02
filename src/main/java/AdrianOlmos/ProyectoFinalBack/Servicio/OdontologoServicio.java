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

    public Odontologo guardarOdontologo (Odontologo odontologo) throws SQLException {
        DAOEspecifico.agregar(odontologo);
        return odontologo;
    }

    public void eliminarOdontologo (int matriculaOdontologo) throws SQLException {
        DAOEspecifico.eliminar(matriculaOdontologo);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo) throws SQLException {
        return (Odontologo) DAOEspecifico.actualizar(odontologo);
    }

    public List<Odontologo> listarOdontologos() throws SQLException {
        return DAOEspecifico.listarTodos();
    }
}
