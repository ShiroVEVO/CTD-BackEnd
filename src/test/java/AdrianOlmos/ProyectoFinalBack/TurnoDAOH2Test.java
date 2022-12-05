package AdrianOlmos.ProyectoFinalBack;

import AdrianOlmos.ProyectoFinalBack.Modelo.TurnoDTO;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones.TurnoDAOH2;
import AdrianOlmos.ProyectoFinalBack.Servicio.TurnoServicio;

import java.sql.SQLException;

public class TurnoDAOH2Test {
    TurnoServicio ts = new TurnoServicio(new TurnoDAOH2());

    @org.junit.jupiter.api.Test
    void crearTabla() throws SQLException {
        ts.crearTabla();
    }

    @org.junit.jupiter.api.Test
    void agregarTurnos() throws SQLException {
        TurnoDTO turno1 = new TurnoDTO(10,"10:00am", "10/12/2022",10,null,1020,null);
        ts.crearTabla();
        ts.guardarTurno(turno1);
    }

    @org.junit.jupiter.api.Test
    void listarTurnos() throws SQLException {
        TurnoDTO turno1 = new TurnoDTO(10,"10:00am", "10/12/2022",58285,null,101004318,null);
        TurnoDTO turno2 = new TurnoDTO(20,"12:00pm", "11/11/2000",10,null,1020,null);
        TurnoDTO turno3 = new TurnoDTO(30,"14:00pm", "12/10/2021",10100,null,50500,null);

        ts.crearTabla();


        ts.guardarTurno(turno2);
        ts.guardarTurno(turno3);
        ts.guardarTurno(turno1);

        ts.listarTurnos();
    }

    @org.junit.jupiter.api.Test
    void eliminarPaciente() throws SQLException {
        TurnoDTO turno1 = new TurnoDTO(10,"10:00am", "10/12/2022",58285,null,101004318,null);
        TurnoDTO turno2 = new TurnoDTO(20,"12:00pm", "11/11/2000",10,null,1020,null);
        TurnoDTO turno3 = new TurnoDTO(30,"14:00pm", "12/10/2021",10100,null,50500,null);

        ts.crearTabla();


        ts.guardarTurno(turno2);
        ts.guardarTurno(turno3);
        ts.guardarTurno(turno1);

        ts.listarTurnos();

        ts.eliminarTurno(turno2.getNumTurno());
    }

    @org.junit.jupiter.api.Test
    void listarPaciente() throws SQLException {
        TurnoDTO turno1 = new TurnoDTO(10,"10:00am", "10/12/2022",58285,null,101004318,null);
        TurnoDTO turno2 = new TurnoDTO(20,"12:00pm", "11/11/2000",10,null,1020,null);
        TurnoDTO turno3 = new TurnoDTO(30,"14:00pm", "12/10/2021",10100,null,50500,null);

        ts.crearTabla();


        ts.guardarTurno(turno2);
        ts.guardarTurno(turno3);
        ts.guardarTurno(turno1);

        ts.listarTurnos();

        System.out.println(ts.ListarTurno(turno2.getNumTurno()));
    }

}
