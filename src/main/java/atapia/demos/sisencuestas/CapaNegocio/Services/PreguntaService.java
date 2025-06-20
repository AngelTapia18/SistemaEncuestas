package atapia.demos.sisencuestas.CapaNegocio.Services;

import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Pregunta;
import atapia.demos.sisencuestas.CapaModelo.Mappers.PreguntaMapper;
import atapia.demos.sisencuestas.CapaNegocio.Interfaces.IPreguntaService;
import atapia.demos.sisencuestas.CapaPersistencia.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaService implements IPreguntaService {
    @Autowired
    PreguntaRepository preguntaRepository;
    @Autowired
    PreguntaMapper preguntaMapper;

    @Override
    public List<PreguntaDTO> listar() {
        return this.preguntaRepository.findAll().stream().map(this.preguntaMapper::preguntaToDTO).toList();
    }

    @Override
    public PreguntaDTO buscarPorId(Integer idPregunta) {
        return this.preguntaRepository.findById(idPregunta).map(this.preguntaMapper::preguntaToDTO).orElse(null);
    }

    @Override
    public List<PreguntaDTO> buscarPreguntasPorEncuesta(Integer idEncuesta) {
        return this.preguntaRepository.findByEncuesta_idEncuesta(idEncuesta).stream().map(this.preguntaMapper::preguntaToDTO).collect(Collectors.toList());
    }

    @Override
    public PreguntaDTO agregarActualizar(PreguntaDTO preguntaDto) {
        Pregunta pregunta = this.preguntaMapper.preguntaDTOtoEntity(preguntaDto);
        return this.preguntaMapper.preguntaToDTO(this.preguntaRepository.save(pregunta));
    }

    @Override
    public void eliminarPorId(Integer idPregunta) {
        this.preguntaRepository.deleteById(idPregunta);
    }
}
