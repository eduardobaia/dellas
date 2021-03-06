package com.dellas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dellas.app.dto.ProdutoDTO;
import com.dellas.app.exception.Error;
import com.dellas.app.exception.ProdutoExceptionHandler;
import com.dellas.app.service.ProdutoService;

@RequestMapping("/produto")
@CrossOrigin
@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAll(){
		try {
			return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<Error>(new com.dellas.app.exception.Error(1, ProdutoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@PathVariable final Long id){
		try {
			final ProdutoDTO model = produtoService.get(id);
			return new ResponseEntity<ProdutoDTO>(model, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<Error>(new Error(1, ProdutoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody final ProdutoDTO model){
		try {
			final ProdutoDTO dto= produtoService.create(model);
			return new ResponseEntity<ProdutoDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, ProdutoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody final ProdutoDTO model){
		try {
			final ProdutoDTO dto= produtoService.update(model);
			return new ResponseEntity<ProdutoDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, ProdutoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE , produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable final Long id){
		produtoService.delete(id);
	}
}
