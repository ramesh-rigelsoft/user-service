package com.rigel.user.daoimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rigel.user.dao.IUserDao;
import com.rigel.user.model.User;
import com.rigel.user.model.UserOtp;
import com.rigel.user.model.dto.SearchCriteria;

@Repository
@Transactional
public class UserDaoimpl implements IUserDao {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public User saveUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User findUserByEmailId(String username,int existingId) {
	    try {
	    	if(existingId==0) {
	          return entityManager
	                .createQuery(
	                        "SELECT u FROM User u WHERE u.email_id = :username OR u.mobile_no = :username",
	                        User.class)
	                .setParameter("username", username)
	                .getSingleResult();
	    	}else {
	    	  return entityManager
	    		 .createQuery(
	                        "SELECT u FROM User u WHERE u.id !=userId AND (u.email_id = :username OR u.mobile_no = :username)",
	                        User.class)
	                .setParameter("userId", existingId)
	                .setParameter("username", username)
	                .getSingleResult();
	    	}
	    	

	    } catch (NoResultException e) {
//	    	e.printStackTrace();
	        return null;
	    } catch (Exception e) {
//	        e.printStackTrace(); // optional logging
	        return null;
	    }
	}

	@Override
	public UserOtp saveUserOTP(UserOtp otp) {
		return entityManager.merge(otp);
	}

	@Override
	public UserOtp findUserOtpByMobileNo(String mobileNo) {
	    try {
	        return entityManager
	                .createQuery(
	                        "SELECT u FROM UserOtp u WHERE u.mobile_no = :mobileNo ORDER BY u.created_at DESC",
	                        UserOtp.class)
	                .setParameter("mobileNo", mobileNo)
	                .setMaxResults(1)
	                .getSingleResult();

	    } catch (NoResultException e) {
	        return null;
	    } catch (Exception e) {
	        e.printStackTrace(); // optional logging
	        return null;
	    }
	}

	@Override
	public List<User> findUsers(SearchCriteria searcCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
