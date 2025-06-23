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
@Table(name = "opcion")
public class Opcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_opcion")
    Integer idOpcion;
    String nombre_opcion;
    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta")
    Pregunta pregunta;
}
