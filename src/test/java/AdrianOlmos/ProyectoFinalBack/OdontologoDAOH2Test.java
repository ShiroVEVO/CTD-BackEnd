package AdrianOlmos.ProyectoFinalBack;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones.OdontologoDAOH2;
import AdrianOlmos.ProyectoFinalBack.Servicio.OdontologoServicio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2Test {
    OdontologoServicio os = new OdontologoServicio(new OdontologoDAOH2());

    @org.junit.jupiter.api.Test
    void crearTabla() throws SQLException {
        os.crearTabla();
    }

    @org.junit.jupiter.api.Test
    void listarOdontologos() throws SQLException {
        Odontologo odontologo1 = new Odontologo("user1", "pass1", "Pablo", "cadenas",001);
        Odontologo odontologo2 = new Odontologo("user2", "pass2", "Pedro", "naranjas",002);
        Odontologo odontologo3 = new Odontologo("user3", "pass3", "Armando", "Fierros",003);

        os.crearTabla();

        os.guardarOdontologo(odontologo1);
        os.guardarOdontologo(odontologo2);
        os.guardarOdontologo(odontologo3);
    }

    @org.junit.jupiter.api.Test
    void agregarOdontologos() throws SQLException {
        Odontologo odontologo1 = new Odontologo("user1", "pass1", "Pablo", "cadenas",001);
        os.crearTabla();
        os.guardarOdontologo(odontologo1);
    }

    @org.junit.jupiter.api.Test
    void eliminarOdontologo() throws SQLException {
        Odontologo odontologo1 = new Odontologo("user1", "pass1", "Pablo", "cadenas",001);
        Odontologo odontologo2 = new Odontologo("user2", "pass2", "Pedro", "naranjas",002);
        Odontologo odontologo3 = new Odontologo("user3", "pass3", "Armando", "Fierros",003);

        os.crearTabla();

        os.guardarOdontologo(odontologo1);
        os.guardarOdontologo(odontologo2);
        os.guardarOdontologo(odontologo3);

        os.eliminarOdontologo(odontologo2.getMatricula());
    }

    @org.junit.jupiter.api.Test
    void actualizarOdontologo() throws SQLException {
        Odontologo odontologo1 = new Odontologo("user1", "pass1", "Pablo", "cadenas",001);
        Odontologo odontologo2 = new Odontologo("userX","XXX","Actualizado","Actualizado",999);

        os.crearTabla();

        os.guardarOdontologo(odontologo1);
        os.guardarOdontologo(odontologo2);

        os.actualizarOdontologo(odontologo2, odontologo1.getMatricula());
    }

    @org.junit.jupiter.api.Test
    void listarOdontologo() throws SQLException{
        Odontologo odontologo1 = new Odontologo("user1", "pass1", "Pablo", "cadenas",001);
        Odontologo odontologo2 = new Odontologo("user2", "pass2", "Pedro", "naranjas",002);
        Odontologo odontologo3 = new Odontologo("user3", "pass3", "Armando", "Fierros",003);

        os.crearTabla();

        os.guardarOdontologo(odontologo1);
        os.guardarOdontologo(odontologo2);
        os.guardarOdontologo(odontologo3);

        System.out.println(os.ListarOdontologo(odontologo2.getMatricula()));
    }
}
