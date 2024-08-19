package com.example.company;

import com.example.company.clients.JobsClient;
import com.example.company.clients.MyPress;
import com.example.company.dto.CompanyWithJob;
import com.example.company.dto.ReviewMessage;
import com.example.company.external.Jobs;
import com.example.company.external.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.JobSheets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate;
    private final JobsClient jobsClient;
    private final MyPress myPress;
    @Override
    public List<CompanyWithJob> findAll() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyWithJob>companyWithJobs =new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
        for (Company company : companies){
            CompanyWithJob companyWithJob = new CompanyWithJob();
            companyWithJob.setCompany(company);
//            Jobs jobs = restTemplate.getForObject("http://JOB-SERVICE:8081/jobs/" + company.getId(), Jobs.class);
            Jobs jobs = jobsClient.getJobs(company.getId());
//            ResponseEntity<User> responseEntity = restTemplate.exchange(
//                    "http://MYPRESS-SERVICE:8083/user/" + company.getId(),
//                    HttpMethod.GET,null,
//                    new ParameterizedTypeReference<User>() {}
//            );

//            User users = responseEntity.getBody();

            User users = myPress.getUser(company.getId());

            companyWithJob.setJobs(jobs);
            companyWithJob.setUser(users);
            companyWithJobs.add(companyWithJob);
        }
//        //call service khác
//        RestTemplate restTemplate = new RestTemplate();
//        Jobs jobs = restTemplate.getForObject("http://localhost:8081/jobs/1", Jobs.class);
//        System.out.println("Job " + jobs.getId());
//        System.out.println( "jobs" + jobs.getName());
        return companyWithJobs;
    }

    @Override
    public Company save(Company company) {
        Company company1 = new Company();
        company1.setName(company.getName());
        company1.setDescription(company.getDescription());
        companyRepository.save(company1);
        return company1;
    }

    @Override
    public void updateCompany(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getEmail());
        Company company =companyRepository.findById(reviewMessage.getId()).orElse(null);
        Long companyId = myPress.getUserAverageRating(reviewMessage.getId());
        assert company != null;
        company.setDescription(companyId.toString());
        companyRepository.save(company);
    }
}
