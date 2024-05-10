package com.bahamon.reportms.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Company {
    private long id;

    private String name;

    private String founder;

    private String logo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    private List<WebSite> webSites;
}
