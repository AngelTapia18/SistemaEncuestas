package atapia.demos.sisencuestas.CapaModelo.DTO;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Encuesta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaDTO {
    Integer id_pregunta;
    String nombre_pregunta;
    EncuestaDTO encuestaDTO;
}
