package br.com.cinq.greet.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GreetRequest implements Serializable {

	private @JsonIgnore static final long serialVersionUID = 2091630895364969511L;
	private @JsonProperty String greet;

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}
}
