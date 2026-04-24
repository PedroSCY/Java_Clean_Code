package scy.revisao.backend.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scy.revisao.backend.core.model.produto.Produto;
import scy.revisao.backend.core.ports.services.produto.ProdutoService;
import scy.revisao.backend.infrastructure.controller.mapper.ProdutoMapper;
import scy.revisao.backend.infrastructure.controller.request.ProdutoRequestDTO;
import scy.revisao.backend.infrastructure.controller.response.ProdutoResponseDTO;
import scy.revisao.backend.infrastructure.persistence.entity.ProdutoEntity;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        List<Produto> listaDeProdutos = produtoService.buscarTodos();
        List<ProdutoResponseDTO> response = listaDeProdutos.stream().map(mapper::toResponse).toList();
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> listarUm(@PathVariable("id") Integer id){
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponse(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@Valid @RequestBody ProdutoRequestDTO dto){
        Produto novoProduto = mapper.toDomain(dto);
        Produto produtoSalvo = produtoService.criar(novoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(produtoSalvo));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@Valid @RequestBody ProdutoRequestDTO dto, @PathVariable("id") Integer id){
        Produto produtoPraAtualizar = mapper.toDomain(dto);
        Produto produtoAtualizado = produtoService.atualizar(id, produtoPraAtualizar);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(produtoAtualizado));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProdutoResponseDTO> deletar(@PathVariable Integer id){
        Produto produtoDeletado = produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(produtoDeletado));
    }


}
