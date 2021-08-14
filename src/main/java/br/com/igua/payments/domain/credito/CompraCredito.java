package br.com.igua.payments.domain.credito;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompraCredito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("MerchantOrderId") 
    public String merchantOrderId;
	
    @JsonProperty("Payment") 
    public PagamentoCredito payment;
      
    
}
