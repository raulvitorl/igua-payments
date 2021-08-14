package br.com.igua.payments.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.igua.payments.domain.credito.retorno.RetornoPagamentoCredito;
import br.com.igua.payments.domain.debito.retorno.RetornoPagamentoDebito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PaymentEntity {


	@Id
	private String paymentId;
	private int serviceTaxAmount; 
	private int installments;
	private int interest;
	private boolean capture;
	private boolean authenticate;
	private boolean recurrent; 
	private String tid;
	private String proofOfSale;
	private String authorizationCode;
	private String softDescriptor;
	private String provider;
	private String eci;
	private boolean isQrCode;
	private int amount;
	private String receivedDate;		 
	private int status;		
	private boolean isSplitted;		
	private String returnMessage;
	private String returnCode;
	private String type;
	private String currency;
	private String country;
	private String link;
	private String invoiceStructure;


	public static PaymentEntity fromCredit(RetornoPagamentoCredito obj,String invoiceStructure) {
		PaymentEntity newObj = new PaymentEntity();		
		newObj.setPaymentId(obj.getPaymentId());
		newObj.setServiceTaxAmount(obj.getServiceTaxAmount());
		newObj.setInstallments(obj.getInstallments());
		newObj.setInterest(obj.getInterest());
		newObj.setCapture(obj.isCapture());
		newObj.setAuthenticate(obj.isAuthenticate());
		newObj.setRecurrent(obj.isRecurrent());
		newObj.setTid(obj.getTid());
		newObj.setProofOfSale(obj.getProofOfSale());
		newObj.setAuthorizationCode(obj.getAuthorizationCode());
		newObj.setSoftDescriptor(obj.getSoftDescriptor());
		newObj.setProvider(obj.getProvider());
		newObj.setEci(obj.getEci());
		newObj.setQrCode(obj.isQrCode());
		newObj.setAmount(obj.getAmount());
		newObj.setReceivedDate(obj.getReceivedDate());
		newObj.setStatus(obj.getStatus());
		newObj.setSplitted(obj.isSplitted());
		newObj.setReturnMessage(obj.getReturnMessage());
		newObj.setType(obj.getType());
		newObj.setCurrency(obj.getCurrency());
		newObj.setCountry(obj.getCountry());
		newObj.setLink(obj.getLinks().get(0).getHref());
		newObj.setInvoiceStructure(invoiceStructure);
		return newObj;
	}
	
	public static PaymentEntity fromDebit(RetornoPagamentoDebito obj,String invoiceStructure) {
		PaymentEntity newObj = new PaymentEntity();		
		newObj.setPaymentId(obj.getPaymentId());
		newObj.setServiceTaxAmount(obj.getServiceTaxAmount());
		newObj.setInstallments(obj.getInstallments());
		newObj.setInterest(obj.getInterest());
		newObj.setCapture(obj.isCapture());
		newObj.setAuthenticate(obj.isAuthenticate());
		newObj.setRecurrent(obj.isRecurrent());
		newObj.setTid(obj.getTid());
		newObj.setProofOfSale(obj.getProofOfSale());
		newObj.setAuthorizationCode(obj.getAuthorizationCode());
		newObj.setSoftDescriptor(obj.getSoftDescriptor());
		newObj.setProvider(obj.getProvider());
		newObj.setEci(obj.getEci());
		newObj.setQrCode(obj.isQrCode());
		newObj.setAmount(obj.getAmount());
		newObj.setReceivedDate(obj.getReceivedDate());
		newObj.setStatus(obj.getStatus());
		newObj.setSplitted(obj.isSplitted());
		newObj.setReturnMessage(obj.getReturnMessage());
		newObj.setType(obj.getType());
		newObj.setCurrency(obj.getCurrency());
		newObj.setCountry(obj.getCountry());
		newObj.setLink(obj.getLinks().get(0).getHref());
		newObj.setInvoiceStructure(invoiceStructure);
		return newObj;
	}

}
