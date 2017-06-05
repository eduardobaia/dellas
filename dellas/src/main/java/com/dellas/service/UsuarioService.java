package com.dellas.service;

import java.util.List;

import com.dellas.dto.UsuarioDTO;

public interface UsuarioService {

	
	/**
	 * Persiste uma instancia da entidade Usuario.
	 *
	 * @param usuario
	 *        Instancia de Acao a ser persistida
	 * @return entidade persistida
	 */
	UsuarioDTO create(UsuarioDTO usuario);
	
	UsuarioDTO get(long id);
	
	UsuarioDTO update(UsuarioDTO usuario);
	
	List<UsuarioDTO> findAll();
	
	List<UsuarioDTO> findByFilter(UsuarioDTO usuario);
	
}
