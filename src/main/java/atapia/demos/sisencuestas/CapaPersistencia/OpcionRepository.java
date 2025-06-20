package atapia.demos.sisencuestas.CapaPersistencia;

import atapia.demos.sisencuestas.CapaModelo.Entidades.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionRepository extends JpaRepository<Opcion, Integer> {
}
