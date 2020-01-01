package com.felixso_infotech.graph.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felixso_infotech.domain.graph.RegisteredUser;
import com.felixso_infotech.service.graph.RegisteredUserGraphService;





/**
 * REST controller for managing {@link com.felixso_infotech.domain.RegisteredUser}.
 */
@RestController
@RequestMapping("/api/graph")
public class RegisteredUserGraphResource {
	
	private final Logger log = LoggerFactory.getLogger(RegisteredUserGraphResource.class);

    private RegisteredUserGraphService registeredUserGraphService;

    public RegisteredUserGraphResource(RegisteredUserGraphService registeredUserGraphService) {
        this.registeredUserGraphService = registeredUserGraphService;
    }
    
    /**
	 * GET /createWellWisher/registeredUser/{userId}/{wellWisherId} create well
	 * wisher relationship
	 *
	 * @param userId       the registered user id
	 * @param wellWisherId the well wisher id
	 */
	@PostMapping("/createWellWisher/registeredUser/{userId}/{wellWisherId}")
	public RegisteredUser createWellWisher(@PathVariable String userId, @PathVariable String wellWisherId) {
		
		log.debug("request to create welwisher:" + userId + " wellWisherId:" + wellWisherId);
		return registeredUserGraphService.createWellWisher(userId, wellWisherId);
	}

	/**
	 * GET /registeredUser/wellWisher/{userId} : get all well wishers by user id
	 *
	 * @param userId the registered user id
	 */
	@GetMapping("/registeredUser/wellWisher/{userId}")
	public List<RegisteredUser> findAllWellWishersByUserId(@PathVariable String userId) {
		return registeredUserGraphService.findAllWellWishersByUserId(userId);
	}
	
	/**
	 * GET /registeredUserMutaulWellWisher/{userId1}/{userId2} : get mutual well
	 * wishers of two registered users by userId1,userId2
	 *
	 * @param userId1 the registered user user id
	 * @param userId2 the registered user user id
	 */
	@GetMapping("/registeredUserMutaulWellWisher/{userId1}/{userId2}")
	public List<RegisteredUser> findMutualFriends(@PathVariable String userId1, @PathVariable String userId2) {
		return registeredUserGraphService.findMutualWellWishers(userId1, userId2);
	}

}
