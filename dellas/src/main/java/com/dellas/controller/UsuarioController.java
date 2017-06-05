package com.dellas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dellas.dto.UsuarioDTO;
import com.dellas.exception.Error;
import com.dellas.exception.UsuarioExceptionHandler;
import com.dellas.service.UsuarioService;

@RequestMapping("/usuario")
@CrossOrigin
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAll(@RequestParam final Map<String, String> params){
		try {
			return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Error>(new Error(1, UsuarioExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
			
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@PathVariable final Long id){
		try {
			final UsuarioDTO model = usuarioService.get(id);
			return new ResponseEntity<UsuarioDTO>(model, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Error>(new Error(1, UsuarioExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}	
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody final UsuarioDTO model){
		try {
			final UsuarioDTO dto= usuarioService.create(model);
			return new ResponseEntity<UsuarioDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, UsuarioExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody final UsuarioDTO model){
		try {
			final UsuarioDTO dto= usuarioService.update(model);
			return new ResponseEntity<UsuarioDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, UsuarioExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE , produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable final Long id){
		usuarioService.delete(id);
	}
	
	
}
