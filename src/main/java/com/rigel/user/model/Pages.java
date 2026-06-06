package com.rigel.user.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pages")
@Getter
@Setter
public class Pages implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "page_url", nullable = false)
    private String roleUrl;
    
    @Column(name = "page_name", nullable = false)
    private String pageName;
    
    private String description;
    
    private boolean status;
    
	@OneToMany(mappedBy = "pageId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "pageId")
	private Set<RolesPagePermision> rolesPagePermision = new HashSet<>();

}
