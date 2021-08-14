package br.com.igua.payments.domain.credito.retorno;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Comprador;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RetornoCompraCredito {

	@JsonProperty("MerchantOrderId") 
	public String merchantOrderId;
	@JsonProperty("Customer") 
	public Comprador customer;
	@JsonProperty("Payment") 
	public RetornoPagamentoCredito payment;


}
