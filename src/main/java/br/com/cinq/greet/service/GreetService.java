package br.com.cinq.greet.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cinq.greet.bean.GreetMessage;
import br.com.cinq.greet.bean.GreetRequest;

@Component
@Path("/greet")
public class GreetService {

	private @Autowired GreetMessage greet;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieve() {
		return Response.ok(greet).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response change(GreetRequest request) {
		greet.configure(request.getGreet());
		return Response.ok().build();
	}
}
