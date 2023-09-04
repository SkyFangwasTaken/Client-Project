package com.actimizewebservice.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.actimizewebservice.soap.api.actimize.RealTimeWSProviderRequest;
import com.actimizewebservice.soap.api.actimize.RealTimeWSProviderResponse;
import com.actimizewebservice.soap.api.client.SoapClient;

@SpringBootApplication
@RestController
public class ActimizeWebServiceClientApplication {

	@Autowired
	private SoapClient client;
	
	@PostMapping("/checkHitOutput")
	public RealTimeWSProviderResponse invokeSoapClient(@RequestBody RealTimeWSProviderRequest request) {
		return client.checkHitOutput(request);
	}
	public static void main(String[] args) {
		SpringApplication.run(ActimizeWebServiceClientApplication.class, args);
	}

}
