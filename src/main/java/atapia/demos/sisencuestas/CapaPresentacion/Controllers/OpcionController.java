package atapia.demos.sisencuestas.CapaPresentacion.Controllers;


import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;
import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;
import atapia.demos.sisencuestas.CapaNegocio.Services.OpcionService;
import atapia.demos.sisencuestas.CapaNegocio.Services.PreguntaService;
import atapia.demos.sisencuestas.SwaggerDocs.OpcionDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sistema-encuestas-app")
@CrossOrigin(origins = "http://localhost:4200")
public class OpcionController implements OpcionDocs {
    @Autowired
    OpcionService opcionService;
    @Autowired
    PreguntaService preguntaService;

    @GetMapping("/api/v1/opciones")
    public List<OpcionDTO> listarOpciones() {
        return this.opcionService.listar();
    }

    @GetMapping("/api/v1/opcion/pregunta/{id}")
    public List<OpcionDTO> buscarOpcionesPorPregunta(@PathVariable int id){
        return this.opcionService.buscarOpcionesPorPregunta(id);
    }

    @GetMapping("/api/v1/opcion/{id}")
    public ResponseEntity<OpcionDTO> buscarOpcionPorId(@PathVariable int id) throws Exception{
        OpcionDTO opcionDTO = this.opcionService.buscarPorId(id);
        if (opcionDTO != null){
            return ResponseEntity.ok(opcionDTO);
        }else{
            throw new Exception("No se encontro el id: "+ id);
        }
    }

    @PostMapping("/api/v1/opcion/pregunta/{id}")
    public ResponseEntity<OpcionDTO> agregarOpcionAPregunta(@PathVariable int id, @RequestBody OpcionDTO opcionDTO) throws Exception{
        PreguntaDTO pregunta = this.preguntaService.buscarPorId(id);
        OpcionDTO opcion = this.opcionService.agregarActualizar(opcionDTO, pregunta.getIdPregunta());
        if(opcion != null){
            return ResponseEntity.ok(opcion);
        }else{
            throw new Exception("Error al agregar opcion");
        }
    }

    @PutMapping("/api/v1/opcion/{id}")
    public ResponseEntity<OpcionDTO> actualizarOpcion(@PathVariable int id, @RequestBody OpcionDTO opcionRecibida) throws Exception{
        OpcionDTO opcionDTO = this.opcionService.buscarPorId(id);
        if (opcionDTO != null){
            opcionDTO.setNombre_opcion(opcionRecibida.getNombre_opcion());
            opcionDTO = this.opcionService.agregarActualizar(opcionDTO, opcionDTO.getPregunta().getIdPregunta());
            return ResponseEntity.ok(opcionDTO);
        }else{
            throw new Exception("No se pudo editar el registro por que no existe en la base de datos");
        }
    }

    @DeleteMapping("/api/v1/opcion/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarOpcion(@PathVariable int id) throws Exception{
        OpcionDTO opcionDTO = this.opcionService.buscarPorId(id);
        if (opcionDTO != null){
            this.opcionService.eliminarPorId(opcionDTO.getIdOpcion());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Eliminado", true);
            return ResponseEntity.ok(respuesta);
        }else{
            throw new Exception("No se encontro el id: "+ id);
        }
    }
}
