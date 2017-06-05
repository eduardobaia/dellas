package com.dellas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.converter.UsuarioConverter;
import com.dellas.dto.UsuarioDTO;
import com.dellas.exception.MultipleUsuarioException;
import com.dellas.exception.UsuarioException;
import com.dellas.model.Usuario;
import com.dellas.repository.UsuarioRepository;
import com.dellas.service.UsuarioService;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;
	
	private static final String LOGIN__OBRIGATORIO = "O cmapo Login  é obrigatório.";
	private static final String SENHA_OBRIGATORIO = "O campo senha obrigatório.";

	
	@Transactional(readOnly = false)
	@Override
	public UsuarioDTO create(UsuarioDTO usuario) {
		checkException(validadePersistUsuario(usuario));
		return UsuarioConverter.toUsuarioDTO(repositorio.save(UsuarioConverter.toUsuario(usuario)));
	}

	@Override
	public UsuarioDTO get(long id) {
		// TODO Auto-generated method stub
		return UsuarioConverter.toUsuarioDTO(repositorio.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public UsuarioDTO update(UsuarioDTO usuario) {
		final Usuario usuarioModel= UsuarioConverter.toUsuario(usuario);
		checkException(validadeUpdateUsuario(usuario));
		return UsuarioConverter.toUsuarioDTO(repositorio.save(usuarioModel));
		}

	@Transactional(readOnly = false)
	@Override
	public void delete(Long id) {
		repositorio.delete(id);
	}

	@Override
	public List<UsuarioDTO> findAll() {
		return UsuarioConverter.toListUsuarioDTO((List<Usuario>) repositorio.findAll());
	}

	@Override
	public List<UsuarioDTO> findByFilter(UsuarioDTO usuario) {
		final UsuarioDTO entidade = new UsuarioDTO();
		final List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		lista.add(entidade);
		return lista;
	}
	
	
	//Validacoes
	private void validaLogin(final UsuarioDTO usuario, final ArrayList<UsuarioException> errors){
		if( StringUtils.isBlank(usuario.getLogin())){
			errors.add(new UsuarioException(LOGIN__OBRIGATORIO));
		}
	}
	
	private void validaSenha(final UsuarioDTO usuario, final ArrayList<UsuarioException> errors){
		if( StringUtils.isBlank(usuario.getLogin())){
			errors.add(new UsuarioException(SENHA_OBRIGATORIO));
		}
	}
	
	private void checkException(final ArrayList<UsuarioException> exceptions) {
		if (!exceptions.isEmpty()) {
			throw new MultipleUsuarioException(exceptions);
		}
	}
	
	private ArrayList<UsuarioException> validadePersistUsuario(final UsuarioDTO usuario) {
		final ArrayList<UsuarioException> errors = new ArrayList<UsuarioException>();
		validaLogin(usuario, errors);
		validaSenha(usuario, errors);
		return errors;
	}
	
	//faz validação para update
	private ArrayList<UsuarioException> validadeUpdateUsuario(final UsuarioDTO usuario) {
		final ArrayList<UsuarioException> errors = new ArrayList<UsuarioException>();
		validaLogin(usuario, errors);
		validaSenha(usuario, errors);
		return errors;
	}
	
	

}
