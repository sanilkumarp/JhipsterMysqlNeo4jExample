package com.felixso_infotech.repository.graph;


import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felixso_infotech.domain.graph.RegisteredUser;


@Repository
public interface RegisteredUserGraphRepository extends Neo4jRepository<RegisteredUser, String> {
	
	/**
	 * Create a well wisher relationship.
	 *
	 * @param userId       the registered user id
	 * @param wellWisherId the registered user id
	 * @return the well wisher registered user
	 */
	@Query("match (u:RegisteredUser{userId:" + "{userId}" + "}),(w:RegisteredUser{userId:" + "{friendId}"
			+ "}) create (u)-[:WELLWISHER_OF]->(w) return u,w;")
	RegisteredUser createWellWisher(@Param("userId") String userId, @Param("friendId") String friendId);
	
	
	/**
	 * Find all well wishers by registered user id
	 *
	 * @param userId the registered user id
	 * @return list of well wisher registered users
	 */
	@Query("MATCH (u:RegisteredUser{userId:" + " {userId} "
			+ "}),(u)-[r:WELLWISHER_OF]-(wellwishers) RETURN wellwishers;")
	List<RegisteredUser> findAllWellWishersByUserId(@Param("userId") String userId);
	
	
	// To find mutaul well wishers of two registered user
	@Query("MATCH (u1:RegisteredUser {userId:" + "{userId1}"
				+ "})-[:WELLWISHER_OF]-(ww:RegisteredUser)-[:WELLWISHER_OF]-(u2:RegisteredUser {userId:" + "{userId2}"
				+ "}) RETURN  ww")
	List<RegisteredUser> findMutualFriends(@Param("userId1") String userId1, @Param("userId2") String userId2);

}
