package AdrianOlmos.ProyectoFinalBack.Modelo;

public class Turno {
    public int numTurno;
    public Odontologo ondontologo;
    public Paciente paciente;

    public Turno(int numTurno, Odontologo ondontologo, Paciente paciente) {
        this.numTurno = numTurno;
        this.ondontologo = ondontologo;
        this.paciente = paciente;
    }

    //-------------------------------GETTERS & SETTERS---------------------------

    public int getNumTurno() {
        return numTurno;
    }

    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
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
                "numTurno=" + this.getNumTurno() +
                ", ondontologo=" + this.getOndontologo() +
                ", paciente=" + this.getPaciente() +
                '}';
    }
}