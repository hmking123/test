package com.example.project_management_app.service;

import com.example.project_management_app.model.Report;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReportService {

    Report addReport(Report report);

    Optional<Report> getReportById(Long id);

    List<Report> getReportsByProjectId(Long projectId);

    List<Report> getReportsByUserId(Long userId);

    List<Report> getReportsByReportDate(Date reportDate);

    List<Report> getReportsByProjectIdAndReportDate(Long projectId, Date reportDate);

    List<Report> getReportsByUserIdAndReportDate(Long userId, Date reportDate);

    void removeReport(Long id);
}
