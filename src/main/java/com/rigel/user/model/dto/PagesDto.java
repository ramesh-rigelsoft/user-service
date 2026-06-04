package com.rigel.user.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagesDto {
 private Long id;

    @Column(name = "page_url", nullable = false)
    private String roleUrl;
    
    @Column(name = "page_name", nullable = false)
    private String pageName;
    private String description;

}
