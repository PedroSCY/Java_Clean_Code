package scy.revisao.backend.infrastructure.persistence.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import scy.revisao.backend.infrastructure.persistence.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
}
