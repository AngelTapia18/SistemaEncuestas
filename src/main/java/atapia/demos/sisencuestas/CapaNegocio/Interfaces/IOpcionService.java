package atapia.demos.sisencuestas.CapaNegocio.Interfaces;

import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;

import java.util.List;

public interface IOpcionService {
    List<OpcionDTO> listar();
    OpcionDTO buscarPorId(Integer idOpcion);
    List<OpcionDTO> buscarOpcionesPorPregunta(Integer idEncuesta);
    OpcionDTO agregarActualizar(OpcionDTO opcion, Integer idPregunta);
    void eliminarPorId(Integer idOpcion);
}
