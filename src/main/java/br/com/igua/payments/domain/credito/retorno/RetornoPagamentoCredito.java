package br.com.igua.payments.domain.credito.retorno;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Cartao;
import br.com.igua.payments.domain.comum.retorno.RetornoLinkCielo;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class RetornoPagamentoCredito {

	@JsonProperty("ServiceTaxAmount") 
    private int serviceTaxAmount;
    @JsonProperty("Installments") 
    private int installments;
    @JsonProperty("Interest") 
    private int interest;
    @JsonProperty("Capture") 
    private boolean capture;
    @JsonProperty("Authenticate") 
    private boolean authenticate;
    @JsonProperty("Recurrent") 
    private boolean recurrent;
    @JsonProperty("CreditCard") 
    private Cartao creditCard;
    @JsonProperty("Tid") 
    private String tid;
    @JsonProperty("ProofOfSale") 
    private String proofOfSale;
    @JsonProperty("AuthorizationCode") 
    private String authorizationCode;
    @JsonProperty("SoftDescriptor") 
    private String softDescriptor;
    @JsonProperty("Provider") 
    private String provider;
    @JsonProperty("Eci") 
    private String eci;
    @JsonProperty("IsQrCode") 
    private boolean isQrCode;
    @JsonProperty("Amount") 
    private int amount;
    @JsonProperty("ReceivedDate") 
    private String receivedDate;
    @JsonProperty("Status") 
    private int status;
    @JsonProperty("IsSplitted") 
    private boolean isSplitted;
    @JsonProperty("ReturnMessage") 
    private String returnMessage;
    @JsonProperty("ReturnCode") 
    private String returnCode;
    @JsonProperty("PaymentId") 
    private String paymentId;
    @JsonProperty("Type") 
    private String type;
    @JsonProperty("Currency") 
    private String currency;
    @JsonProperty("Country") 
    private String country;
    @JsonProperty("Links") 
    private List<RetornoLinkCielo> links;
	
}
