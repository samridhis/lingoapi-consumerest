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

		exchange.getIn().setBody("Changed Body");
	}
}
