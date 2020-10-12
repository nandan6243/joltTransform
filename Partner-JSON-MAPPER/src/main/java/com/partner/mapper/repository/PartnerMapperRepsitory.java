package com.partner.mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.partner.mapper.pojo.PartnerSpec;

@Repository
public interface PartnerMapperRepsitory extends JpaRepository<PartnerSpec, Integer> {

	
}
