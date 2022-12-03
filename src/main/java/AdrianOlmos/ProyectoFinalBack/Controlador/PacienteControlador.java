package AdrianOlmos.ProyectoFinalBack.Controlador;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;
import AdrianOlmos.ProyectoFinalBack.Modelo.Paciente;
import AdrianOlmos.ProyectoFinalBack.Servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteControlador {
    private final PacienteServicio pacienteService;
    @Autowired
    public PacienteControlador(PacienteServicio pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listarPacientes() throws SQLException {
        return pacienteService.listarPacientes();
    }

    @PostMapping("/guardar")
    public Paciente guardarPaciente(@RequestBody Paciente paciente) throws SQLException {
        return pacienteService.guardarPaciente(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable("id") Integer id) throws SQLException {
        return (Paciente) pacienteService.ListarPaciente(id);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarPaciente(@PathVariable("id") Integer id) throws SQLException {
        ResponseEntity response = null;
        if(pacienteService.ListarPaciente(id) == null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            pacienteService.eliminarPaciente(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizarPaciente(@RequestBody Paciente paciente) throws SQLException {
        ResponseEntity response = null;
        if(pacienteService.ListarPaciente(paciente.getDNI()) == null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(pacienteService.actualizarPaciente(paciente), HttpStatus.OK);
        }
        return response;
    }



}
