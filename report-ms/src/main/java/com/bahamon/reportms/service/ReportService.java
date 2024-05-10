package com.bahamon.reportms.service;

import java.time.LocalDate;
import java.util.List;

import com.bahamon.reportms.models.Company;
import com.bahamon.reportms.models.WebSite;

public interface ReportService {
    String makeReport( String name );
    Boolean saveReport( Company company );
    void deleteReport( String name );
}
