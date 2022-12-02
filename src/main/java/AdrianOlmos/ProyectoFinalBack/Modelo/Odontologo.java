package AdrianOlmos.ProyectoFinalBack.Modelo;

public class Odontologo extends Usuario {
    public int matricula;

    public Odontologo(String u, String p, String n, String a, int m){
        super(u,p,n,a);
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
                "user='" + this.getUser() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido='" + this.getApellido() + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
