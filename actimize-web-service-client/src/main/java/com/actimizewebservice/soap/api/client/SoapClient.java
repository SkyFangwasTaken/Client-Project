package com.actimizewebservice.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.actimizewebservice.soap.api.actimize.RealTimeWSProviderRequest;
import com.actimizewebservice.soap.api.actimize.RealTimeWSProviderResponse;

@Service
public class SoapClient{

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;
	
	public RealTimeWSProviderResponse checkHitOutput (RealTimeWSProviderRequest request) {
		template = new WebServiceTemplate(marshaller);
		RealTimeWSProviderResponse rtwspResponse = (RealTimeWSProviderResponse) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return rtwspResponse;
	}
	
}
