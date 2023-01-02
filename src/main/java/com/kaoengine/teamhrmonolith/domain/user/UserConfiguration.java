package com.kaoengine.teamhrmonolith.domain.user;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
@Setter
public class UserConfiguration {
    @NestedConfigurationProperty
    private NotificationConfiguration notification;

    public NotificationConfiguration getNotification() { return notification; }
}
