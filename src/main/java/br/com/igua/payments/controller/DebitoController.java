package br.com.igua.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igua.payments.domain.debito.CompraDebito;
import br.com.igua.payments.domain.debito.retorno.RetornoCompraDebito;
import br.com.igua.payments.exception.CieloPaymentException;
import br.com.igua.payments.service.DebitoService;

@CrossOrigin(origins = "https://staging-igua.opah.com.br/", maxAge = 3600)
@RestController
@RequestMapping("v1/compra/debito")
public class DebitoController {

	@Autowired
	DebitoService debitoService;

	@PostMapping
	public ResponseEntity<RetornoCompraDebito>  pagar(@RequestHeader(required = true)  String token,@RequestBody(required = true) CompraDebito compraDebito) throws CieloPaymentException {
		RetornoCompraDebito body =debitoService.pagarNoDebito(token,compraDebito);
		if(body.getPayment().getStatus()==3) {
			return ResponseEntity.status(401).body(body);
		}
			return ResponseEntity.status(200).body(body);		
	}
	
}
