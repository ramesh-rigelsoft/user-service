package com.rigel.user.service;

import com.rigel.user.model.SubscriptionPlan;
import com.rigel.user.model.UserSubscription;

public interface ISubscriptionPlanService {
	
  public SubscriptionPlan saveSubscriptionPlan();
  
  public UserSubscription getSubscriptionPlanByOwnerId(Integer ownerId);
  
  public UserSubscription saveUserSubscriptionPlan(UserSubscription userSubscriptionPlan);

}
