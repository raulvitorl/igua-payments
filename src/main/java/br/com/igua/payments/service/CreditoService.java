package br.com.igua.payments.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igua.payments.config.CieloConfig;
import br.com.igua.payments.domain.credito.CompraCredito;
import br.com.igua.payments.domain.credito.retorno.RetornoCompraCredito;
import br.com.igua.payments.exception.CieloPaymentException;
import br.com.igua.payments.integration.CieloIntegration;
import br.com.igua.payments.security.config.SecurityHelper;
import br.com.igua.payments.security.config.TokenRequest;

@Service
public class CreditoService extends CieloConfig{


	private static final String CREDIT_CARD = "CreditCard";
	@Autowired
	private CieloIntegration cieloCredito;
	@Autowired
	private SecurityHelper securityHelper;	

	
	public RetornoCompraCredito pagarNoCredito(String token,CompraCredito compraCredito) throws CieloPaymentException, IOException {

		compraCredito.setMerchantOrderId(getDefaultMerchantOrderId());

		compraCredito.getPayment().setInstallments(getInstallments());

		compraCredito.getPayment().setType(CREDIT_CARD);
		
		String merchantId=  getCredentials(securityHelper.extractTokenBody(token)).get("merchantId");
		String merchantKey=getCredentials(securityHelper.extractTokenBody(token)).get("merchantKey");
		
		RetornoCompraCredito cieloRetorno = cieloCredito.pagarNoCredito(compraCredito,merchantId,merchantKey);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpPut httpPut = new HttpPut("https://api.cieloecommerce.cielo.com.br/1/sales/"+cieloRetorno.getPayment().getPaymentId()+"/capture");
		
		httpPut.addHeader("Accept", "*/*");
		
		httpPut.addHeader("MerchantKey","OdvimSzpJj8RCSnQPzZFxSqsYqClD6vgBfTLL872");
		
		httpPut.addHeader("MerchantId","7784c326-6fec-4f0f-8f78-1e2024f04182");
		
		httpPut.addHeader("Content-Type","text/json");
		
		ResponseHandler <String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } 
		       return ("Unexpected response status: " + status);
		    
		};
		
		httpclient.execute(httpPut, responseHandler);
		return cieloRetorno;
	}	
	
	
	private HashMap<String, String> getCredentials(TokenRequest decodedToken){
		String merchantId="";
		String merchantKey="";
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("alta floresta")){merchantId=getMerchantIdAltaFloresta();merchantKey=getMerchantKeyAltaFloresta();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("canarana")){merchantId=getMerchantIdCanarana();merchantKey=getMerchantKeyCanarana();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("castilho")){merchantId=getMerchantIdCastilho();merchantKey=getMerchantKeyCastilho();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("comodoro")){merchantId=getMerchantIdComodoro();merchantKey=getMerchantKeyComodoro();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("cuiaba")){merchantId=getMerchantIdCuiaba();merchantKey=getMerchantKeyCuiaba();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("palestina")){merchantId=getMerchantIdPalestina();merchantKey=getMerchantKeyPalestina();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("itapoa")){merchantId=getMerchantIdItapoa();merchantKey=getMerchantKeyItapoa();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("paranagua")){merchantId=getMerchantIdParanagua();merchantKey=getMerchantKeyParanagua();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("piquete")){merchantId=getMerchantIdPiquete();merchantKey=getMerchantKeyPiquete();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("aguas pontes")){merchantId=getMerchantIdAguasPontes();merchantKey=getMerchantKeyAguasPontes();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("mirassol")){merchantId=getMerchantIdMirassol();merchantKey=getMerchantKeyMirassol();}
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("andradina")){merchantId=getMerchantIdAndradina();merchantKey=getMerchantKeyAndradina();}
		
		HashMap<String, String> response = new LinkedHashMap<String, String>();
		response.put("merchantId", merchantId);
		response.put("merchantKey", merchantKey);
		
		return response;
	}

}
