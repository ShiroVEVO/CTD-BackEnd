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

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos() throws SQLException{
        ResponseEntity response;
        if(odontologoService.listarOdontologos() == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(odontologoService.listarOdontologos(),HttpStatus.OK);
        }
        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarOdontologo(@PathVariable("id") Integer id) throws SQLException {
        ResponseEntity response = null;
        if(odontologoService.ListarOdontologo(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(odontologoService.ListarOdontologo(id),HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/guardar")
    public ResponseEntity guardarOdontologo(@RequestBody Odontologo odontologo) throws SQLException {
        ResponseEntity response;
        if(odontologoService.ListarOdontologo(odontologo.getMatricula()) != null){
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            response = new ResponseEntity(odontologoService.guardarOdontologo(odontologo),HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrarOdontologo(@PathVariable("id") Integer id) throws SQLException {
        ResponseEntity response;
        if(odontologoService.ListarOdontologo(id) == null){
            response = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }else{
            odontologoService.eliminarOdontologo(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) throws SQLException {
        ResponseEntity response = null;
        System.out.println(odontologo);
        if(odontologoService.ListarOdontologo(odontologo.getMatricula()) == null){
            response = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }else{
            response = new ResponseEntity(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
        }
        return response;
    }



}
