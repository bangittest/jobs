package com.example.company.dto;

import com.example.company.Company;
import com.example.company.external.Jobs;
import com.example.company.external.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyWithJob {
    private Jobs jobs;
    private Company company;
    private User user;

}
