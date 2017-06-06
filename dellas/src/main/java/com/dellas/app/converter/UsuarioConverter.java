package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.List;

import com.dellas.app.dto.UsuarioDTO;
import com.dellas.app.model.Usuario;

public class UsuarioConverter {

	public static Usuario toUsuario (final UsuarioDTO dto) {
		final Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setLogin(dto.getLogin());
		usuario.setPassword(dto.getPassword());
		usuario.setTelefone(dto.getTelefone());

		return usuario;
	}


	public static UsuarioDTO toUsuarioDTO(final Usuario usuario ){
		final UsuarioDTO model = new UsuarioDTO();
		model.setId(usuario.getId());
		model.setLogin(usuario.getLogin());
		model.setNome(usuario.getNome());
		model.setPassword(usuario.getPassword());
		model.setTelefone(usuario.getTelefone());

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
