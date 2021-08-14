package br.com.igua.payments.domain.comum.retorno;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetornoPadraoEfetivacao {
	
	 @JsonProperty("Status") 
	    public int status;
	    @JsonProperty("ReasonCode") 
	    public int reasonCode;
	    @JsonProperty("ReasonMessage") 
	    public String reasonMessage;
	    @JsonProperty("ProviderReturnCode") 
	    public String providerReturnCode;
	    @JsonProperty("ProviderReturnMessage") 
	    public String providerReturnMessage;
	    @JsonProperty("ReturnCode") 
	    public String returnCode;
	    @JsonProperty("ReturnMessage") 
	    public String returnMessage;
	    @JsonProperty("Tid") 
	    public String tid;
	    @JsonProperty("ProofOfSale") 
	    public String proofOfSale;
	    @JsonProperty("AuthorizationCode") 
	    public String authorizationCode;
	    @JsonProperty("Links") 
	    public List<RetornoLinkCielo> links;

}
