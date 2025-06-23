package atapia.demos.sisencuestas.CapaModelo.Mappers;

import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Opcion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpcionMapper {
    OpcionDTO opcionToDTO(Opcion opcion);
    Opcion opcionDTOToEntity(OpcionDTO opcionDto);
}
