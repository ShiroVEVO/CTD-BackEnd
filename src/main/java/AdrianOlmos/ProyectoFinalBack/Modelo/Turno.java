package AdrianOlmos.ProyectoFinalBack.Modelo;

public class Turno {
    public int numTurno;
    public String hora;
    public String fecha;
    public int matricula;
    public int DNI;

    public Turno(int numTurno, String hora, String fecha, int matricula, int dni) {
        this.numTurno = numTurno;
        this.hora = hora;
        this.fecha = fecha;
        this.matricula = matricula;
        this.DNI = dni;
    }

    //-------------------------------GETTERS & SETTERS---------------------------

    public int getNumTurno() {
        return numTurno;
    }

    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }


    //---------------------------------TO STRING --------------------------------

    @Override
    public String toString() {
        return "Turno{" +
                "numTurno=" + this.getNumTurno() +
                ", hora=" + this.getHora() +
                ", fecha=" + this.getFecha() +
                ", matricula=" + this.getMatricula() +
                ", DNI=" + this.getDNI() +
                '}';
    }
}