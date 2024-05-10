package com.bahamon.reportms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bahamon.reportms.helpers.ReportHelper;
import com.bahamon.reportms.models.Company;
import com.bahamon.reportms.models.WebSite;
import com.bahamon.reportms.repository.CompaniesRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {

        Company company = this.companiesRepository.getByName(name)
            .orElseThrow(() -> new RuntimeException("Error al consultar el nombre de la empresa"));

        String report = reportHelper.readTemplate( company );

        return report;
    }

    @Override
    public Boolean saveReport( Company company ) {

        Company newCompany = Company.builder()
            .name( company.getName() )
            .founder( company.getFounder() )
            .logo( company.getLogo() )
            .foundationDate( company.getFoundationDate() )
            .webSites( company.getWebSites() )
            .build();

        var response = this.companiesRepository.postByName( newCompany );

        if( response.isEmpty() ) {
            return false;
        }

        return true;
    }

    @Override
    public void deleteReport( String name ) {
        this.companiesRepository.deleteByName( name );
    }

}
