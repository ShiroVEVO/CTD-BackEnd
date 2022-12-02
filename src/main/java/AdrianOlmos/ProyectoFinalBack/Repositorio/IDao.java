package AdrianOlmos.ProyectoFinalBack.Repositorio;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;

import java.sql.SQLException;
import java.util.List;
public interface IDao<T> {//extends CrudRepository<T,Integer> {
    public void CrearTabla() throws SQLException;
    public T listar(int id) throws SQLException;
    public T agregar(T t) throws SQLException;
    public void eliminar(int id) throws SQLException;
    public T actualizar(T t) throws SQLException;
    public List<T> listarTodos() throws SQLException;
}
