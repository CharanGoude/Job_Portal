package com.jobportal.controller;

import com.jobportal.model.Job;
import com.jobportal.model.User;
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
public class JobController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String keyword) {
        List<Job> jobs = (keyword == null || keyword.isEmpty())
            ? jobRepository.findAll()
            : jobRepository.findByTitleContainingOrLocationContaining(keyword, keyword);
        model.addAttribute("jobs", jobs);
        return "job_list";
    }

    @GetMapping("/employer/post")
    public String postJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "post_job";
    }

    @PostMapping("/employer/post")
    public String postJob(@ModelAttribute Job job, @AuthenticationPrincipal UserDetails userDetails) {
        User employer = userRepository.findByUsername(userDetails.getUsername());
        job.setEmployer(employer);
        jobRepository.save(job);
        return "redirect:/employer/jobs";
    }

    @GetMapping("/employer/jobs")
    public String employerJobs(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User employer = userRepository.findByUsername(userDetails.getUsername());
        List<Job> jobs = jobRepository.findAll().stream()
            .filter(j -> j.getEmployer().getId().equals(employer.getId()))
            .toList();
        model.addAttribute("jobs", jobs);
        return "employer_jobs";
    }
}
