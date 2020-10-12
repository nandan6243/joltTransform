package com.partner.mapper.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partner.mapper.pojo.PartnerInput;
import com.partner.mapper.pojo.PartnerSpec;
import com.partner.mapper.service.MapperService;

@RestController
public class MapperController {

	@Autowired
	private MapperService mapperService;

	@RequestMapping(value = "/getPartner1Json", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> getPartnerJson1(@RequestParam(value = "partnerId", required = true) int partnerId,
			HttpServletRequest request, HttpServletResponse response) {

		PartnerSpec spec = mapperService.getSpec(partnerId);

		PartnerInput input = mapperService.getInput(partnerId);

		List chainrSpecJSON = JsonUtils.jsonToList(spec.getSpec().toString());
		Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

		Object inputJSON = JsonUtils.jsonToObject(input.getInput().toString());

		Object transformedOutput = chainr.transform(inputJSON);
		System.out.println(JsonUtils.toJsonString(transformedOutput));

		return new ResponseEntity<>(JsonUtils.toJsonString(transformedOutput), HttpStatus.OK);

	}

}
