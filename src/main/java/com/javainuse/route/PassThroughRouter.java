package com.javainuse.route;

import com.javainuse.processor.MyProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Component
public class PassThroughRouter extends RouteBuilder {

	private final String endPoint = "http://jsonplaceholder.typicode.com/todos/1";

	private final MyProcessor processor;

	public PassThroughRouter(MyProcessor processor) {
		this.processor = processor;
	}

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
