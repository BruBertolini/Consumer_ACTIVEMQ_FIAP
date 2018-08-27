package br.com.fiap.avaliacao;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{
	
	@Override
	public void configure() throws Exception{
		from("file:/caminho").split().tokenize("\n").to("jms:queue:nomefila");
	}

}