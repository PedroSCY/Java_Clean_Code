package scy.revisao.backend.core.model.produto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import scy.revisao.backend.core.model.enums.Categoria;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private Date inseridoEm;
    private Categoria categoria;
    private String idUsuario;
}
