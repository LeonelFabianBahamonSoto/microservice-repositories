package com.bahamon.reportms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahamon.reportms.models.Company;
import com.bahamon.reportms.service.ReportService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RequestMapping(path = "/report")
@RestController
@Slf4j
public class ReportController {

    private ReportService reportService;

    @GetMapping( path = "/{name}" )
    public ResponseEntity<Map<String, String>> getReport( @PathVariable String name ) {
        var response = Map.of( "report", this.reportService.makeReport(name) );
        return ResponseEntity.ok( response );
    }

    @PostMapping( path = "/new-company-report" )
    public ResponseEntity<String> postReport( @RequestBody Company newCompany ) {

        var response = this.reportService.saveReport( newCompany );

        if( response ) {
            return ResponseEntity.status( HttpStatus.CREATED ).build();
        }
        else {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).build();
        }
    }

    @DeleteMapping( path = "/delete-company/{name}" )
    public ResponseEntity<String> postReport( @PathVariable String name ) {
        this.reportService.deleteReport( name );

        return ResponseEntity.noContent().build();
    }
}
