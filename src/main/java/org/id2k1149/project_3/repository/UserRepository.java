package org.id2k1149.project_3.repository;

import org.id2k1149.project_3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.email = ?1")
    Optional<User> findUserByEmail(String email);
}
