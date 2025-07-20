Job Portal System

Project Overview

This Job Portal System is a web application designed to connect employers with job seekers. It allows employers to post job listings and manage applications, while applicants can browse available jobs, apply, and track their application status.

Key Features

User Roles: Distinct roles for Employers and Applicants ensure tailored experiences and permissions.

Secure Authentication: Users can register and log in securely, powered by Spring Security.

Job Management:

Employers can post new jobs, view their listings, edit job details, and delete jobs.

Employers can also review applications submitted for their jobs.

Job Application:

Applicants can browse all available job postings and view detailed descriptions.

They can submit applications for desired jobs.

Applicants can track the real-time status of their submitted applications.

Search & Filtering: (Planned/Future Enhancement) Functionality to search jobs by keywords and filter by criteria like location or salary.

Technologies Used
Backend: Java (Spring Boot)

Database: MySQL

Web Framework: Thymeleaf (for dynamic HTML pages)

Security: Spring Security (for user authentication and authorization)

Getting Started
To run this project, you'll need:

Java Development Kit (JDK): Version 17 or higher.

MySQL Server: For the database.

Maven: As the build tool.

Setup Steps:
Database Setup: Create a MySQL database (e.g., jobportaldb). The application will handle table creation automatically using Spring Data JPA.

Configuration: Update the application.properties file with your MySQL database connection details (username, password, URL).

Build: Use Maven to build the project.

Run: Execute the compiled application.

How to Use
Once the application is running (typically at localhost:3306/job_portal):

Test Credentials
You can register new accounts directly from the /register page to create your own test users.

Employer Account: Register with the EMPLOYER role.

Applicant Account: Register with the APPLICANT role.

Employer Workflow
Log in with an Employer account.

Navigate to your employer dashboard (e.g., /employer/jobs).

Post new jobs using the provided form.

View and manage your existing job listings.

Review applications submitted for your posted jobs.

Applicant Workflow
Log in with an Applicant account.

Browse available jobs (e.g., /applicant/jobs).

View job details for any listing that interests you.

Apply for jobs directly from the job details page.

Track the status of all your applications from your dashboard (e.g., /applicant/applications).
