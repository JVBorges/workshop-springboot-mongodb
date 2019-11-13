package com.jvborges.wsmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jvborges.wsmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
