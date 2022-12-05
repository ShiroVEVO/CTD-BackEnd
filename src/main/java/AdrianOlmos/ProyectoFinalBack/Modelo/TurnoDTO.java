package AdrianOlmos.ProyectoFinalBack.Modelo;

public class TurnoDTO {
    public int numTurno;
    public String hora;
    public String fecha;
    public int matricula;
    public String nombreOdontologo;
    public int DNI;
    public String nombrePaciente;

    public TurnoDTO(int nt, String h, String f, int m, String no, int d, String np) {
        this.numTurno = nt;
        this.hora = h;
        this.fecha = f;
        this.matricula = m;
        this.DNI = d;
        this.nombreOdontologo = no;
        this.nombrePaciente = np;
    }

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

    public String getNombreOdontologo() {
        return nombreOdontologo;
    }

    public void setNombreOdontologo(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        return "TurnoDTO{" +
                "numTurno=" + numTurno +
                ", hora='" + hora + '\'' +
                ", fecha='" + fecha + '\'' +
                ", matricula=" + matricula +
                ", nombreOdontologo='" + nombreOdontologo + '\'' +
                ", DNI=" + DNI +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                '}';
    }
}
