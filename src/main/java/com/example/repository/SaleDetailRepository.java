package com.example.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SaleDetail;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
    Page<SaleDetail> findByItemItemName(String itemName, Pageable pageable);
    Page<SaleDetail> findByCustName(String custName, Pageable pageable);
    Page<SaleDetail> findByMobileNo(String mobileNo, Pageable pageable);
    Page<SaleDetail> findByPayAmountGreaterThan(double amount, Pageable pageable);
}