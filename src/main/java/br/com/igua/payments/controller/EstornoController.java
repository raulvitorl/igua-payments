package br.com.igua.payments.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.igua.payments.exception.CieloPaymentException;
import br.com.igua.payments.service.EstornoService;

@CrossOrigin(origins = "https://staging-igua.opah.com.br/", maxAge = 3600)
@RestController
@RequestMapping("/compra/estorno")
public class EstornoController {

	@Autowired
	EstornoService estornoService;

	@PutMapping
	public ResponseEntity<String>estornar(@RequestHeader String token,@RequestParam(required = true) String paymentId) throws CieloPaymentException, IOException {
		return ResponseEntity.ok().body(estornoService.estornarValor(token,paymentId));
	}
	
}
