package com.jonatas.graduation_control_api.repository;

import com.jonatas.graduation_control_api.model.AttendancesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendancesRepository extends JpaRepository<AttendancesModel, String> {
}
