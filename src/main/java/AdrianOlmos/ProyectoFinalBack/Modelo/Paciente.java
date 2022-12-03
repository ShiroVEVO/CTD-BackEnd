package AdrianOlmos.ProyectoFinalBack.Modelo;

import jakarta.persistence.*;

import java.util.Date;

public class Paciente extends Usuario{
    public int DNI;
    public String domicilio;
    public String fechaAlta;

    public Paciente(String r, String u, String p, String n, String a,String d, int dni, String fa) {
        super(r, u, p, n, a);
        this.domicilio = d;
        this.DNI = dni;
        this.fechaAlta = fa;
    }

    //-------------------------------GETTERS & SETTERS---------------------------

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    //---------------------------------TO STRING --------------------------------

    @Override
    public String toString() {
        return "Paciente{" +
                "role='" + this.getROLE() +
                ", user='" + this.getUser() +
                ", password='" + this.getPassword() +
                ", nombre='" + this.getNombre() +
                ", apellido='" + this.getApellido() +
                ", domicilio='" + this.getDomicilio() +
                ", DNI=" + this.getDNI() +
                ", fechaAlta=" + this.getFechaAlta() +
                '}';
    }
}
