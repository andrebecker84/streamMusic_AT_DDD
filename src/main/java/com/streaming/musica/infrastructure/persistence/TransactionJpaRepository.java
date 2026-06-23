package com.streaming.musica.infrastructure.persistence;

import com.streaming.musica.domain.transaction.Transaction;
import com.streaming.musica.domain.transaction.TransactionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionJpaRepository extends JpaRepository<Transaction, UUID>, TransactionRepository {

    List<Transaction> findByAccountIdAndOccurredAtAfter(UUID accountId, LocalDateTime from);
}
