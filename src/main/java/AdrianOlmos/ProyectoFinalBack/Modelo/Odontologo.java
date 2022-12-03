package AdrianOlmos.ProyectoFinalBack.Modelo;

public class Odontologo extends Usuario {
    public int matricula;

    public Odontologo(String r, String u, String p, String n, String a, int m){
        super(r,u,p,n,a);
        this.matricula = m;
    }

    //-------------------------------GETTERS & SETTERS---------------------------

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    //-------------------------------.....TO STRING------------------------------

    @Override
    public String toString() {
        return "Odontologo{" +
                "role='" + this.getROLE() +
                ", user='" + this.getUser() +
                ", password='" + this.getPassword() +
                ", nombre='" + this.getNombre() +
                ", apellido='" + this.getApellido() +
                ", matricula=" + this.getMatricula() +
                '}';
    }
}
