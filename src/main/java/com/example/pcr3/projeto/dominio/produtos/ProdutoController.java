package com.example.pcr3.projeto.dominio.produtos;

import com.example.pcr3.projeto.dominio.transacao.TransacaoModel;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public ResponseEntity<ProdutoModel> save( @RequestBody ProdutoModel produtoModel) {
        return ResponseEntity.ok(produtoRepository.save(produtoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
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
