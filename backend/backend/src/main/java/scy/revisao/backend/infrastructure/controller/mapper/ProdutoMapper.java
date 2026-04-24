package scy.revisao.backend.infrastructure.controller.mapper;

import org.springframework.stereotype.Component;
import scy.revisao.backend.core.model.produto.Produto;
import scy.revisao.backend.infrastructure.controller.request.ProdutoRequestDTO;
import scy.revisao.backend.infrastructure.controller.response.ProdutoResponseDTO;

@Component
public class ProdutoMapper {

    public Produto toDomain(ProdutoRequestDTO dto) {
        return Produto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .categoria(dto.getCategoria())
                .build();
    }
    public ProdutoResponseDTO toResponse(Produto produto){
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getInseridoEm(),
                produto.getCategoria(),
                produto.getIdUsuario()
        );
    }

}
