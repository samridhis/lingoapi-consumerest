package com.javainuse.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Component
public class PassThroughRouter extends RouteBuilder {
	//restConfiguration().component("servlet").bindingMode(RestConfiguration.RestBindingMode.auto);
	//restCofiguration().
	private final String endPoint = "http://jsonplaceholder.typicode.com/todos/1";

	@Override
	public void configure() throws Exception {
		from("direct:myService")
						.streamCaching() //
						.toF(endPoint + "?bridgeEndpoint=true")
						.log("Response  ${body}").convertBodyTo(String.class)
						.end();

		rest().get("/api")
						.route()
						.to("direct:myService")
						.end()
						.marshal()
						.json(JsonLibrary.Jackson)
						.convertBodyTo(String.class)
						.endRest();
	}


}
