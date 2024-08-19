package com.example.company.clients;

import com.example.company.external.Jobs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "JOB-SERVICE-DEV" ,url="${job-service.url}")
public interface JobsClient {
    @GetMapping("/jobs/{jobId}")
    Jobs getJobs(@PathVariable("jobId") Long jobId);
}
