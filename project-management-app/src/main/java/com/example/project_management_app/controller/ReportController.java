package com.example.project_management_app.controller;

import com.example.project_management_app.model.Report;
import com.example.project_management_app.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Ajouter un nouveau rapport
    @PostMapping
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        Report newReport = reportService.addReport(report);
        return new ResponseEntity<>(newReport, HttpStatus.CREATED);
    }

    // Récupérer un rapport par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Optional<Report> report = reportService.getReportById(id);
        return report.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Récupérer tous les rapports pour un projet spécifique
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Report>> getReportsByProjectId(@PathVariable Long projectId) {
        List<Report> reports = reportService.getReportsByProjectId(projectId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Récupérer tous les rapports soumis par un utilisateur spécifique
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Report>> getReportsByUserId(@PathVariable Long userId) {
        List<Report> reports = reportService.getReportsByUserId(userId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Récupérer tous les rapports soumis à une date spécifique
    @GetMapping("/date")
    public ResponseEntity<List<Report>> getReportsByReportDate(@RequestParam("reportDate") Date reportDate) {
        List<Report> reports = reportService.getReportsByReportDate(reportDate);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Récupérer tous les rapports pour un projet spécifique à une date donnée
    @GetMapping("/project/{projectId}/date")
    public ResponseEntity<List<Report>> getReportsByProjectIdAndReportDate(@PathVariable Long projectId,
                                                                           @RequestParam("reportDate") Date reportDate) {
        List<Report> reports = reportService.getReportsByProjectIdAndReportDate(projectId, reportDate);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Récupérer tous les rapports d'un utilisateur spécifique à une date donnée
    @GetMapping("/user/{userId}/date")
    public ResponseEntity<List<Report>> getReportsByUserIdAndReportDate(@PathVariable Long userId,
                                                                        @RequestParam("reportDate") Date reportDate) {
        List<Report> reports = reportService.getReportsByUserIdAndReportDate(userId, reportDate);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Supprimer un rapport par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReport(@PathVariable Long id) {
        reportService.removeReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
