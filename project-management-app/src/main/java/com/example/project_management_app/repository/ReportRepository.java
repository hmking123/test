package com.example.project_management_app.repository;

import com.example.project_management_app.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByProjectId(Long projectId);

    List<Report> findByUserId(Long userId);

    List<Report> findByReportDate(Date reportDate);

    List<Report> findByProjectIdAndReportDate(Long projectId, Date reportDate);

    List<Report> findByUserIdAndReportDate(Long userId, Date reportDate);
}
