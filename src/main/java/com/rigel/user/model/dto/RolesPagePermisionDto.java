package com.rigel.user.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolesPagePermisionDto {

	private Long id;

    
 // ===== BASIC PAGE ACCESS =====
 	@Column(name = "canAll")
 	private boolean canAll;

 	@Column(name = "can_view")
 	private boolean canView;

 	@Column(name = "can_create")
 	private boolean canCreate;

 	@Column(name = "can_edit")
 	private boolean canEdit;

 	@Column(name = "can_delete")
 	private boolean canDelete;
 	
 	private PagesDto pages;
    private RolesDto roles;
}
