package com.bahamon.reportms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahamon.reportms.service.ReportService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@RequestMapping(path = "/report")
@RestController
@Slf4j
public class ReportController {

    private ReportService reportService;

    @GetMapping( path = "/{name}" )
    public ResponseEntity<Map<String, String>> getReport( @PathVariable String name ) {
        log.info("----> INGRESO!", name);
        var response = Map.of( "report", this.reportService.makeReport(name) );

        return ResponseEntity.ok( response );
    }

}
