package com.rigel.user.dao;

import java.util.List;

import com.rigel.user.model.BuyerInfo;
import com.rigel.user.model.Pages;
import com.rigel.user.model.RolesPagePermision;
import com.rigel.user.model.dto.MenuDto;
import com.rigel.user.model.dto.SearchCriteria;

public interface IRolesManagementDao {

	public RolesPagePermision saveRolesPagePermission(RolesPagePermision polesPagePermision);

	public RolesPagePermision findRolesPagePermissionById(Long id);

	public List<RolesPagePermision> searchRolesPagePermision(SearchCriteria criteria);

	public List<Pages> fetchPagesList(SearchCriteria criteria);

	public List<MenuDto> getMenus(Long roleId, Integer ownerId);
	
	public Long getRoleIdByRole(String role);
}
