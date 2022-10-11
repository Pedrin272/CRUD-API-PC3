package com.example.pcr3.projeto.dominio.transacao;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<TransacaoModel>> findAll() {
        return ResponseEntity.ok(transacaoRepository.findAll());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<TransacaoModel>> list(
            @RequestParam Optional<Sort> sort,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<Integer> page) {
                Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10), sort.orElse(Sort.unsorted()));

        return  ResponseEntity.ok(transacaoRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<TransacaoModel> save(@RequestBody TransacaoModel transacaoModel) {
        return ResponseEntity.ok(transacaoRepository.save(transacaoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (transacaoRepository.existsById(id)) {
            transacaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransacaoModel> update(@PathVariable Long id, @RequestBody TransacaoModel transacaoModel) {
        if (transacaoRepository.existsById(id)) {
            transacaoModel.setId(id);
            return ResponseEntity.ok(transacaoRepository.save(transacaoModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
