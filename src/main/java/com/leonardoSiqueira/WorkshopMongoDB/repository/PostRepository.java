package com.leonardoSiqueira.WorkshopMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leonardoSiqueira.WorkshopMongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
