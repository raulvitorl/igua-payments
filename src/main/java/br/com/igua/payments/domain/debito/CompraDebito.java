package br.com.igua.payments.domain.debito;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Comprador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class CompraDebito {	

	@JsonProperty("Customer") 
    public Comprador customer;
	
	@JsonProperty("MerchantOrderId") 
    public String merchantOrderId;
	
    @JsonProperty("Payment") 
    public PagamentoDebito payment;
    
    public String invoiceStructure;
      
    
}
