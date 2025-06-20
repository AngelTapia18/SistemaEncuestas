package atapia.demos.sisencuestas.CapaModelo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpcionDTO {
    Integer idOpcion;
    String nombre_opcion;
    PreguntaDTO pregunta;
}
