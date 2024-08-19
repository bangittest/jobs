package com.example.jobs;

import java.util.List;

public interface JobsService {
    List<Jobs>findAll();
    Jobs save (Jobs jobs);
    Jobs findById(Long id);
}
