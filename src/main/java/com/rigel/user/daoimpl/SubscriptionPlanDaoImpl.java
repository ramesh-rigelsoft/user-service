package com.rigel.user.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rigel.user.dao.ISubscriptionPlanDao;
import com.rigel.user.model.UserSubscription;
import com.rigel.user.model.UserSubscriptionLog;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SubscriptionPlanDaoImpl implements ISubscriptionPlanDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public UserSubscription saveUserSubscription(UserSubscription userSubscription) {
		return entityManager.merge(userSubscription);
	}
	
	@Override
	public void deactivateSubscription(Integer ownerId, String branchCode) {

	    entityManager.createQuery(
	            "UPDATE UserSubscription u " +
	            "SET u.status = false " +
	            "WHERE u.ownerId = :ownerId " +
	            "AND u.branchCode = :branchCode")
	        .setParameter("ownerId", ownerId)
	        .setParameter("branchCode", branchCode)
	        .executeUpdate();
	}

	@Override
	public UserSubscriptionLog saveUserSubscriptionLogPlan(UserSubscriptionLog userSubscriptionPlan) {
		return entityManager.merge(userSubscriptionPlan);
	}

}
