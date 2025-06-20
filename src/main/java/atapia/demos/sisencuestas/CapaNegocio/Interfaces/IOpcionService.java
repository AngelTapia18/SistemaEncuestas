package atapia.demos.sisencuestas.CapaNegocio.Interfaces;

import atapia.demos.sisencuestas.CapaModelo.DTO.OpcionDTO;

import java.util.List;

public interface IOpcionService {
    List<OpcionDTO> listar();
    OpcionDTO buscarPorId(Integer idOpcion);
    OpcionDTO agregarActualizar(OpcionDTO opcion);
    void eliminarPorId(Integer idOpcion);
}
