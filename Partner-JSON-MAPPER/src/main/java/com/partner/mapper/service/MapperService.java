package com.partner.mapper.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.mapper.pojo.PartnerInput;
import com.partner.mapper.pojo.PartnerSpec;
import com.partner.mapper.repository.PartnerInputRepo;
import com.partner.mapper.repository.PartnerMapperRepsitory;

@Service
public class MapperService {

	@Autowired
	private PartnerMapperRepsitory partnerMapperRepo;
	@Autowired
	private PartnerInputRepo partnerInputRepo;

	@Transactional
	public PartnerSpec getSpec(int partnerId) {

		return partnerMapperRepo.findById(partnerId).get();

	}

	@Transactional
	public PartnerInput getInput(int partnerId) {

		return partnerInputRepo.findById(partnerId).get();

	}

}
