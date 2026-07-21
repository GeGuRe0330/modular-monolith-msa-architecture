package com.modularmonolithmsaarchitecture.user.infrastructure;

import com.modularmonolithmsaarchitecture.user.domain.User;
import com.modularmonolithmsaarchitecture.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserRepository jpaRepository;

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }

    @Override
    public boolean existByEmail(String email) {
        return jpaRepository.existByEmail(email);
    }
}
