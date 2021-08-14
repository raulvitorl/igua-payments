package br.com.igua.payments.domain.comum.retorno;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RetornoLinkCielo {

    @JsonProperty("Method") 
    private String method;
    @JsonProperty("Rel") 
    private String rel;
    @JsonProperty("Href") 
    private String href;
	
}
