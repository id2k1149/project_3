package org.id2k1149.project_3.repository;

import org.id2k1149.project_3.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository
        extends JpaRepository<AppUser, Long> {

//    @Query("SELECT u FROM AppUser u WHERE u.email = ?1")
    Optional<AppUser> findUserByEmail(String email);
}
