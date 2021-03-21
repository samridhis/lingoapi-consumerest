package com.javainuse.route;

import com.javainuse.model.Root;
import com.javainuse.processor.MyProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class PassThroughRouter extends RouteBuilder {
	//restConfiguration().component("servlet").bindingMode(RestConfiguration.RestBindingMode.auto);
	//restCofiguration().
	private final String endPoint = "https://pegacorn-hestia-gateway.site-a:30302/pegacorn/internal/fhir/r4/Practitioner?_pretty=true";

	JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(Root.class);

	@Override
	public void configure() throws Exception {
				from("direct:myService")
								.streamCaching() //
								.setHeader(Exchange.HTTP_METHOD, simple("GET"))
								.setHeader("authority", simple("https://pegacorn-fhirplace-gateway.site-a:30502/pegacorn/internal/fhir/r4"))
								.setHeader("accept", simple("/"))
								//.setHeader("authorization", simple("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyIsImtpZCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyJ9.eyJhdWQiOiJodHRwczovL3NhbWZoaXI4c2RmLmF6dXJlaGVhbHRoY2FyZWFwaXMuY29tIiwiaXNzIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvNGNhNTIyOTMtNjY5Zi00ZmE4LTgwNzgtZjhlYjhiODFhNDhkLyIsImlhdCI6MTYxNTI1Nzk3MywibmJmIjoxNjE1MjU3OTczLCJleHAiOjE2MTUyNjE4NzMsImFjciI6IjEiLCJhaW8iOiJBVlFBcS84VEFBQUFOcDBQS1kvc3dhaFhFTUNielI1M0cxa3dUcG9PajYvekx3QzZQZys5aThYS09rVXJEdTZLNmo3NWd4VUZxdnF5YzU0VWk3MDV4TTlrTzlxMy9zTTAxcUhyOS8wK3hJU2lCbEJoV25WZUFPbz0iLCJhbXIiOlsicHdkIl0sImFwcGlkIjoiOGY0YmJiMjQtYWU4MC00MDI2LWJhNzEtYmJlMzIzMDllN2JkIiwiYXBwaWRhY3IiOiIxIiwiZW1haWwiOiJzYW1yaWRoaXMxOTgwQGhvdG1haWwuY29tIiwiZmFtaWx5X25hbWUiOiJTaHUiLCJnaXZlbl9uYW1lIjoiU2FtIiwiaWRwIjoibGl2ZS5jb20iLCJpcGFkZHIiOiIxMzYuMTUzLjE0LjEwMiIsIm5hbWUiOiJTYW0gU2h1Iiwib2lkIjoiYjBmZGZmOTctMmZiNy00ZDM1LWJiOGMtMTYxOWM0MjM4MTEzIiwicmgiOiIwLkFXWUFreUtsVEo5bXFFLUFlUGpyaTRHa2pTUzdTNC1BcmlaQXVuRzc0eU1KNTcxbUFQZy4iLCJzY3AiOiJ1c2VyX2ltcGVyc29uYXRpb24iLCJzdWIiOiJoTFZtUE5IcldReFRkM0lEM2pSX3V0eVU3c1dZRDNqSjlaelp5d3M3QUFrIiwidGlkIjoiNGNhNTIyOTMtNjY5Zi00ZmE4LTgwNzgtZjhlYjhiODFhNDhkIiwidW5pcXVlX25hbWUiOiJsaXZlLmNvbSNzYW1yaWRoaXMxOTgwQGhvdG1haWwuY29tIiwidXRpIjoiVkhVVmdRMzdZa0MtMWtJdm5MRVlBQSIsInZlciI6IjEuMCJ9.HgYCWRuTA5bPz8ggUFkmKB8tgYotmUbYk1gpuEHin5ywnX6EdIbQ20HavHlkJNNxgGiPwGNHOaUzOVmrGog001pgXYRHpLn9qoYgZZtrDlV5dYRShNXENBL597WUMxs3jCv03CeD90eSFo2TPY99QQh0804utpxtHVOl5fI03LK-kTxob9bUC0YKxqJ4fi8_06LsRK7jets9uLFprrb3ITKmdFeOLEvfeuoHPtM73kjB94TmnRHnuW-A6N3fIjviR_bFdvtpzZm29VB-oxC8bHxlqRGycikI88pkQnhKv_y56Rj-qalPKDoi6OlHs98emlqOOpWJMNdcKmoFolpbtw"))
								//client.DefaultRequestHeaders.Add("Accept-Charset", "utf-8");
								//client.DefaultRequestHeaders.Add("Accept", "application/fhir+xml;q=1.0, application/fhir+json;q=1.0, application/xml+fhir;q=0.9, application/json+fhir;q=0.9");
								.setHeader("x-api-key",  simple("fmg2vPYxKYYjwcQq3fwP8zXlQKSehzgPyvR3u2Lde2eINx86QwV1ENH2wpD"))
								//client.DefaultRequestHeaders.Add("User-Agent", "HAPI-FHIR/5.1.0 (FHIR Client; FHIR 4.0.1/R4; apache)");
								//client.DefaultRequestHeaders.Add("Accept-Encoding", "gzip");						
								.setHeader("user-agent", simple("HAPI-FHIR/5.1.0 (FHIR Client; FHIR 4.0.1/R4; apache)"))
								.setHeader("origin", simple("https://samfhir8sdfdashdash.azurewebsites.net"))
								.setHeader("sec-fetch-site", simple("cross-site"))
								.setHeader("sec-fetch-mode", simple("cors"))
								.setHeader("sec-fetch-dest", simple("empty"))
								.setHeader("referer", simple("https://pegacorn-fhirplace-gateway.site-a:30502/pegacorn/internal/fhir/r4"))
								.setHeader("accept-language", simple("en-GB,en-US;q=0.9,en;q=0.8"))
								.toF("https://pegacorn-fhirplace-gateway.site-a:30502/pegacorn/internal/fhir/r4/Practitioner" + "?bridgeEndpoint=true")
								.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
								.setHeader(Exchange.HTTP_METHOD, simple("GET"))
								.unmarshal(jacksonDataFormat)
								.process(new MyProcessor())
								.log("Response  ${body}")
								.convertBodyTo(Root.class)

								//.to("https://samfhir8sdf.azurehealthcareapis.com/Practitioner").process(new MyProcessor());
								.end();

		rest().get("/api")
						.route()
						//.outType(Root.class)
						.to("direct:myService")
						.end()
						.marshal(jacksonDataFormat)
						.endRest();
	}

	//https://tomd.xyz/camel-rest/
}

