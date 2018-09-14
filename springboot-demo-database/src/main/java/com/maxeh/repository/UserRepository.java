package com.maxeh.repository;

import com.maxeh.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("FROM User U WHERE LOWER(U.email) LIKE LOWER(concat('%', ?1))")
    Iterable<User> findByEmailDomain(String matchPhrase);

}