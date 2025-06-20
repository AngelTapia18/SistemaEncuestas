package atapia.demos.sisencuestas.CapaNegocio.Interfaces;

import atapia.demos.sisencuestas.CapaModelo.DTO.PreguntaDTO;

import java.util.List;

public interface IPreguntaService {
    List<PreguntaDTO> listar();
    PreguntaDTO buscarPorId(Integer idPregunta);
    List<PreguntaDTO> buscarPreguntasPorEncuesta(Integer idEncuesta);
    PreguntaDTO agregarActualizar(PreguntaDTO pregunta);
    void eliminarPorId(Integer idPregunta);
}
