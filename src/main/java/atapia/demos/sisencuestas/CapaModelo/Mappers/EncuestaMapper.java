package atapia.demos.sisencuestas.CapaModelo.Mappers;

import atapia.demos.sisencuestas.CapaModelo.DTO.EncuestaDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Encuesta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EncuestaMapper {
    EncuestaDTO encuestaToDTO(Encuesta encuesta);
    Encuesta encuestaDTOtoEntity(EncuestaDTO encuestaDto);
}
