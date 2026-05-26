package com.generation.crmgames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.generation.crmgames.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	/**
     * REGRA DE NEGÓCIO: Busca usuários interessados em um jogo ou console específico.
     * O mecanismo 'ContainingIgnoreCase' garante que a busca funcione mesmo se o 
     * usuário digitar em maiúsculas ou minúsculas (Ex: "ps5" ou "PS5").
     */
    public List<Usuario> findAllByProdutoInteresseContainingIgnoreCase(@Param("produto") String produtoInteresse);
}