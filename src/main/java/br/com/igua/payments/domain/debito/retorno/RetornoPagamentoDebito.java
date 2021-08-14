package br.com.igua.payments.domain.debito.retorno;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.igua.payments.domain.comum.Cartao;
import br.com.igua.payments.domain.comum.retorno.RetornoLinkCielo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class RetornoPagamentoDebito {

	@JsonProperty("ServiceTaxAmount") 
    public int serviceTaxAmount;
    @JsonProperty("Installments") 
    public int installments;
    @JsonProperty("Interest") 
    public int interest;
    @JsonProperty("Capture") 
    public boolean capture;
    @JsonProperty("Authenticate") 
    public boolean authenticate;
    @JsonProperty("Recurrent") 
    public boolean recurrent;
    @JsonProperty("DebitCard") 
    public Cartao debitCard;
    @JsonProperty("Tid") 
    public String tid;
    @JsonProperty("ProofOfSale") 
    public String proofOfSale;
    @JsonProperty("AuthorizationCode") 
    public String authorizationCode;
    @JsonProperty("SoftDescriptor") 
    public String softDescriptor;
    @JsonProperty("Provider") 
    public String provider;
    @JsonProperty("Eci") 
    public String eci;
    @JsonProperty("IsQrCode") 
    public boolean isQrCode;
    @JsonProperty("Amount") 
    public int amount;
    @JsonProperty("ReceivedDate") 
    public String receivedDate;
    @JsonProperty("Status") 
    public int status;
    @JsonProperty("IsSplitted") 
    public boolean isSplitted;
    @JsonProperty("ReturnMessage") 
    public String returnMessage;
    @JsonProperty("ReturnCode") 
    public String returnCode;
    @JsonProperty("PaymentId") 
    public String paymentId;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("Currency") 
    public String currency;
    @JsonProperty("Country") 
    public String country;
    @JsonProperty("Links") 
    public List<RetornoLinkCielo> links;
	
}
