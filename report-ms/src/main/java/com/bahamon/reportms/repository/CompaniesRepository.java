package com.bahamon.reportms.repository;

import java.util.Optional;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bahamon.reportms.beans.LoadBalancerConfiguration;
import com.bahamon.reportms.models.Company;

@FeignClient( name = "companies-crud" )
@LoadBalancerClient( name = "companies-crud", configuration = LoadBalancerConfiguration.class )
public interface CompaniesRepository {

    // @GetMapping( path = "http://localhost:8081/companies/company/getCompany/{name}")
    @GetMapping( path = "/companies/company/getCompany/{name}")
    Optional<Company> getByName( @PathVariable String name );

    @PostMapping( path = "/companies/company/createCompany")
    Optional<Company> postByName( @RequestBody Company company );

    @DeleteMapping( path = "/companies/company/delete/{name}" )
    Optional<Company> deleteByName( @PathVariable String name );
}
