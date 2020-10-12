package com.partner.mapper.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Table(name = "partner_input", schema = "uber_eat")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
public class PartnerInput {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "input", columnDefinition = "jsonb")
	@Type(type = "jsonb")
	private String input;

	public PartnerInput() {

	}

	public PartnerInput(String input) {
		this.input = input;

	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
