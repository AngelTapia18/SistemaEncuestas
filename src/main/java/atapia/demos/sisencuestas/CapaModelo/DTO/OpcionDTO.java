package atapia.demos.sisencuestas.CapaModelo.DTO;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpcionDTO {
    Integer id_opcion;
    String nombre_opcion;
    PreguntaDTO preguntaDTO;
}
