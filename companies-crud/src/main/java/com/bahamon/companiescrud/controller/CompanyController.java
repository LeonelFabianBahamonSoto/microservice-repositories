package com.bahamon.companiescrud.controller;

import com.bahamon.companiescrud.entity.Company;
import com.bahamon.companiescrud.service.CompanyService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/company/")
public class CompanyController
{
    private final CompanyService companyService;

    /*
     * @autor Fabian Bahamon
     * @Description Con este metodo busco implementar y probar el Scheduler.
    */
    @GetMapping( path = "Scheduling")
    public ResponseEntity<Company> SchedulingTask() {

        companyService.SchedulingTaskProcess();

        return ResponseEntity.noContent().build();
    }

    @GetMapping( path = "getCompany/{name}")
    public ResponseEntity<Company> getCompany( @PathVariable String name ) {
        System.out.println("----> LLEGO AL COMPANIES");
        Company company = companyService.readByName( name );

        return new ResponseEntity<>( company, HttpStatus.OK );
    }

    @PostMapping( path = "createCompany" )
    public ResponseEntity<Company> postCompany( @RequestBody Company company ) {
        Company companyCreated = companyService.createCompany( company );

        return ResponseEntity.status( HttpStatus.CREATED ).body( companyCreated );
    }

    @PutMapping( path = "updateCompany/{name}")
    public ResponseEntity<Company> putCompany( @RequestBody Company company, @PathVariable String name ) {
        Company companyUpdated = companyService.updateCompany( company, name );

        return ResponseEntity.status( HttpStatus.OK ).body( companyUpdated );
    }

    @DeleteMapping( path = "delete/{name}" )
    public ResponseEntity<?> deleteCompany( @PathVariable String name ) {
        companyService.deleteCompany( name );

        return ResponseEntity.noContent().build();
    }
}
