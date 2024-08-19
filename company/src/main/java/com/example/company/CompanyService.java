package com.example.company;

import com.example.company.dto.CompanyWithJob;
import com.example.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<CompanyWithJob>findAll();
    Company save (Company company);
    void updateCompany(ReviewMessage reviewMessage);
}
