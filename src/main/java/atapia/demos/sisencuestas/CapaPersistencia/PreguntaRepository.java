package atapia.demos.sisencuestas.CapaPersistencia;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    List<Pregunta> findByEncuesta_idEncuesta(Integer idEncuesta);
//    Optional<Pregunta> findBypregunta_idPreguntaAndEncuesta_idEncuesta(Integer idPregunta, Integer idEncuesta);
//    Optional<Pregunta> findByEncuesta_idEncuesta(Integer idEncuesta);
}
