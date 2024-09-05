package com.example.project_management_app.service;

import com.example.project_management_app.model.Report;
import com.example.project_management_app.repository.ReportRepository;
import com.example.project_management_app.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Optional<Report> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<Report> getReportsByProjectId(Long projectId) {
        return reportRepository.findByProjectId(projectId);
    }

    @Override
    public List<Report> getReportsByUserId(Long userId) {
        return reportRepository.findByUserId(userId);
    }

    @Override
    public List<Report> getReportsByReportDate(Date reportDate) {
        return reportRepository.findByReportDate(reportDate);
    }

    @Override
    public List<Report> getReportsByProjectIdAndReportDate(Long projectId, Date reportDate) {
        return reportRepository.findByProjectIdAndReportDate(projectId, reportDate);
    }

    @Override
    public List<Report> getReportsByUserIdAndReportDate(Long userId, Date reportDate) {
        return reportRepository.findByUserIdAndReportDate(userId, reportDate);
    }

    @Override
    public void removeReport(Long id) {
        reportRepository.deleteById(id);
    }
}
