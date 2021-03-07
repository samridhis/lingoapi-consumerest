package com.javainuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		var body = exchange.getIn().getBody(String.class);
		LOGGER.info("my body: {}", body);
		System.out.println("Ahaan is printing in this method");
		exchange.getIn().setBody("Changed Body");
	}
}

/*
[10:08 pm, 07/03/2021] Ani1: import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
[10:10 pm, 07/03/2021] Ani1: .to("https://samfhirsdf.azurehealthcareapis.com/Practitioner").process(new MyProcessor());
				.to("https://samfhirsdf.azurehealthcareapis.com/Practitioner").process(new MyProcessor());

* */