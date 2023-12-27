package com.TubesRpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TubesRpl.vehicrent.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String keyword);

    List<User> findAllByHiddenFalse();

    Optional<User> findByHiddenFalseAndNik(Integer Nik);
}