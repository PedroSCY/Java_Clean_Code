package scy.revisao.backend.infrastructure.controller.response;

import lombok.*;
import scy.revisao.backend.core.model.enums.Categoria;
import scy.revisao.backend.core.model.produto.Produto;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoResponseDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private Date inseridoEm;
    private Categoria categoria;
    private String idUsuario;
}
