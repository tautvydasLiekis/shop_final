package com.wild.backend.repository;

import com.wild.backend.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles LEFT JOIN FETCH u.products WHERE u.username = :username")
    Optional<User> findWithRolesByUsername(@Param("username") String username);

    Boolean existsByUsername(String username);

    User findByUsername(String username);

    User findUserById(long id);
}
