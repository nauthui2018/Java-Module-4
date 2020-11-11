package com.controller;


import com.model.Smartphone;
import com.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    SmartphoneService smartphoneService;
    @RequestMapping(value = "/api/smartphones/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Smartphone>> listAllPhones() {
        Iterable<Smartphone> allPhones = smartphoneService.findAll();
        if (allPhones == null) {
            return new ResponseEntity<Iterable<Smartphone>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Smartphone>>(allPhones, HttpStatus.OK);
    }

}
