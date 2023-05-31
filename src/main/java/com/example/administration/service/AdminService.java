package com.example.administration.service;

import com.example.administration.entity.Administration;

import java.util.List;

public interface AdminService {
    Administration createAdministration (Administration administration);

    Administration getAdministrationById(Long administrationId);

    List<Administration> getAllAdministration();

    Administration updateAdministration(Administration administration);

    void deleteAdministration(Long AdministrationId);
}
