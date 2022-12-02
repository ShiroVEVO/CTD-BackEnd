package AdrianOlmos.ProyectoFinalBack.Controlador;

import AdrianOlmos.ProyectoFinalBack.Modelo.Odontologo;

import AdrianOlmos.ProyectoFinalBack.Servicio.OdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/odontologo")
public class OdontologoControlador {
    private final OdontologoServicio odontologoService;

    @Autowired
    public OdontologoControlador(OdontologoServicio odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping(value="/todo")
    public List<Odontologo> listarOdontologos() throws SQLException {
        return odontologoService.listarOdontologos();
    }

    @PostMapping("/guardar")
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo) throws SQLException {
        return odontologoService.guardarOdontologo(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable("id") Integer id) throws SQLException {
        return (Odontologo) odontologoService.ListarOdontologo(id);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarOdontologo(@PathVariable("id") Integer id) throws SQLException {
        ResponseEntity response = null;
        if(odontologoService.ListarOdontologo(id) == null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.eliminarOdontologo(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) throws SQLException {
        ResponseEntity response = null;
        if(odontologoService.ListarOdontologo(odontologo.getMatricula()) == null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
        }
        return response;
    }



}
