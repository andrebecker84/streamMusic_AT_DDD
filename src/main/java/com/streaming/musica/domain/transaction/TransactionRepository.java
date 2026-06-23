package com.streaming.musica.domain.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(UUID id);

    List<Transaction> findByAccountIdAndOccurredAtAfter(UUID accountId, LocalDateTime from);
}
