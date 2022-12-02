package AdrianOlmos.ProyectoFinalBack;

import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones.PacienteDAOH2;
import AdrianOlmos.ProyectoFinalBack.Servicio.PacienteServicio;

import java.sql.SQLException;

public class PacienteDAOH2Test {
    PacienteServicio ps = new PacienteServicio(new PacienteDAOH2());

    @org.junit.jupiter.api.Test
    void crearTabla() throws SQLException {
        ps.crearTabla();
    }

    @org.junit.jupiter.api.Test
    void listarPacientes() throws SQLException {
        Paciente paciente1 = new Paciente("userP1", "passP1", "Dolores", "cadera","P sherman calle wallaby 42 sydney", 10100, "8/nov/2022");
        Paciente paciente2 = new Paciente("userP2", "passP2", "Juanito", "rodilla","Calle 123 numero 123",20200,"9/nov/2022");
        Paciente paciente3 = new Paciente("userP3", "passP3", "Marcelo", "suckma", "Streetway to heaven",30300,"10/nov/2022");

        ps.crearTabla();

        ps.guardarPaciente(paciente1);
        ps.guardarPaciente(paciente2);
        ps.guardarPaciente(paciente3);
    }

    @org.junit.jupiter.api.Test
    void agregarPacientes() throws SQLException {
        Paciente paciente1 = new Paciente("userP1", "passP1", "Dolores", "cadera","P sherman calle wallaby 42 sydney", 10100, "8/nov/2022");
        ps.crearTabla();
        ps.guardarPaciente(paciente1);
    }

    @org.junit.jupiter.api.Test
    void eliminarOdontologo() throws SQLException {
        Paciente paciente1 = new Paciente("userP1", "passP1", "Dolores", "cadera","P sherman calle wallaby 42 sydney", 10100, "8/nov/2022");
        Paciente paciente2 = new Paciente("userP2", "passP2", "Juanito", "rodilla","Calle 123 numero 123",20200,"9/nov/2022");
        Paciente paciente3 = new Paciente("userP3", "passP3", "Marcelo", "suckma", "Streetway to heaven",30300,"10/nov/2022");

        ps.crearTabla();

        ps.guardarPaciente(paciente1);
        ps.guardarPaciente(paciente2);
        ps.guardarPaciente(paciente3);

        ps.eliminarPaciente(paciente2.getDNI());
    }

    @org.junit.jupiter.api.Test
    void actualizarOdontologo() throws SQLException {
        Paciente paciente1 = new Paciente("userP1", "passP1", "Dolores", "cadera","P sherman calle wallaby 42 sydney", 10100, "8/nov/2022");
        Paciente pacienteX = new Paciente("userX", "passX", "Actualizado", "Actualizado","P sherman calle ACTUALIZADO", 99999, "X/XXX/XXXX");

        ps.crearTabla();

        ps.guardarPaciente(paciente1);
        ps.guardarPaciente(pacienteX);

        ps.actualizarPaciente(pacienteX);
    }

    @org.junit.jupiter.api.Test
    void listarPaciente() throws SQLException {
        Paciente paciente1 = new Paciente("userP1", "passP1", "Dolores", "cadera","P sherman calle wallaby 42 sydney", 10100, "8/nov/2022");
        Paciente paciente2 = new Paciente("userP2", "passP2", "Juanito", "rodilla","Calle 123 numero 123",20200,"9/nov/2022");
        Paciente paciente3 = new Paciente("userP3", "passP3", "Marcelo", "suckma", "Streetway to heaven",30300,"10/nov/2022");

        ps.crearTabla();

        ps.guardarPaciente(paciente1);
        ps.guardarPaciente(paciente2);
        ps.guardarPaciente(paciente3);

        System.out.println(ps.ListarPaciente(paciente2.getDNI()));
    }

}
