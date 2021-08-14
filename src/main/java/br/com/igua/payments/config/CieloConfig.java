package br.com.igua.payments.config;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CieloConfig {

	@Value("${cielo.merchantkey.af}")
	private String MerchantKeyAltaFloresta;
	
	@Value("${cielo.merchantid.af}")
	private String MerchantIdAltaFloresta;
	
	@Value("${cielo.merchantkey.ca}")
	private String MerchantKeyCanarana;
	
	@Value("${cielo.merchantid.ca}")
	private String MerchantIdCanarana;
	
	@Value("${cielo.merchantkey.cs}")
	private String MerchantKeyCastilho;
	
	@Value("${cielo.merchantid.cs}")
	private String MerchantIdCastilho;
	
	@Value("${cielo.merchantkey.co}")
	private String MerchantKeyComodoro;
	
	@Value("${cielo.merchantid.co}")
	private String MerchantIdComodoro;
	
	@Value("${cielo.merchantkey.cb}")
	private String MerchantKeyCuiaba;
	
	@Value("${cielo.merchantid.cb}")
	private String MerchantIdCuiaba;
	
	@Value("${cielo.merchantkey.pl}")
	private String MerchantKeyPalestina;
	
	@Value("${cielo.merchantid.pl}")
	private String MerchantIdPalestina;
	
	@Value("${cielo.merchantkey.it}")
	private String MerchantKeyItapoa;
	
	@Value("${cielo.merchantid.it}")
	private String MerchantIdItapoa;
	
	@Value("${cielo.merchantkey.pr}")
	private String MerchantKeyParanagua;
	
	@Value("${cielo.merchantid.pr}")
	private String MerchantIdParanagua;	
	
	@Value("${cielo.merchantkey.pq}")
	private String MerchantKeyPiquete;
	
	@Value("${cielo.merchantid.pq}")
	private String MerchantIdPiquete;
	
	@Value("${cielo.merchantkey.ap}")
	private String MerchantKeyAguasPontes;
	
	@Value("${cielo.merchantid.ap}")
	private String MerchantIdAguasPontes;
	
	@Value("${cielo.merchantkey.mi}")
	private String MerchantKeyMirassol;
	
	@Value("${cielo.merchantid.mi}")
	private String MerchantIdMirassol;
	
	@Value("${cielo.merchantkey.an}")
	private String MerchantKeyAndradina;
	
	@Value("${cielo.merchantid.an}")
	private String MerchantIdAndradina;
	
	@Value("${cielo.merchantorderid}")
	private String DefaultMerchantOrderId;
	
	@Value("${cielo.installments}")
	private int Installments;
	
	
}
