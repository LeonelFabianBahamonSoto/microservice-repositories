package com.bahamon.reportms.service;

import org.springframework.stereotype.Service;

import com.bahamon.reportms.repository.CompaniesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;

    @Override
    public String makeReport(String name) {
        var company = this.companiesRepository.getByName(name)
            .orElseThrow(() -> new RuntimeException("Error al consultar el nombre de la empresa"))
            .getName();

        return company;
    }

    @Override
    public String saveReport(String nameReport) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveReport'");
    }

    @Override
    public void deleteReport(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReport'");
    }

}
