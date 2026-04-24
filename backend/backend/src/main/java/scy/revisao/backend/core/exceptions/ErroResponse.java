package scy.revisao.backend.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroResponse {
    private String mensagem;
}
