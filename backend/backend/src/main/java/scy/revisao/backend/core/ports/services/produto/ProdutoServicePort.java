package scy.revisao.backend.core.ports.services.produto;

import scy.revisao.backend.core.model.produto.Produto;

import java.util.List;

public interface ProdutoServicePort {
    public List<Produto> buscarTodos();
    public Produto buscarPorId(Integer id);
    public Produto criar(Produto produto);
    public Produto atualizar(Integer id, Produto produto);
    public Produto deletar(Integer id);
}
