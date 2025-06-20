package atapia.demos.sisencuestas.CapaPersistencia;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {
}
