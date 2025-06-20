package atapia.demos.sisencuestas.CapaPersistencia;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    List<Pregunta> findByEncuesta_idEncuesta(Integer idEncuesta);
}
