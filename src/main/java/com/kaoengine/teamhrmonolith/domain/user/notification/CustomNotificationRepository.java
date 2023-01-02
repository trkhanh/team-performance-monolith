package com.kaoengine.teamhrmonolith.domain.user.notification;

import com.kaoengine.teamhrmonolith.domain.user.User;

import java.util.List;

public interface CustomNotificationRepository {
    List<NotificationSummary> getNotificationSummaries(final User user);
}