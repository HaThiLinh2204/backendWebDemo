package com.gr1.shop.repository;

import com.gr1.shop.domain.Anh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhRepository extends JpaRepository<Anh, String>, JpaSpecificationExecutor<Anh> {
}
