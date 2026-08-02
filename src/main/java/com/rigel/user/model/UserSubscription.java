package com.rigel.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.Builder.Default;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.rigel.user.util.PagePermission;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_subscription")
public class UserSubscription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    private int ownerId;
    
    private boolean status;

    private String subscriptionName;
    
 
    private String subscriptionCode;   // SUB01

    private String subscriptionType;   // Monthaly,Qutarily,HelfYerily,Yerily

    private Double amountPerMonth;
    private int month;
    private Double gst;
    private double totalAmount;

    private String proof;

    private boolean isMultipleBranch;

    private int perBranchUser;
    
    private int branchCount;
    
    private boolean isMultipleUser;
    
    private int userCount; 
    
    private LocalDateTime createdAt;
   
    private String permissions;
    
    private boolean isReplaceItem;
    private boolean isReturnItem;
    private boolean isDownloadInvoice;
    private boolean isfilterInventory;
    private boolean isfilterSales;
    private boolean isDownloadExcelSales;
    private boolean isDownloadExcelEntryItem;
    private int SUKCount;

      
}
