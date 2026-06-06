package com.rigel.user.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rigel.user.dao.IBuyerDao;
import com.rigel.user.dao.IItemsDao;
import com.rigel.user.dao.IRolesManagementDao;
import com.rigel.user.model.BuyerInfo;
import com.rigel.user.model.Items;
import com.rigel.user.model.Pages;
import com.rigel.user.model.RolesPagePermision;
import com.rigel.user.model.dto.SearchCriteria;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RolesManagementDaoImpl implements IRolesManagementDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public RolesPagePermision saveRolesPagePermission(RolesPagePermision rolesPagePermision) {

		return entityManager.merge(rolesPagePermision);
	}

	@Override
	public List<RolesPagePermision> searchRolesPagePermision(SearchCriteria criteria) {

	    String jpql = """
	        SELECT rpp
	        FROM RolesPagePermision rpp
	        WHERE rpp.ownerId = :ownerId
	        AND rpp.roleId.id = :roleId
	        AND rpp.pageId.id = :pageId
	    """;

	    return entityManager.createQuery(jpql, RolesPagePermision.class)
	            .setParameter("ownerId", criteria.getUserId())
	            .setParameter("roleId", criteria.getRoleId())
	            .setParameter("pageId", criteria.getPageId())
	            .getResultList();
	}

	@Override
	public List<Pages> fetchPagesList(SearchCriteria criteria) {

		String jpql = """
				SELECT p
				FROM Pages p
				WHERE p.status = true
				ORDER BY p.pageName
				""";

		return entityManager.createQuery(jpql, Pages.class).getResultList();
	}

	@Override
	public RolesPagePermision findRolesPagePermissionById(Long id) {

	    String jpql = "SELECT r FROM RolesPagePermision r WHERE r.id = :id";

	    return entityManager.createQuery(jpql, RolesPagePermision.class)
	            .setParameter("id", Long.valueOf(id))
	            .getSingleResult();
	}

}