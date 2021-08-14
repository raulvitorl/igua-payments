package br.com.igua.payments.security.config;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class SecurityHelper {
	
	public TokenRequest extractTokenBody(String jwtToken) {
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(base64EncodedBody));
        return new Gson().fromJson(body, TokenRequest.class);
	}
	

}
