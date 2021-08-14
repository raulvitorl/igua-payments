package br.com.igua.payments.security.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {

	private String dataLogin;
	private String dataExpired;
	private String cnpj;
	private City city;

}
