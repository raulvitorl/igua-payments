package br.com.igua.payments.domain.comum;

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
public class Cartao implements Serializable{
private static final long serialVersionUID = 1L;

    @JsonProperty("CardNumber") 
    private String cardNumber;
    @JsonProperty("Holder") 
    private String holder;
    @JsonProperty("ExpirationDate") 
    private String expirationDate;
    @JsonProperty("SecurityCode") 
    private String securityCode;
    @JsonProperty("Brand") 
    private String brand;

}
