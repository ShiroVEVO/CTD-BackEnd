package AdrianOlmos.ProyectoFinalBack.Controlador;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;
import AdrianOlmos.ProyectoFinalBack.Modelo.TurnoDTO;
import AdrianOlmos.ProyectoFinalBack.Repositorio.Implementaciones.TurnoDAOH2;
import AdrianOlmos.ProyectoFinalBack.Servicio.OdontologoServicio;
import AdrianOlmos.ProyectoFinalBack.Servicio.TurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoControlador {
    private final TurnoServicio turnoService;

    @Autowired
    public TurnoControlador(TurnoServicio turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTurnos() throws SQLException {
        ResponseEntity response;
        if(turnoService.listarTurnos() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(turnoService.listarTurnos(),HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTurno(@PathVariable("id") Integer id) throws SQLException {
        ResponseEntity response = null;
        if(turnoService.ListarTurno(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(turnoService.ListarTurno(id),HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/guardar")
    public ResponseEntity guardarTurno(@RequestBody TurnoDTO turno) throws SQLException {
        ResponseEntity response;
        if(turnoService.ListarTurno(turno.getMatricula()) != null){
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            response = new ResponseEntity(turnoService.guardarTurno(turno), HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarTurno(@PathVariable("id") Integer id) throws SQLException {
        ResponseEntity response;
        if(turnoService.ListarTurno(id) == null){
            response = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }else{
            turnoService.eliminarTurno(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        return response;
    }
}
