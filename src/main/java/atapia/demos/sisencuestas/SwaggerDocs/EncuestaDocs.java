package atapia.demos.sisencuestas.SwaggerDocs;

import atapia.demos.sisencuestas.CapaModelo.DTO.EncuestaDTO;
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
    name = "Encuestas",
    description = "Operaciones relacionadas con las encuestas registradas"
)
public interface EncuestaDocs {

    @Operation(
            summary = "Obtener listado de todas las encuestas",
            description = "Este endpoint devuelve una lista de todas las encuestas registrados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista obtenida correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EncuestaDTO.class)
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
    List<EncuestaDTO> listarEncuestas();

    @Operation(
            summary = "Buscar Empresa por ID",
            description = "Este endpoint devuelve un objeto JSON con la informacion de una empresa especificada por su id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Datos de la empresa obtenidos",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EncuestaDTO.class)
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
    ResponseEntity<EncuestaDTO> buscarEncuestaPorId(@PathVariable int id) throws Exception;

    @Operation(
            summary = "Agregar nueva encuesta",
            description = "Este endpoint permite agregar una nueva encuesta a la base de datos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro almacenado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EncuestaDTO.class)
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
    ResponseEntity<EncuestaDTO> agregarEncuesta(@RequestBody EncuestaDTO encuestaDto) throws Exception;

    @Operation(
            summary = "Actualizar la informacion de la encuesta por su ID",
            description = "Este endpoint permite actualizar una encuesta con informacion desde JSON",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro actualizado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EncuestaDTO.class)
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
    ResponseEntity<EncuestaDTO> actualizarEncuesta(@PathVariable int id, @RequestBody EncuestaDTO encuestaRecibida) throws Exception;


    @Operation(
            summary = "Elimina la informacion de una encuesta y su informacion asociada",
            description = "Este endpoint permite eliminar los datos relacionados a la encuesta por el ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro eliminado correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EncuestaDTO.class)
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
