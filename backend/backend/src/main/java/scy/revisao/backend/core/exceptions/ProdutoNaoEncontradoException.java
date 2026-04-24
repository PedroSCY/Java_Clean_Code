package scy.revisao.backend.core.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException(){
        super("Produto não encontrado");
    }

}
