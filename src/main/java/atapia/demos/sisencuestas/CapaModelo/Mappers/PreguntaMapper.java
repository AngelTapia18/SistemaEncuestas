package atapia.demos.sisencuestas.CapaModelo.Mappers;

import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Pregunta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreguntaMapper {
    PreguntaDTO preguntaToDTO(Pregunta pregunta);
    Pregunta preguntaDTOtoEntity(PreguntaDTO preguntaDto);
}
