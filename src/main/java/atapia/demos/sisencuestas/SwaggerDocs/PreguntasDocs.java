package atapia.demos.sisencuestas.SwaggerDocs;

import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@Tag(
    name = "Preguntas",
    description = "Operaciones relacionadas con las preguntas relacionadas a encuestas registradas"
)
public interface PreguntasDocs {
    @Operation(
            summary = "Obtener listado de todas las preguntas",
            description = "Este endpoint devuelve una lista de todas las preguntas registrados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista obtenida correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PreguntaDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
//                                name = "Error",
                                            value = "{ \"Error\": 500, \"Descripcion\": \"No se pudo listar elementos\"}"
                                    )
                            )
                    )
            }
    )
    List<PreguntaDTO> listarPreguntas();

    @Operation(
            summary = "Buscar pregunta por ID",
            description = "Este endpoint devuelve la informacion de una pregunta especificada por su id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Datos de la empresa obtenidos",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PreguntaDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
//                                name = "Error",
                                            value = "{ \"Error\": 500, \"Descripcion\": \"No se puede obtener la informacion\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<PreguntaDTO> buscarPreguntaPorId(@PathVariable int id) throws Exception;

    @Operation(
            summary = "Agregar nueva pregunta",
            description = "Este endpoint permite agregar una nueva pregunta relacionada a una encuesta",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro almacenado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PreguntaDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
//                                name = "Error",
                                            value = "{ \"Error\": 500, \"Descripcion\": \"No se puede obtener la informacion\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<PreguntaDTO> agregarPreguntaAEncuesta(@PathVariable int id, @RequestBody PreguntaDTO preguntaDto) throws Exception;

    @Operation(
            summary = "Actualizar la informacion de la pregunta buscada por su ID",
            description = "Este endpoint permite actualizar la informacion de una pregunta por el id de la pregunta",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro actualizado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PreguntaDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
//                                name = "Error",
                                            value = "{ \"Error\": 500, \"Descripcion\": \"No se puede obtener la informacion\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<PreguntaDTO> actualizarPregunta(@PathVariable int id, @RequestBody PreguntaDTO preguntaRecibida) throws Exception;


    @Operation(
            summary = "Elimina la informacion de una pregunta y su informacion asociada",
            description = "Este endpoint permite eliminar los datos relacionados a la pregunta por el ID de la pregunta",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro eliminado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PreguntaDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
//                                name = "Error",
                                            value = "{ \"Error\": 500, \"Descripcion\": \"No se puede obtener la informacion\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<Map<String, Boolean>> eliminarEncuesta(@PathVariable int id) throws Exception;
}
