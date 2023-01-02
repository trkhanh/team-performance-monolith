package com.kaoengine.teamhrmonolith.domain.user.notification;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@SuppressWarnings("unused")
public interface UserNotificationRepository extends MongoRepository<UserNotification, String> {
    @Query("{active: true}")
    List<UserNotification> findAll();

    @Query("{user.$id: {$eq: ?0}, read: false, active: true}")
    List<UserNotification> findUnread(final String userName);

    @Query(count = true, value = "{user.$id: {$eq: ?0}, read: false, active: true}")
    int findUnreadCount(final String userName);

    @Query("{user.$id: {$eq: ?0}, active: true}")
    List<UserNotification> findNotifications(final String userName);

    @Query("{user.$id: {$eq: ?0}, active: true}")
    List<UserNotification> findNotifications(final String userName, final int limit, final Sort sort);
}
