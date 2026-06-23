package com.streaming.musica.infrastructure.persistence;

import com.streaming.musica.domain.account.Account;
import com.streaming.musica.domain.account.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, UUID>, AccountRepository {

    Optional<Account> findByEmail(String email);

    boolean existsByEmail(String email);
}
