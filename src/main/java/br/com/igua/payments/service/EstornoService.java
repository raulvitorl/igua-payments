package br.com.igua.payments.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igua.payments.config.CieloConfig;
import br.com.igua.payments.exception.CieloPaymentException;
import br.com.igua.payments.security.config.SecurityHelper;
import br.com.igua.payments.security.config.TokenRequest;

@Service
public class EstornoService extends CieloConfig{	
	
	@Autowired
	private SecurityHelper securityHelper;	
	

	public String estornarValor(String token,String paymentId) throws CieloPaymentException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		String merchantId="";
		String merchantKey="";
		
		TokenRequest decodedToken =  securityHelper.extractTokenBody(token);
		
		if(decodedToken.getCity().getLabel().equalsIgnoreCase("cuiaba")){merchantId=getMerchantIdCuiaba();merchantKey=getMerchantKeyCuiaba();}
		
		HttpPut httpPut = new HttpPut("https://api.cieloecommerce.cielo.com.br/1/sales/"+paymentId+"/void");

		httpPut.addHeader("Accept", "*/*");

		httpPut.addHeader("MerchantKey",merchantKey);

		httpPut.addHeader("MerchantId",merchantId);

		httpPut.addHeader("Content-Type","text/json");

		ResponseHandler <String> responseHandler = response -> {
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				HttpEntity entity = response.getEntity();
				return entity != null ? EntityUtils.toString(entity) : null;
			} 
			return ("Unexpected response status: " + status);

		};
		var responseBody = (String)httpclient.execute(httpPut, responseHandler);
		System.out.println(responseBody);
		if(responseBody.contains("Successful"))
			return "Estorno efetuado.";
		return "Falha ao efetuar estorno";
		
	}


}
