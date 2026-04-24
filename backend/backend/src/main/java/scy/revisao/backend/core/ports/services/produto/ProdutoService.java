package scy.revisao.backend.core.ports.services.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import scy.revisao.backend.core.exceptions.ProdutoNaoEncontradoException;
import scy.revisao.backend.core.model.produto.Produto;
import scy.revisao.backend.core.ports.repositorys.ProdutoRepositoryPort;
import scy.revisao.backend.infrastructure.persistence.repository.produto.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    @Override
    public Produto criar(Produto produto){
        return produtoRepository.salvar(produto);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.buscarTodos();
    }

    @Override
    public Produto buscarPorId(Integer id){
        return produtoRepository.buscarPorId(id).orElseThrow(ProdutoNaoEncontradoException::new);
    }

    @Override
    public Produto atualizar(Integer id, Produto produto) {
        Produto produtoOriginal = this.buscarPorId(id);
        produtoOriginal.setNome(produto.getNome());
        produtoOriginal.setDescricao(produto.getDescricao());
        produtoOriginal.setCategoria(produto.getCategoria());
        produtoOriginal.setPreco(produto.getPreco());
        return produtoRepository.salvar(produtoOriginal);
    }

    @Override
    public Produto deletar(Integer id) {
        Produto produto = this.buscarPorId(id);
        produtoRepository.deletar(id);
        return produto;
    }
}
