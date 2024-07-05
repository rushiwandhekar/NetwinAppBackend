package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.SaleDetail;
import com.example.service.SaleDetailService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
public class SaleDetailController {
    @Autowired
    private SaleDetailService saleDetailService;

    @PostMapping("/createSaleDetail")
    public SaleDetail createSaleDetail(@Valid  @RequestBody SaleDetail saleDetail) {
        return saleDetailService.saveSaleDetail(saleDetail);
    }
    
    @GetMapping("/getAllSaleDetails")
    public List<SaleDetail>getAllSaleDetail() {
        return saleDetailService.getAllSaleDetail();
    }
    
    @PutMapping("/updateSaleDetail/{id}")
    public SaleDetail updateSaleDetail(@PathVariable Long id,@Valid @RequestBody SaleDetail saleDetail) {
        return saleDetailService.updateSaleDetail(id, saleDetail);
    }
   
    @DeleteMapping("/deleteSaleDetail/{id}")
    public void deleteSaleDetail(@PathVariable Long id) {
        saleDetailService.deleteSaleDetail(id);
    }

    @GetMapping("/searchByItemName")
    public Page<SaleDetail> searchByItemName(@RequestParam String itemName, @PageableDefault(size = 20) Pageable pageable) {
        return saleDetailService.searchByItemName(itemName,pageable);
    }

    @GetMapping("/searchByCustName")
    public Page<SaleDetail> searchByCustName(@RequestParam String custName,@PageableDefault(size = 20) Pageable pageable) {
        return saleDetailService.searchByCustName(custName,pageable);
    }

    @GetMapping("/searchByMobileNo")
    public Page<SaleDetail> searchByMobileNo(@RequestParam String mobileNo,@PageableDefault(size = 20) Pageable pageable) {
        return saleDetailService.searchByMobileNo(mobileNo,pageable);
    }

    @GetMapping("/searchByPayAmount")
    public Page<SaleDetail> searchByPayAmount(@RequestParam double amount,@PageableDefault(size = 20) Pageable pageable) {
        return saleDetailService.searchByPayAmount(amount,pageable);
    }
}