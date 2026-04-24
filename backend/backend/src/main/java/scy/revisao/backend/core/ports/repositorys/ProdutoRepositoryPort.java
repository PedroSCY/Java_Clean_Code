package scy.revisao.backend.core.ports.repositorys;

import scy.revisao.backend.core.model.produto.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    public List<Produto> buscarTodos();
    public Optional<Produto> buscarPorId(Integer id);
    public Produto salvar(Produto produto);
    public void deletar(Integer id);
}
