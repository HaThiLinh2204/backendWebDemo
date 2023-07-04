package com.gr1.shop.repository;

import com.gr1.shop.domain.SizeGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeGiayRepository extends JpaRepository<SizeGiay, String>, JpaSpecificationExecutor<SizeGiay> {
}
