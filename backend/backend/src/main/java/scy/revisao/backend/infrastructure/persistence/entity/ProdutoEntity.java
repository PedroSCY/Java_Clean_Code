package scy.revisao.backend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import scy.revisao.backend.core.model.enums.Categoria;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @CreationTimestamp
    @Column(name = "inserido_em", nullable = false)
    private Date inseridoEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "Categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "id_usuario", nullable = false)
    private String idUsuario;

}
