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
@Table(name = "encuesta")
public class Encuesta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_encuesta")
    Integer idEncuesta;
    String nombre_encuesta;
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Pregunta> preguntas;
}
