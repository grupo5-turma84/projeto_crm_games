package com.generation.crmgames.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.generation.crmgames.model.Usuario;
import com.generation.crmgames.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/produto/{produto}")
    public ResponseEntity<List<Usuario>> getByProduto(@PathVariable String produto) {
        return ResponseEntity.ok(usuarioRepository.findAllByProdutoInteresseContainingIgnoreCase(produto));
    }

    // 4. CADASTRAR USUÁRIO com Validação Customizada por Tipo
    @PostMapping
    public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario) {
        
        // Verifica se é CLIENTE usando lógica manual (evitando métodos restritos de String)
        if (usuario.getTipo() != null && usuario.getTipo().equalsIgnoreCase("CLIENTE")) {
            // Se for Cliente, o produto não pode ser nulo e nem estar vazio
            if (usuario.getProdutoInteresse() == null || usuario.getProdutoInteresse().length() == 0) {
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Para usuários do tipo CLIENTE, o produto de interesse é obrigatório!"
                );
            }
        }
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRepository.save(usuario));
    }

    // 5. ATUALIZAR USUÁRIO com a mesma validação
    @PutMapping
    public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.findById(usuario.getId())
                .map(resposta -> {
                    // Aplica a mesma regra de negócio na atualização
                    if (usuario.getTipo() != null && usuario.getTipo().equalsIgnoreCase("CLIENTE")) {
                        if (usuario.getProdutoInteresse() == null || usuario.getProdutoInteresse().length() == 0) {
                            throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Para usuários do tipo CLIENTE, o produto de interesse é obrigatório!"
                            );
                        }
                    }
                    return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        usuarioRepository.deleteById(id);
    }
}
