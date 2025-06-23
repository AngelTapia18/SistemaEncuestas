package atapia.demos.sisencuestas.CapaPresentacion.Controllers;

import atapia.demos.sisencuestas.CapaModelo.DTO.EncuestaDTO;
import atapia.demos.sisencuestas.CapaNegocio.Services.EncuestaService;
import atapia.demos.sisencuestas.SwaggerDocs.EncuestaDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sistema-encuestas-app")
public class EncuestaController implements EncuestaDocs {
    @Autowired
    EncuestaService encuestaService;

    @GetMapping("/api/v1/encuestas")
    public List<EncuestaDTO> listarEncuestas() {
        return this.encuestaService.listar();
    }

    @GetMapping("/api/v1/encuesta/{id}")
    public ResponseEntity<EncuestaDTO> buscarEncuestaPorId(@PathVariable int id) throws Exception{
        EncuestaDTO encuestaDTO = this.encuestaService.buscarPorId(id);
        if (encuestaDTO != null){
            return ResponseEntity.ok(encuestaDTO);
        }else{
            throw new Exception("No se encontro el id: "+ id);
        }
    }

    @PostMapping("/api/v1/encuesta")
    public ResponseEntity<EncuestaDTO> agregarEncuesta(@RequestBody EncuestaDTO encuestaDto) throws Exception{
        EncuestaDTO encuesta = this.encuestaService.agregarActualizar(encuestaDto);
        if(encuesta != null){
            return ResponseEntity.ok(encuesta);
        }else{
            throw new Exception("Error al agregar encuesta");
        }
    }

    @PutMapping("/api/v1/encuesta/{id}")
    public ResponseEntity<EncuestaDTO> actualizarEncuesta(@PathVariable int id, @RequestBody EncuestaDTO encuestaRecibida) throws Exception{
        EncuestaDTO encuestaDto = this.encuestaService.buscarPorId(id);
        if (encuestaDto != null){
            encuestaDto.setNombre_encuesta(encuestaRecibida.getNombre_encuesta());
            encuestaDto = this.encuestaService.agregarActualizar(encuestaDto);
            return ResponseEntity.ok(encuestaDto);
        }else{
            throw new Exception("No se pudo editar el registro por que no existe en la base de datos");
        }
    }

    @DeleteMapping("/api/v1/encuesta/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEncuesta(@PathVariable int id) throws Exception{
        EncuestaDTO encuestaDto = this.encuestaService.buscarPorId(id);
        if (encuestaDto != null){
            this.encuestaService.eliminarPorId(encuestaDto.getIdEncuesta());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Eliminado", true);
            return ResponseEntity.ok(respuesta);
        }else{
            throw new Exception("No se encontro el id: "+ id);
        }
    }
}
