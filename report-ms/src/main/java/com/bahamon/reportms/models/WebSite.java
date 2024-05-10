package com.bahamon.reportms.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class WebSite implements Serializable {
    private long id;

    private String name;

    private Category category;

    private String description;
}
