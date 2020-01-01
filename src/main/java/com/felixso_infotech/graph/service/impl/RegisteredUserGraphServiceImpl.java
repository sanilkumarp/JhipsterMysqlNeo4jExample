package com.felixso_infotech.graph.service.impl;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixso_infotech.domain.graph.RegisteredUser;
import com.felixso_infotech.repository.graph.RegisteredUserGraphRepository;
import com.felixso_infotech.service.graph.RegisteredUserGraphService;

@Service
@Transactional("graphTransactionManager")
public class RegisteredUserGraphServiceImpl implements RegisteredUserGraphService {

	private final Logger log = LoggerFactory.getLogger(RegisteredUserGraphServiceImpl.class);
	
	private RegisteredUserGraphRepository registeredUserGraphRepository;
	
	public RegisteredUserGraphServiceImpl(RegisteredUserGraphRepository registeredUserGraphRepository)
	{
		this.registeredUserGraphRepository = registeredUserGraphRepository;
	}
	
	/**
	 * Create a well wisher relationship.
	 *
	 * @param userId       the registered user id
	 * @param wellWisherId the registered user id
	 * @return the well wisher registered user
	 */
	@Override
	public RegisteredUser createWellWisher(String userId, String friendId) {
		
		log.debug("request to create welwisher:" + userId + " wellWisherId:" + friendId);

		return registeredUserGraphRepository.createWellWisher(userId, friendId);
	}

	/**
	 * Find all well wishers by registered user id
	 *
	 * @param userId the registered user id
	 * @return list of well wisher registered users
	 */
	@Override
	public List<RegisteredUser> findAllWellWishersByUserId(String userId) {
		
		log.debug("getall welwishers:" + userId );
		return registeredUserGraphRepository.findAllWellWishersByUserId(userId);
	}
	
	/**
	 * Find mutual well wishers
	 *
	 * @param userId1 the registered user id
	 * @param userId2 the registered user id
	 * @return list of well wisher registered users
	 */
	@Override
	public List<RegisteredUser> findMutualWellWishers(String userId1, String userId2) {
		log.debug("mutaul friends:" + userId1 + " friendof" + userId2);
		return registeredUserGraphRepository.findMutualFriends(userId1, userId2);
	}
}
