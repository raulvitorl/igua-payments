package br.com.igua.payments.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igua.payments.domain.credito.CompraCredito;
import br.com.igua.payments.domain.credito.retorno.RetornoCompraCredito;
import br.com.igua.payments.exception.CieloPaymentException;
import br.com.igua.payments.service.CreditoService;

@CrossOrigin(origins = "https://staging-igua.opah.com.br/", maxAge = 3600)
@RestController
@RequestMapping("v1/compra/credito")
public class CreditoController {

	@Autowired
	CreditoService creditoService;
	
	@PostMapping
	public ResponseEntity<RetornoCompraCredito> pagar(@RequestHeader(required = true) String token, @RequestBody(required = true) CompraCredito compraCredito) throws CieloPaymentException, IOException {
		RetornoCompraCredito body = creditoService.pagarNoCredito(token,compraCredito);
		if(body.getPayment().getStatus()==3) {
			return ResponseEntity.status(401).body(body);
		}
			return ResponseEntity.status(200).body(body);	
	}

	
}
