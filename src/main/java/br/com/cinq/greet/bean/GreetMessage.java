package br.com.cinq.greet.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@Scope("singleton")
public class GreetMessage implements Serializable {
	
	private @JsonIgnore static final long serialVersionUID = -3965430318392268506L;
	private @JsonProperty volatile String greet;
	
	public void configure(String greet) {
		this.greet = greet;
	}
}
