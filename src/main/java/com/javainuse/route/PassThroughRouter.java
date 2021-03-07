package com.javainuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import com.javainuse.processor.MyProcessor;

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
						.process(new MyProcessor())
						.log("Response  ${body}").convertBodyTo(String.class)

						//.to("https://samfhirsdf.azurehealthcareapis.com/Practitioner").process(new MyProcessor());
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
