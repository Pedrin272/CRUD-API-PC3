package com.example.pcr3.projeto.dominio.produtos;

import com.example.pcr3.projeto.dominio.transacao.TransacaoModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/produtos")
@RestController
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<ProdutoModel>> findAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<ProdutoModel>> list(
            @RequestParam Optional<Sort> sort,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<Integer> page) {
        PageRequest pageable = PageRequest.of(page.orElse(0), size.orElse(10), sort.orElse(Sort.unsorted()));
        return ResponseEntity.ok(produtoRepository
                .findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> save(@RequestBody ProdutoModel produtoModel) {
        return ResponseEntity.ok(produtoRepository.save(produtoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> update(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        if (produtoRepository.existsById(id)) {
            produtoModel.setId(id);
            return ResponseEntity.ok(produtoRepository.save(produtoModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
