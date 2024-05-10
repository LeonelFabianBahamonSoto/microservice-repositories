package com.bahamon.reportms.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bahamon.reportms.models.Company;

@Component
public class ReportHelper {

    @Value( "${report.template}" )
    private String reportTemplate;

    public String readTemplate( Company company ) {

        return this.reportTemplate
            .replace( "{company}",         company.getName() )
            .replace( "{foundation_date}", company.getFoundationDate().toString() )
            .replace( "founder",           company.getFounder() )
            .replace( "web_sites",         company.getWebSites().toString() );
    };
}
