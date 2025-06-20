package atapia.demos.sisencuestas.SwaggerDocs;

import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;
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
    name = "Opciones",
    description = "Operaciones relacionadas con las opciones de las preguntas registradas"
)
public interface OpcionDocs {
    @Operation(
            summary = "Obtener listado de todas las opciones ",
            description = "Este endpoint devuelve una lista de todas las opciones de las preguntas disponibles",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista obtenida correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OpcionDTO.class)
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
    List<OpcionDTO> listarOpciones();

    @Operation(
            summary = "Buscar opcion de pregunta por ID",
            description = "Este endpoint devuelve la informacion de una opcion especificada por su id de opcion",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Datos de la empresa obtenidos",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OpcionDTO.class)
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
    ResponseEntity<OpcionDTO> buscarOpcionPorId(@PathVariable int id) throws Exception;

    @Operation(
            summary = "Agregar nueva opcion a pregunta",
            description = "Este endpoint permite agregar una nueva opcion de respuesta a una pregunta registrada",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro almacenado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OpcionDTO.class)
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
    ResponseEntity<OpcionDTO> agregarPregunta(@RequestBody OpcionDTO opcionDTO) throws Exception;

    @Operation(
            summary = "Actualizar la informacion de la opcion por su ID",
            description = "Este endpoint permite actualizar la informacion de una opcion a una pregunta asociada",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro actualizado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OpcionDTO.class)
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
    ResponseEntity<OpcionDTO> actualizarPregunta(@PathVariable int id, @RequestBody OpcionDTO opcionRecibida) throws Exception;


    @Operation(
            summary = "Elimina la informacion de una opcion",
            description = "Este endpoint permite eliminar una opcion seleccionada por el ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro eliminado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OpcionDTO.class)
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
    ResponseEntity<Map<String, Boolean>> eliminarPregunta(@PathVariable int id) throws Exception;
}
