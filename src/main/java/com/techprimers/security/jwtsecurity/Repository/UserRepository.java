package com.techprimers.security.jwtsecurity.Repository;

import com.techprimers.security.jwtsecurity.model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JwtUser,Long> {
    Optional<JwtUser> findJwtUserByUserName(String username);
}
