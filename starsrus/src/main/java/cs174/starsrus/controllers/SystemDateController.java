package cs174.starsrus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs174.starsrus.repositories.SystemDateRepository;

@RestController
@RequestMapping("api/")
public class SystemDateController {

    @Autowired
    private SystemDateRepository systemDateRepository;

    public SystemDateRepository getSystemDateRepository() {
        return systemDateRepository;
    }

    public void setSystemDateRepository(SystemDateRepository systemDateRepository) {
        this.systemDateRepository = systemDateRepository;
    }



}
