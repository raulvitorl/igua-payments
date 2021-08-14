package br.com.igua.payments.domain.credito;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Cartao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoCredito {
	
    @JsonProperty("Type") 
    private String type;
    @JsonProperty("Amount") 
    private int amount;
    @JsonProperty("Installments") 
    private int installments;
    @JsonProperty("SoftDescriptor") 
    private String softDescriptor;
    @JsonProperty("CreditCard") 
    private Cartao creditCard;

}
