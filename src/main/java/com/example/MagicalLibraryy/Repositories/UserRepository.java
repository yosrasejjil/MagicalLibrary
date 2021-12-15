package com.example.MagicalLibraryy.Repositories;

import com.example.MagicalLibraryy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String Email);
}
