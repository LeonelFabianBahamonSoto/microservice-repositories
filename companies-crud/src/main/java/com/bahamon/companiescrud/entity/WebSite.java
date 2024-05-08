package com.bahamon.companiescrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="web_site")
@Data
public class WebSite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private long id;

    @Size( min= 1, max=255, message = "El nombre del sitio web debe tener entre 1 a 255 caracteres")
    @NotNull( message = "El nombre no puede ser nulo" )
    @NotEmpty( message = "El nombre no puede ser vacio" )
    private String name;

    @Column( columnDefinition = "category" )
    @Enumerated( value = EnumType.STRING )
    private Category category;

    @Size( min= 1, max=255, message = "El nombre del sitio web debe tener entre 1 a 255 caracteres")
    @NotNull( message = "La descripcion no puede ser nula" )
    @NotEmpty( message = "La descripcion no puede ser vacia" )
    private String description;
}
