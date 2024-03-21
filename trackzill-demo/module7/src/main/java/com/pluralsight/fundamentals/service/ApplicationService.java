package com.pluralsight.fundamentals.service;

import com.pluralsight.fundamentals.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> listApplications();

    Application findApplication(long id);
}


