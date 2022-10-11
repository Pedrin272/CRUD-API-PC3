package com.example.pcr3.projeto.dominio.Usuario;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsuarioController {

    private UsuarioRepository userRepository;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<UsuarioModel>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<UsuarioModel>> list(
            @RequestParam Optional<Sort> sort,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<Integer> page) {
        PageRequest pageable = PageRequest.of(page.orElse(0), size.orElse(10), sort.orElse(Sort.unsorted()));
        return ResponseEntity.ok(userRepository
                .findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> save(@RequestBody UsuarioModel UsuarioModel) {
        return ResponseEntity.ok(userRepository.save(UsuarioModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> update(@PathVariable Long id, @RequestBody UsuarioModel UsuarioModel) {
        if (userRepository.existsById(id)) {
            UsuarioModel.setId(id);
            return ResponseEntity.ok(userRepository.save(UsuarioModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
