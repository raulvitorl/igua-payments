package br.com.igua.payments.service;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igua.payments.config.CieloConfig;
import br.com.igua.payments.domain.debito.CompraDebito;
import br.com.igua.payments.domain.debito.retorno.RetornoCompraDebito;
import br.com.igua.payments.entity.PaymentEntity;
import br.com.igua.payments.entity.repositorie.PaymentRepository;
import br.com.igua.payments.exception.CieloPaymentException;
import br.com.igua.payments.integration.CieloIntegration;
import br.com.igua.payments.security.config.SecurityHelper;
import br.com.igua.payments.security.config.TokenRequest;

@Service
public class DebitoService extends CieloConfig{


	private static final String DEBIT_CARD = "DebitCard";

	@Autowired
	private CieloIntegration cieloDebito;	
	
	@Autowired
	private SecurityHelper securityHelper;	

	@Autowired
	private PaymentRepository PaymentRepository;
	
	public RetornoCompraDebito pagarNoDebito(String token, CompraDebito compraDebito) throws CieloPaymentException {
	
		
		String merchantId=  getCredentials(securityHelper.extractTokenBody(token)).get("merchantId");
		String merchantKey=getCredentials(securityHelper.extractTokenBody(token)).get("merchantKey");
		
		compraDebito.setMerchantOrderId(getDefaultMerchantOrderId());
		
		compraDebito.getPayment().setType(DEBIT_CARD);

		RetornoCompraDebito cieloRetorno = cieloDebito.pagarNoDebito(compraDebito,merchantId,merchantKey);

		PaymentEntity pagamento = PaymentEntity.fromDebit(cieloRetorno.getPayment(), compraDebito.getInvoiceStructure());
		
		
		PaymentRepository.save(pagamento);
		
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
