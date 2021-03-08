package com.javainuse.route;

import com.javainuse.model.Root;
import com.javainuse.processor.MyProcessor;
import org.apache.camel.Exchange;
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
						.setHeader(Exchange.HTTP_METHOD, simple("GET"))
						.setHeader("authority", simple("samfhirsdf.azurehealthcareapis.com"))
						.setHeader("accept", simple("/"))
						.setHeader("authorization", simple("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyIsImtpZCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyJ9.eyJhdWQiOiJodHRwczovL3NhbWZoaXJzZGYuYXp1cmVoZWFsdGhjYXJlYXBpcy5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC80Y2E1MjI5My02NjlmLTRmYTgtODA3OC1mOGViOGI4MWE0OGQvIiwiaWF0IjoxNjE1MTE0NzY3LCJuYmYiOjE2MTUxMTQ3NjcsImV4cCI6MTYxNTExODY2NywiYWNyIjoiMSIsImFpbyI6IkFWUUFxLzhUQUFBQXpsKytzcXg0eFBpNGJ4UktwTC96RkltZ3RwZFZQTnZrellvbnptbzdRU3YrVzN5Tk1XVWVFT0Q4N0lmYnRDZXVqUzV3anNVUXVuZVNKclp4UzlxU1VLRmJTNGZ6RXRRcXc3MVlMSXBpWk5JPSIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiJmYjYxMWQ5ZS1mZTk5LTQ1YzEtYmY5Ny1mZWExNmQ1NDU0MjMiLCJhcHBpZGFjciI6IjEiLCJlbWFpbCI6InNhbXJpZGhpczE5ODBAaG90bWFpbC5jb20iLCJmYW1pbHlfbmFtZSI6IlNodSIsImdpdmVuX25hbWUiOiJTYW0iLCJpZHAiOiJsaXZlLmNvbSIsImlwYWRkciI6IjU4LjEwNS4xOTcuODEiLCJuYW1lIjoiU2FtIFNodSIsIm9pZCI6ImIwZmRmZjk3LTJmYjctNGQzNS1iYjhjLTE2MTljNDIzODExMyIsInJoIjoiMC5BV1lBa3lLbFRKOW1xRS1BZVBqcmk0R2tqWjRkWWZ1Wl9zRkZ2NWYtb1cxVVZDTm1BUGcuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwic3ViIjoiRm1yWC1pcEg2OEU1Qnd3NURFU1ZHNk9NUW5odUt6X3NNMXZyZU5yMVpqdyIsInRpZCI6IjRjYTUyMjkzLTY2OWYtNGZhOC04MDc4LWY4ZWI4YjgxYTQ4ZCIsInVuaXF1ZV9uYW1lIjoibGl2ZS5jb20jc2FtcmlkaGlzMTk4MEBob3RtYWlsLmNvbSIsInV0aSI6ImdDOWpIZE1VazAyS3B6RmVsZHhvQUEiLCJ2ZXIiOiIxLjAifQ.DimSoBHjQ81mE_q2VlyWEHc0XVbYxPLB1jT3Bs3cLtokqmWwemoF7U2rWMd5vvTGPoStreubkKugYuYBXWDrL0etckmDZGluXyQrVlQowSNsFLUntUOHE-iLdyUYckX-3ls2jb8DTs1oGundEjBuuJ4ITraexQ1jEkW_iZemSaKi-SbP-_dq24HSZMDlNndCXmZ3aKL8A0bz-rWNbiZWdW1PFziBhHTl2QtUlvxpBQUl8hG-1GYAk9FBojGOTWb1Bxb4kxJgOlLHTPa4GbqH55gtZNXZRNVDq-fqd5YxEuN507sh9bOaaSNLosshZbkMquJl5bvUV6yh_1kZgG4D8g"))
						.setHeader("user-agent", simple("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36"))
						.setHeader("origin", simple("https://samfhirsdfdash.azurewebsites.net"))
						.setHeader("sec-fetch-site", simple("cross-site"))
						.setHeader("sec-fetch-mode", simple("cors"))
						.setHeader("sec-fetch-dest", simple("empty"))
						.setHeader("referer", simple("https://samfhirsdfdash.azurewebsites.net/"))
						.setHeader( "accept-language", simple("en-GB,en-US;q=0.9,en;q=0.8"))
						.toF("https://samfhirsdf.azurehealthcareapis.com/Practitioner" + "?bridgeEndpoint=true")
						//.outType(ResponseType.class) 
						.process(new MyProcessor())
						.log("Response  ${body}").convertBodyTo(String.class)

						//.to("https://samfhirsdf.azurehealthcareapis.com/Practitioner").process(new MyProcessor());
						.end();

		rest().get("/api")
						.route()
						//.outType(Root.class)
						.to("direct:myService")
						.end()
						.marshal()
						.json(JsonLibrary.Jackson)
						.convertBodyTo(String.class)
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