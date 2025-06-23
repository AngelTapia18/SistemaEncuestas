package atapia.demos.sisencuestas.CapaNegocio.Interfaces;

import atapia.demos.sisencuestas.CapaModelo.DTO.EncuestaDTO;

import java.util.List;

public interface IEncuestaService {
    List<EncuestaDTO> listar();
    EncuestaDTO buscarPorId(Integer idEncuesta);
    EncuestaDTO agregarActualizar(EncuestaDTO encuesta);
    void eliminarPorId(Integer idEncuesta);
}