/*
rest-service
Apache Camel

This is a demo of how to create a simple REST service in Apache Camel using the REST DSL, with Spring Boot.

This is a Spring Boot application. It uses Camel's servlet component to provide the REST service, which runs in the embedded web server, which is running on port 8080.

Good to know!
Here are some notable features about this demo, to help you understand how it works:

We add camel-servlet-starter as a dependency, which tells Camel to automatically configure a Servlet that will 'host' our RESTful API.

Since we're using Spring Boot 2.x, we go with the opinionated defaults - in this case, the default servlet container for Spring Boot is Tomcat. So we'll be deploying into an embedded Tomcat server.

The context path (the HTTP URL which will be mapped to the Servlet) can be changed by setting the property camel.component.servlet.mapping.context-path in application.properties. In this example, we're mapping to /services/.

The RESTful API is defined in the class RestDslRouteBuilder

There is a single GET operation, which returns the string "Hello, world!"
There is a single POST operation, which takes a name in a JSON object, and then returns that name in the output.
Camel will marshal (convert) between JSON and Java automatically. This is because we have defined Java classes (POJOs) for our Request and Response types, and they are specified in the REST DSL configuration (as type() and outType()).

The example
The code is in RestDslRouteBuilder and looks like this:

// This section is required - it tells Camel how to configure the REST service
restConfiguration()
    // Use the 'servlet' component.
    // This tells Camel to create and use a Servlet to 'host' the RESTful API.
    // Since we're using Spring Boot, the default servlet container is Tomcat.
    .component("servlet")

    // Allow Camel to try to marshal/unmarshal between Java objects and JSON
    .bindingMode(RestBindingMode.auto);


// Now define the REST API (POST, GET, etc.)
rest()
    .path("/api") // This makes the API available at http://host:port/\$CONTEXT_ROOT/api

    .consumes("application/json")
    .produces("application/json")

    // HTTP: GET /api
    .get()
        .outType(ResponseType.class) // Setting the response type enables Camel to marshal the response to JSON
        .to("bean:getBean") // This will invoke the Spring bean 'getBean'

    // HTTP: POST /api
    .post()
        .type(PostRequestType.class) // Setting the request type enables Camel to unmarshal the request to a Java object
        .outType(ResponseType.class) // Setting the response type enables Camel to marshal the response to JSON
        .to("bean:postBean");
To run
To run the app:

mvn clean spring-boot:run
Then, to test the REST service's GET operation - see how it returns a JSON object:

\$ curl http://localhost:8080/services/api/
{"message":"Hello, world!"}
And to test the REST service's POST operation - see how it returns a JSON object:

\$ curl --request POST \\
    --data "{ \\"name\\": \\"Jeff Mills\\" }" \\
    --header "Content-Type: application/json" \\
    http://localhost:8080/services/api/
{"message":"Thanks for your post, Jeff Mills!"}
*/