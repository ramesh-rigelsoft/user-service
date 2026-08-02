package com.rigel.user.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rigel.user.dao.ISubscriptionPlanDao;
import com.rigel.user.model.UserSubscription;

import jakarta.persistence.EntityManager;

public class SubscriptionPlanDaoImpl implements ISubscriptionPlanDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public UserSubscription saveUserSubscription(UserSubscription userSubscription) {
		return entityManager.merge(userSubscription);
	}

}
