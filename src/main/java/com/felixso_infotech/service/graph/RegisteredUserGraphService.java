package com.felixso_infotech.service.graph;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.felixso_infotech.domain.graph.RegisteredUser;

public interface RegisteredUserGraphService {
	
	/**
	 * Create a well wisher relationship.
	 *
	 * @param userId       the registered user id
	 * @param wellWisherId the registered user id
	 * @return the well wisher registered user
	 */
	public RegisteredUser createWellWisher(String userId, String wellWisherId);
		
	/**
	 * Find all well wishers by registered user id
	 *
	 * @param userId the registered user id
	 * @return list of well wisher registered users
	 */
	public List<RegisteredUser> findAllWellWishersByUserId(@PathVariable String userId);
	

	/**
	 * Find mutual well wishers
	 *
	 * @param userId1 the registered user id
	 * @param userId2 the registered user id
	 * @return list of well wisher registered userss
	 */
	public List<RegisteredUser> findMutualWellWishers(String userId1, String userId2);

}
