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

import com.dellas.app.dto.PedidoDTO;
import com.dellas.app.exception.Error;
import com.dellas.app.exception.PedidoExceptionHandler;
import com.dellas.app.service.PedidoService;

@RequestMapping("/pedido")
@CrossOrigin
@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAll(){
		try {
			return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<Error>(new Error(1, PedidoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@PathVariable final Long id){
		try {
			final PedidoDTO model = pedidoService.get(id);
			return new ResponseEntity<PedidoDTO>(model, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<Error>(new Error(1, PedidoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody final PedidoDTO model){
		try {
			final PedidoDTO dto= pedidoService.create(model);
			return new ResponseEntity<PedidoDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, PedidoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody final PedidoDTO model){
		try {
			final PedidoDTO dto= pedidoService.update(model);
			return new ResponseEntity<PedidoDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, PedidoExceptionHandler.getExceptionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE , produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable final Long id){
		pedidoService.delete(id);
	}
}
