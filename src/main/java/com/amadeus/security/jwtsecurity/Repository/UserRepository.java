package com.amadeus.security.jwtsecurity.Repository;

import com.amadeus.security.jwtsecurity.model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JwtUser,Long> {
    Optional<JwtUser> findJwtUserByUserName(String username);
}
