package com.rigel.user.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.Builder.Default;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rigel.user.model.User;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfficeBranchDto  {
	
    private String id;

    private String branchCode;   // Travel, Food, Salary etc.

    @NotNull(message = "Branch Name is required")
    private String branchName;  // Personal / Business

    @Column(length = 300)
    @NotNull(message = "Branch Name is required")
    private String address;
   
    private int ownerId; // reference to the user/owner
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private boolean status;
    private String additionalDetails;
    
    // company info
    @NotNull(message = "ShopType is required")
    private String shopType;

	private String gstNumber;
	private String panNumber;
	private String cinNumber;

    @NotNull(message = "City Name is required")
	private String city;
    
    @NotNull(message = "State Name is required")
	private String state;
    
    @NotNull(message = "Pincode is required")
	private String pincode;
	
	private MultipartFile logo;
 
}
