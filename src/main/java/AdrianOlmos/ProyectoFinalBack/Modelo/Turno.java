package AdrianOlmos.ProyectoFinalBack.Modelo;

import jakarta.persistence.*;

public class Turno {

    private int ID;

    private Odontologo ondontologo;

    //@Column @OneToOne(mappedBy = "turno") @JsonIgnore
    private Paciente paciente;

    public Turno(int ID, Odontologo ondontologo, Paciente paciente) {
        this.ID = ID;
        this.ondontologo = ondontologo;
        this.paciente = paciente;
    }

    //-------------------------------GETTERS & SETTERS---------------------------

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Odontologo getOndontologo() {
        return ondontologo;
    }

    public void setOndontologo(Odontologo ondontologo) {
        this.ondontologo = ondontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    //---------------------------------TO STRING --------------------------------

    @Override
    public String toString() {
        return "Turno{" +
                "ID=" + ID +
                ", ondontologo=" + ondontologo +
                ", paciente=" + paciente +
                '}';
    }
}