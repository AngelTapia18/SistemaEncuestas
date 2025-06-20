package atapia.demos.sisencuestas.CapaNegocio.Services;

import atapia.demos.sisencuestas.CapaModelo.DTO.EncuestaDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Encuesta;
import atapia.demos.sisencuestas.CapaModelo.Mappers.EncuestaMapper;
import atapia.demos.sisencuestas.CapaNegocio.Interfaces.IEncuestaService;
import atapia.demos.sisencuestas.CapaPersistencia.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncuestaService implements IEncuestaService {
    @Autowired
    EncuestaRepository encuestaRepository;
    @Autowired
    EncuestaMapper encuestaMapper;

    @Override
    public List<EncuestaDTO> listar() {
        return this.encuestaRepository.findAll().stream().map(this.encuestaMapper::encuestaToDTO).toList();
    }

    @Override
    public EncuestaDTO buscarPorId(Integer idEncuesta) {
        return this.encuestaRepository.findById(idEncuesta).map(this.encuestaMapper::encuestaToDTO).orElse(null);
    }

    @Override
    public EncuestaDTO agregarActualizar(EncuestaDTO encuestaDto) {
        Encuesta encuesta = this.encuestaMapper.encuestaDTOtoEntity(encuestaDto);
        return this.encuestaMapper.encuestaToDTO(this.encuestaRepository.save(encuesta));
    }

    @Override
    public void eliminarPorId(Integer idEncuesta) {
        this.encuestaRepository.deleteById(idEncuesta);
    }
}
