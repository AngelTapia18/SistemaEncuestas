package atapia.demos.sisencuestas.CapaModelo.Entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pregunta")
public class Pregunta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_pregunta;
    String nombre_pregunta;
    @ManyToOne
    @JoinColumn(name = "id_encuesta", referencedColumnName = "id_encuesta")
    Encuesta encuesta;
}
