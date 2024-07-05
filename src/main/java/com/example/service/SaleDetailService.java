package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.SaleDetail;
import com.example.repository.SaleDetailRepository;


@Service
public class SaleDetailService {
    @Autowired
    private SaleDetailRepository saleDetailRepository;

    public SaleDetail saveSaleDetail(SaleDetail saleDetail) {
        if (saleDetail.isMinor() && saleDetail.getPayAmount() > 1000) {
            throw new IllegalArgumentException("Minors can shop for only RS.1000");
        }
        if ("Maharashtra".equalsIgnoreCase(saleDetail.getState())) {
            saleDetail.setPayAmount(saleDetail.getPayAmount() * 0.8);
        }
        return saleDetailRepository.save(saleDetail);
    }
     

    public Page<SaleDetail> searchByItemName(String itemName, Pageable pageable) {
        return saleDetailRepository.findByItemItemName(itemName, pageable);
    }

    public Page<SaleDetail> searchByCustName(String custName, Pageable pageable) {
        return saleDetailRepository.findByCustName(custName, pageable);
    }

    public Page<SaleDetail> searchByMobileNo(String mobileNo, Pageable pageable) {
        return saleDetailRepository.findByMobileNo(mobileNo, pageable);
    }

    public Page<SaleDetail> searchByPayAmount(double amount, Pageable pageable) {
        return saleDetailRepository.findByPayAmountGreaterThan(amount, pageable);
    }

    public void deleteSaleDetail(Long id) {
        saleDetailRepository.deleteById(id);
    }

    public SaleDetail updateSaleDetail(Long id, SaleDetail saleDetail) {
        SaleDetail existingSaleDetail = saleDetailRepository.findById(id).orElseThrow();
        existingSaleDetail.setCustName(saleDetail.getCustName());
        existingSaleDetail.setMobileNo(saleDetail.getMobileNo());
        existingSaleDetail.setItem(saleDetail.getItem());
        existingSaleDetail.setAddress(saleDetail.getAddress());
        existingSaleDetail.setState(saleDetail.getState());
        existingSaleDetail.setDateOfBirth(saleDetail.getDateOfBirth());
        existingSaleDetail.setQuantity(saleDetail.getQuantity());
        existingSaleDetail.setPrice(saleDetail.getPrice());
        existingSaleDetail.setPayAmount(saleDetail.getPayAmount());
        existingSaleDetail.setEmailId(saleDetail.getEmailId());
        return saleDetailRepository.save(existingSaleDetail);
    }


	public List<SaleDetail> getAllSaleDetail() {
		
		return saleDetailRepository.findAll();
	}
}