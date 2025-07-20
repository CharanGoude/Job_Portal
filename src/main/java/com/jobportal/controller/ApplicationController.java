package com.jobportal.controller;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/applicant/apply/{jobId}")
    public String apply(@PathVariable Long jobId, @AuthenticationPrincipal UserDetails userDetails) {
        User applicant = userRepository.findByUsername(userDetails.getUsername());
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job != null) {
            Application application = new Application();
            application.setApplicant(applicant);
            application.setJob(job);
            application.setStatus("APPLIED");
            applicationRepository.save(application);
        }
        return "redirect:/";
    }

    @GetMapping("/applicant/applications")
    public String myApplications(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User applicant = userRepository.findByUsername(userDetails.getUsername());
        List<Application> applications = applicationRepository.findByApplicant(applicant);
        model.addAttribute("applications", applications);
        return "my_applications";
    }
}
