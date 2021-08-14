package br.com.igua.payments.domain.debito;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PagamentoDebito {
	
	@JsonProperty("Type") 
    private String type;
    @JsonProperty("Amount") 
    private int amount;
    @JsonProperty("ReturnUrl") 
    private String returnUrl;
    @JsonProperty("Authenticate") 
    private boolean authenticate;
    @JsonProperty("DebitCard") 
    private Cartao debitCard;

}
