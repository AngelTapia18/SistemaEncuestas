package atapia.demos.sisencuestas.CapaPersistencia;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpcionRepository extends JpaRepository<Opcion, Integer> {
    List<Opcion> findByPregunta_idPregunta(Integer idPregunta);
}
