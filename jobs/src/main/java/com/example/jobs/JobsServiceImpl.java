package com.example.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService{

    private final JobsRepository jobsRepository;
    @Override
    public List<Jobs> findAll() {
        return jobsRepository.findAll();
    }

    @Override
    public Jobs save(Jobs jobs) {
        Jobs jobs1 = new Jobs();
        jobs1.setId(jobs.getId());
        jobs1.setName(jobs.getName());
        jobs1.setDescription(jobs.getDescription());
        jobsRepository.save(jobs1);
        return jobs1;
    }

    @Override
    public Jobs findById(Long id) {
        return jobsRepository.findById(id).orElse(null);
    }
}
