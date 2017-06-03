package com.dellas.converter;

import java.util.ArrayList;
import java.util.List;

import com.dellas.dto.UsuarioDTO;
import com.dellas.model.Usuario;

public class UsuarioConverter {

	public static Usuario toUsuario (final UsuarioDTO dto) {
		final Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setLogin(dto.getLogin());
		usuario.setPassword(dto.getPassword());
		usuario.setTelefone(dto.getTelefone());
		usuario.setPedidos(dto.getPedidos());
		
		return usuario;
	}
	
	
	public static UsuarioDTO toUsuarioDTO(final Usuario usuario ){
		final UsuarioDTO model = new UsuarioDTO();
		model.setId(usuario.getId());
		model.setLogin(usuario.getLogin());
		model.setNome(usuario.getNome());
		model.setPassword(usuario.getPassword());
		model.setTelefone(usuario.getTelefone());
		model.setPedidos(usuario.getPedidos());
		
		return model;
	}
	
	public static List<UsuarioDTO> toListUsuarioDTO(final List<Usuario> lista){
		final List<UsuarioDTO> listUsuarioDTO= new ArrayList<>();
		if(lista != null){
			for(final Usuario usuario: lista){
				listUsuarioDTO.add(toUsuarioDTO(usuario));
			}
		}
		return listUsuarioDTO;
	}
	
}
