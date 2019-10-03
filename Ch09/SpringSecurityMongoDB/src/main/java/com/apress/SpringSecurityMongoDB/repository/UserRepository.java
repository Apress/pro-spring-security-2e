package com.apress.SpringSecurityMongoDB.repository;

import com.apress.SpringSecurityMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email);
    
}
