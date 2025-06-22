package atapia.demos.sisencuestas.CapaModelo.Entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pregunta")
public class Pregunta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pregunta")
    Integer idPregunta;
    String nombre_pregunta;
    @ManyToOne
    @JoinColumn(name = "id_encuesta", referencedColumnName = "id_encuesta")
    Encuesta encuesta;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.REMOVE, orphanRemoval = false)
    private List<Opcion> opciones;
}
