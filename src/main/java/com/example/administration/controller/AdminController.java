package com.example.administration.controller;

import com.example.administration.entity.Administration;
import com.example.administration.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("administration")
public class AdminController {

    private AdminService adminService;

    //building create Administration Rest API
    @PostMapping
    public ResponseEntity<Administration> createAdministration (@RequestBody Administration administration){
        Administration savedAdminstration = adminService.createAdministration(administration);
        return new ResponseEntity<>(savedAdminstration, HttpStatus.CREATED);
    }

    //Build Get all Users REST API
    // http://localhost:8080/api/administration/1
    @GetMapping("{id}")
    public ResponseEntity<Administration> getAdministrationById(@PathVariable("id") Long administrationId){
        Administration administration = adminService.getAdministrationById(administrationId);
        return new ResponseEntity<>(administration , HttpStatus.OK);
    }

    //Build Get All Administration REST API
    // http://localhost:8080/api/administration
    @GetMapping("/all")
    public ResponseEntity<List<Administration>> getAllAdministration(){
        List<Administration> administrations = adminService.getAllAdministration();
        return new ResponseEntity<>(administrations, HttpStatus.OK);
    }

    //Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/administration/1
    public ResponseEntity<Administration> updateAdministration(@PathVariable("id") Long administrationId, @RequestBody Administration administration){

        Administration updatedAdministration = adminService.updateAdministration(administration);
        return new ResponseEntity<>(updatedAdministration, HttpStatus.OK);
    }

    //Build Delete Administration REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String > deleteAdministration(@PathVariable("id") Long administrationId){
        adminService.deleteAdministration(administrationId);
        return new ResponseEntity<>("Admin successfully deleted!", HttpStatus.OK);
    }
}
