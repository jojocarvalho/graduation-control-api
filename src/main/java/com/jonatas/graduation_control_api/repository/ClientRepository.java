package com.jonatas.graduation_control_api.repository;

import com.jonatas.graduation_control_api.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, String> {
}
