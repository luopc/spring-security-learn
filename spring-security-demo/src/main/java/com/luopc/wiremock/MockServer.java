package com.luopc.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MockServer {

	public static void main(String[] args) {
		WireMock.configureFor("192.168.137.120", 80);
		WireMock.removeAllMappings();
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/order/1")).willReturn(WireMock.aResponse().withBody("{id:1}").withStatus(200)));
	}

}
