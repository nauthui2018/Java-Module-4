package com.controller;


import com.model.Smartphone;
import com.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/api/smartphones/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Smartphone> delete(@PathVariable("id") Long id) {
        Smartphone deletePhone = smartphoneService.remove(id);

        return new ResponseEntity<Smartphone>(deletePhone, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/smartphones/", method = RequestMethod.POST)
    public ResponseEntity<Smartphone> create(@RequestBody Smartphone smartphone) {
        Smartphone deletePhone = smartphoneService.save(smartphone );

        return new ResponseEntity<Smartphone>(deletePhone, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/smartphones/{id}", method = RequestMethod.GET)
    public ResponseEntity<Smartphone> getSmartphone (@PathVariable("id") Long id) {
        Smartphone editPhone = smartphoneService.findById(id);
        return  new ResponseEntity<Smartphone>(editPhone, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/smartphones/", method = RequestMethod.PUT)
    public ResponseEntity<Smartphone> update (@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
        return new ResponseEntity<Smartphone>(smartphone, HttpStatus.OK);
    }
}
