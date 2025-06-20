package atapia.demos.sisencuestas.CapaPresentacion.Controllers;


import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;
import atapia.demos.sisencuestas.CapaNegocio.Services.PreguntaService;
import atapia.demos.sisencuestas.SwaggerDocs.PreguntasDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sistema-encuestas-app")
public class PreguntaController implements PreguntasDocs {
    @Autowired
    PreguntaService preguntaService;

    @GetMapping("/api/v1/preguntas")
    public List<PreguntaDTO> listarPreguntas() {
        return this.preguntaService.listar();
    }

    @GetMapping("/api/v1/pregunta/{id}")
    public ResponseEntity<PreguntaDTO> buscarPreguntaPorId(@PathVariable int id) throws Exception{
        PreguntaDTO preguntaDTO = this.preguntaService.buscarPorId(id);
        if (preguntaDTO != null){
            return ResponseEntity.ok(preguntaDTO);
        }else{
            throw new Exception("No se encontro el id: "+ id);
        }
    }

    @GetMapping("/api/v1/preguntas/encuesta/{id}")
    public List<PreguntaDTO> buscarPreguntasPorEncuesta(@PathVariable int id){
        return this.preguntaService.buscarPreguntasPorEncuesta(id);
    }

    @PostMapping("/api/v1/pregunta")
    public ResponseEntity<PreguntaDTO> agregarPregunta(@RequestBody PreguntaDTO preguntaDto) throws Exception{
        PreguntaDTO pregunta = this.preguntaService.agregarActualizar(preguntaDto);
        if(pregunta != null){
            return ResponseEntity.ok(pregunta);
        }else{
            throw new Exception("Error al agregar pregunta");
        }
    }

    @PutMapping("/api/v1/pregunta/{id}")
    public ResponseEntity<PreguntaDTO> actualizarPregunta(@PathVariable int id, @RequestBody PreguntaDTO preguntaRecibida) throws Exception{
        PreguntaDTO preguntaDTO = this.preguntaService.buscarPorId(id);
        if (preguntaDTO != null){
            preguntaDTO.setNombre_pregunta(preguntaRecibida.getNombre_pregunta());
            preguntaDTO = this.preguntaService.agregarActualizar(preguntaDTO);
            return ResponseEntity.ok(preguntaDTO);
        }else{
            throw new Exception("No se pudo editar el registro por que no existe en la base de datos");
        }
    }

    @DeleteMapping("/api/v1/pregunta/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEncuesta(@PathVariable int id) throws Exception{
        PreguntaDTO preguntaDTO = this.preguntaService.buscarPorId(id);
        if (preguntaDTO != null){
            this.preguntaService.eliminarPorId(preguntaDTO.getId_pregunta());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Eliminado", true);
            return ResponseEntity.ok(respuesta);
        }else{
            throw new Exception("No se encontro el id: "+ id);
        }
    }
}
