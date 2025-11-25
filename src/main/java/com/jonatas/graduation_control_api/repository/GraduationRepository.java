package com.jonatas.graduation_control_api.repository;

import com.jonatas.graduation_control_api.model.AttendancesModel;
import com.jonatas.graduation_control_api.model.GraduationsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduationRepository extends JpaRepository<GraduationsModel, String> {
}
