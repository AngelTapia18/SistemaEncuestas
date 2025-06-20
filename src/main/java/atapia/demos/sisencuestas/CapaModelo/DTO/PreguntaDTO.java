package atapia.demos.sisencuestas.CapaModelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaDTO {
    Integer id_pregunta;
    String nombre_pregunta;
    EncuestaDTO encuesta;
}
