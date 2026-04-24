package scy.revisao.backend.infrastructure.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import scy.revisao.backend.core.model.enums.Categoria;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatorio")
    @Size(min=3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Size( max = 255, message = "Descrição deve ter no máximo 100 caracteres")
    @NotBlank(message = "Descrição é obrigatoria")
    private String descricao;

    @NotNull(message = "Preço é obrigatorio")
    @Positive(message = "Preço deve ser povitivo")
    private Double preco;

    @NotNull(message = "Categoria é obrigatoria")
    private Categoria categoria;

}
