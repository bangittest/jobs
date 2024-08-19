package com.example.company.clients;

import com.example.company.external.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MYPRESS-SERVICE")
public interface MyPress {
    @GetMapping("/user/{userId}")
    User getUser(@PathVariable("userId") Long userId);

    @GetMapping("/user/averageRating")
    Long getUserAverageRating(@RequestParam("companyId") Long companyId);
}
