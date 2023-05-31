package com.example.administration.service;

import com.example.administration.entity.Administration;
import com.example.administration.repository.AdminRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{
    @Override
    public Administration createAdministration(Administration administration) {
        return adminRespository.save(administration);
    }    private AdminRespository adminRespository;


    @Override
    public Administration getAdministrationById(Long administrationId) {
        Optional<Administration> optionalAdministration = adminRespository.findById(administrationId);
        return optionalAdministration.get();
    }

    @Override
    public List<Administration> getAllAdministration() {
        return adminRespository.findAll();
    }

    @Override
    public Administration updateAdministration(Administration administration) {
        Administration existingAdministration = adminRespository.findById(administration.getId()).get();
        existingAdministration.setFirstname(administration.getFirstname());
        existingAdministration.setLastname(administration.getLastname());
        existingAdministration.setEmail(administration.getEmail());
        existingAdministration.setPassword(administration.getPassword());
        Administration updateAdministration = adminRespository.save(existingAdministration);
        return updateAdministration;
    }

    @Override
    public void deleteAdministration(Long AdministrationId) {
        adminRespository.deleteById(AdministrationId);
    }
}
