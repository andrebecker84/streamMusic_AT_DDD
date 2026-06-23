package com.streaming.musica.infrastructure.persistence;

import com.streaming.musica.domain.subscription.Subscription;
import com.streaming.musica.domain.subscription.SubscriptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubscriptionJpaRepository extends JpaRepository<Subscription, UUID>, SubscriptionRepository {

    @Query("SELECT s FROM Subscription s WHERE s.accountId = :accountId AND s.active = true")
    Optional<Subscription> findActiveByAccountId(@Param("accountId") UUID accountId);

    @Query("SELECT COUNT(s) > 0 FROM Subscription s WHERE s.accountId = :accountId AND s.active = true")
    boolean hasActiveSubscription(@Param("accountId") UUID accountId);
}
