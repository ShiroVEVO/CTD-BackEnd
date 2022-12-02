package AdrianOlmos.ProyectoFinalBack.Controlador;

import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Repositorio.IDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteControlador {
    private final IDao pacienteService;

    @Autowired
    public PacienteControlador(IDao pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(value="/todo")
    public List<Paciente> listarOdontologos() throws SQLException {
        return pacienteService.listarTodos();
    }

    @PostMapping("/guardar")
    public Paciente guardarOdontologo(@RequestBody Paciente paciente) throws SQLException {
        return (Paciente) pacienteService.agregar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarOdontologo(@PathVariable("id") Integer id) throws SQLException {
        return (Paciente) pacienteService.listar(id);
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
