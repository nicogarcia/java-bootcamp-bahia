package com.globant.app.domain.paymentMethods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PayInfoField {

	private String name;
	private String nameReadable;
	private String value;

	public PayInfoField() {
	}

	public PayInfoField(String name, String nameReadable) {
		this.name = name;
		this.nameReadable = nameReadable;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonIgnore
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getNameReadable() {
		return nameReadable;
	}

	@JsonIgnore
	public void setNameReadable(String nameReadable) {
		this.nameReadable = nameReadable;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
