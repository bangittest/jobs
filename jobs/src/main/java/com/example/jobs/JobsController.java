package com.example.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobsController {
    private final JobsService jobsService;
    @GetMapping("/jobs")
    public ResponseEntity<List<Jobs>> getAll(){
        return new ResponseEntity<>(jobsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<Jobs> save(@RequestBody Jobs jobs){
        Jobs jobs1 = jobsService.save(jobs);
        return new ResponseEntity<>(jobs1,HttpStatus.OK);
    }
    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<?>findById(@PathVariable(name = "jobId") Long jobId){
        Jobs jobs = jobsService.findById(jobId);
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }
}
