package com.rigel.user.service;

import java.util.List;

import com.rigel.user.model.BuyerInfo;
import com.rigel.user.model.RolesPagePermision;
import com.rigel.user.model.dto.SalesRequest;
import com.rigel.user.model.dto.SalesResponse;
import com.rigel.user.model.dto.SearchCriteria;

public interface IRolesManagementService {

	public RolesPagePermision saveRolesPagePermission(RolesPagePermision polesPagePermision);

	public List<RolesPagePermision> searchRolesPagePermision(SearchCriteria criteria);

}
