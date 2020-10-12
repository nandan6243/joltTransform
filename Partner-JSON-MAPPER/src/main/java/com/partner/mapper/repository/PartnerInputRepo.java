package com.partner.mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.partner.mapper.pojo.PartnerInput;

@Repository
public interface PartnerInputRepo extends JpaRepository<PartnerInput, Integer>{

}
