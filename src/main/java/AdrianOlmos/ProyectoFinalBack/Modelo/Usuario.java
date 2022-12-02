package AdrianOlmos.ProyectoFinalBack.Modelo;

public abstract class Usuario {
    public String user;
    public String password;
    public String nombre;
    public String apellido;

    public Usuario(String u, String p, String n, String a){
        this.user = u;
        this.password = p;
        this.nombre = n;
        this.apellido = a;
    }

    public boolean login(String user, String password){
        //Escribir Logica de login
        return false;
    }

    //-------------------------------GETTERS & SETTERS---------------------------
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}