package com.bahamon.companiescrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size( min= 1, max=255, message = "El nombre del nombre web debe tener entre 1 a 255 caracteres")
    @NotNull( message = "El nombre no puede ser nulo" )
    @NotEmpty( message = "El nombre no puede ser vacio" )
    private String name;

    @Size( min= 1, max=255, message = "El nombre del fundador web debe tener entre 1 a 255 caracteres")
    @NotNull( message = "El nombre del fundador no puede ser nulo" )
    @NotEmpty( message = "El nombre del fundador no puede ser vacio" )
    private String founder;

    @Size( min= 1, max=255, message = "El nombre del logo web debe tener entre 1 a 255 caracteres")
    @NotNull( message = "El nombre del logo no puede ser nulo" )
    @NotEmpty( message = "El nombre del logo no puede ser vacio" )
    private String logo;

    @Past(message = "La fecha de fundación debe ser una fecha pasada")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    @OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE } )
    @JoinColumn( name = "id_company", referencedColumnName = "id" )
    private List<WebSite> webSites;
}
