package scy.revisao.backend.infrastructure.persistence.repository.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import scy.revisao.backend.core.model.produto.Produto;
import scy.revisao.backend.core.ports.repositorys.ProdutoRepositoryPort;
import scy.revisao.backend.infrastructure.persistence.entity.ProdutoEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto){
        return toDomain(produtoRepository.saveAndFlush(toEntity(produto)));
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return  produtoRepository.findById(id).map(entity -> toDomain(entity));
    }

    @Override
    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
        return;
    }

    private ProdutoEntity toEntity(Produto p) {
        return new ProdutoEntity(p.getId(),p.getNome(),p.getDescricao(),p.getPreco(),p.getInseridoEm(),p.getCategoria(),p.getIdUsuario());
    }

    private Produto toDomain(ProdutoEntity e) {
        return new Produto(e.getId(),e.getNome(),e.getDescricao(),e.getPreco(),e.getInseridoEm(),e.getCategoria(),e.getIdUsuario());
    }
}
