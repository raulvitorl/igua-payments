package br.com.igua.payments.domain.debito.retorno;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Comprador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class RetornoCompraDebito {
	
	
	@JsonProperty("MerchantOrderId") 
    public String merchantOrderId;
	
	@JsonProperty("Customer") 
    public Comprador customer;
	
    @JsonProperty("Payment") 
    public RetornoPagamentoDebito payment;

}
