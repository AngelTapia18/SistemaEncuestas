package atapia.demos.sisencuestas.CapaNegocio.Services;

import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;
import atapia.demos.sisencuestas.CapaModelo.Entidades.Opcion;
import atapia.demos.sisencuestas.CapaModelo.Mappers.OpcionMapper;
import atapia.demos.sisencuestas.CapaNegocio.Interfaces.IOpcionService;
import atapia.demos.sisencuestas.CapaPersistencia.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionService implements IOpcionService {
    @Autowired
    OpcionRepository opcionRepository;
    @Autowired
    OpcionMapper opcionMapper;

    @Override
    public List<OpcionDTO> listar() {
        return this.opcionRepository.findAll().stream().map(this.opcionMapper::opcionToDTO).toList();
    }

    @Override
    public OpcionDTO buscarPorId(Integer idOpcion) {
        return this.opcionRepository.findById(idOpcion).map(this.opcionMapper::opcionToDTO).orElse(null);
    }

    @Override
    public OpcionDTO agregarActualizar(OpcionDTO opcionDto) {
        Opcion opcion = this.opcionMapper.opcionDTOToEntity(opcionDto);
        return this.opcionMapper.opcionToDTO(this.opcionRepository.save(opcion));
    }

    @Override
    public void eliminarPorId(Integer idOpcion) {
        this.opcionRepository.deleteById(idOpcion);
    }
}
