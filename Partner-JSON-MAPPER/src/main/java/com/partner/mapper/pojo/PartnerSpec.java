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

@Table(name = "partner_spec", schema = "uber_eat")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
public class PartnerSpec {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	 @Column(name = "spec", columnDefinition = "jsonb")
	 @Type(type = "jsonb")
	 private String spec;

	public PartnerSpec() {

	}

	public PartnerSpec(String spec) {
		this.spec = spec;
		
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
}
