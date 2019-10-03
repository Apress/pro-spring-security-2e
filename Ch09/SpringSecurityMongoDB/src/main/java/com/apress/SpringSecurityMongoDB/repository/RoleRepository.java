package com.apress.SpringSecurityMongoDB.repository;

import com.apress.SpringSecurityMongoDB.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
}
