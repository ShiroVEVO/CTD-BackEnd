package AdrianOlmos.ProyectoFinalBack.Controlador;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private final IDao odontologoService;

    @Autowired
    public OdontologoControlador(IDao odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping(value="/todo")
    public List<Odontologo> listarOdontologos() throws SQLException {
        return odontologoService.listarTodos();
    }

    @PostMapping("/guardar")
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo) throws SQLException {
        return (Odontologo) odontologoService.agregar(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable("id") Integer id) throws SQLException {
        return (Odontologo) odontologoService.listar(id);
    }

    @PutMapping("/actualizar/{id}")
    public void actualizarOdontologo(@PathVariable("id") Integer id){
        //code
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarOdontologo(@PathVariable("id") Integer id){
        //code
    }

}
