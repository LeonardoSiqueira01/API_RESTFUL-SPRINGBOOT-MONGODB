package com.leonardoSiqueira.WorkshopMongoDB.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonardoSiqueira.WorkshopMongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title': { $regex: ?0, $options: 'i'}}") // ?0 = 0 porque é o primeiro parametro, i= para o case
														// insensitive
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoringCase(String text); // metodo container - querry methods

}
