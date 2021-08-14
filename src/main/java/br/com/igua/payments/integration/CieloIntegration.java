package br.com.igua.payments.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.igua.payments.domain.comum.retorno.RetornoPadraoEfetivacao;
import br.com.igua.payments.domain.credito.CompraCredito;
import br.com.igua.payments.domain.credito.retorno.RetornoCompraCredito;
import br.com.igua.payments.domain.debito.CompraDebito;
import br.com.igua.payments.domain.debito.retorno.RetornoCompraDebito;
import feign.Headers;

@FeignClient(name = "cielo", url = "${webclient.api.cielo}")
public interface CieloIntegration {

	@PostMapping("/1/sales")
	RetornoCompraDebito pagarNoDebito(@RequestBody CompraDebito input,@RequestHeader String MerchantId, @RequestHeader String MerchantKey);
	
	@PostMapping("/1/sales")
	RetornoCompraCredito pagarNoCredito(@RequestBody CompraCredito input,@RequestHeader String MerchantId, @RequestHeader String MerchantKey);
	
	@PutMapping("/1/sales/{paymentId}/capture")
	@Headers("Content-Length: 0")
	RetornoPadraoEfetivacao capturarNoCredito(@PathVariable String paymentId,@RequestHeader String MerchantId, @RequestHeader String MerchantKey);
	
	@PutMapping(value="/1/sales/{PaymentId}/void")
	RetornoPadraoEfetivacao estornarTransacao(
	@PathVariable String PaymentId,
	@RequestHeader String MerchantId,
	@RequestHeader String MerchantKey,
	@RequestHeader(name = "Content-Type",defaultValue = "text/json") String ContentType);
	

}
