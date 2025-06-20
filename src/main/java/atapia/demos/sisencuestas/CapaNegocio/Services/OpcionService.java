package atapia.demos.sisencuestas.CapaNegocio.Services;

import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;
import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Opcion;
import atapia.demos.sisencuestas.CapaModelo.Mappers.OpcionMapper;
import atapia.demos.sisencuestas.CapaModelo.Mappers.PreguntaMapper;
import atapia.demos.sisencuestas.CapaNegocio.Interfaces.IOpcionService;
import atapia.demos.sisencuestas.CapaPersistencia.OpcionRepository;
import atapia.demos.sisencuestas.CapaPersistencia.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpcionService implements IOpcionService {
    @Autowired
    OpcionRepository opcionRepository;
    @Autowired
    PreguntaRepository preguntaRepository;
    @Autowired
    OpcionMapper opcionMapper;
    @Autowired
    PreguntaMapper preguntaMapper;

    @Override
    public List<OpcionDTO> listar() {
        return this.opcionRepository.findAll().stream().map(this.opcionMapper::opcionToDTO).toList();
    }

    @Override
    public OpcionDTO buscarPorId(Integer idOpcion) {
        return this.opcionRepository.findById(idOpcion).map(this.opcionMapper::opcionToDTO).orElse(null);
    }

    @Override
    public List<OpcionDTO> buscarOpcionesPorPregunta(Integer idPregunta) {
        return this.opcionRepository.findByPregunta_idPregunta(idPregunta).stream().map(this.opcionMapper::opcionToDTO).collect(Collectors.toList());
    }

    @Override
    public OpcionDTO agregarActualizar(OpcionDTO opcionDto, Integer idPregunta) {
        PreguntaDTO preguntaDTO = this.preguntaRepository.findById(idPregunta).map(this.preguntaMapper::preguntaToDTO).orElse(null);
        opcionDto.setPregunta(preguntaDTO);
        Opcion opcion = this.opcionMapper.opcionDTOToEntity(opcionDto);
        return this.opcionMapper.opcionToDTO(this.opcionRepository.save(opcion));
    }

    @Override
    public void eliminarPorId(Integer idOpcion) {
        this.opcionRepository.deleteById(idOpcion);
    }
}
