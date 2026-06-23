package com.streaming.musica.domain.subscription;

import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository {

    Subscription save(Subscription subscription);

    Optional<Subscription> findById(UUID id);

    Optional<Subscription> findActiveByAccountId(UUID accountId);

    boolean hasActiveSubscription(UUID accountId);
}
