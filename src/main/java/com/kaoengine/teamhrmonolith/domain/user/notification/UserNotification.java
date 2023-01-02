package com.kaoengine.teamhrmonolith.domain.user.notification;

import com.kaoengine.teamhrmonolith.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Auditable;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
public class UserNotification implements Auditable<User, String, LocalDateTime> {
    private static final long serialVersionUID = 1L;

    public static final String FIELD_ID = "id";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_READ = "read";
    public static final String FIELD_USER = "user";
    public static final String FIELD_TIME = "time";
    public static final String FIELD_ACTION = "action";
    public static final String FIELD_ACTIVE = "active";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_CREATED_DATE = "createdDate";
    public static final String FIELD_LAST_MODIFIED_BY = "lastModifiedBy";
    public static final String FIELD_LAST_MODIFIED_DATE = "lastModifiedDate";

    public static UserNotification EMPTY() {
        return new UserNotification();
    }

    @Id
    private String id;
    private NotificationCategory category;
    private String content;
    private boolean read = false;

    @DBRef
    private User user;
    private LocalDateTime time;
    private String action;

    private boolean active = true;
    @DBRef
    private User createdBy;
    @DBRef
    private User modifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public UserNotification() {
    }

    public UserNotification(final User user) {
        this(user, null);
    }

    public UserNotification(final User user, final String content) {
        this.user = user;
        this.content = content;
        this.time = LocalDateTime.now();
    }


    /**
     * Returns the user who created this entity.
     *
     * @return the createdBy
     */
    @Override
    public Optional<User> getCreatedBy() {
        return Optional.empty();
    }

    /**
     * Sets the user who created this entity.
     *
     * @param createdBy the creating entity to set
     */
    @Override
    public void setCreatedBy(User createdBy) {

    }

    /**
     * Returns the creation date of the entity.
     *
     * @return the createdDate
     */
    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.empty();
    }

    /**
     * Sets the creation date of the entity.
     *
     * @param creationDate the creation date to set
     */
    @Override
    public void setCreatedDate(LocalDateTime creationDate) {

    }

    /**
     * Returns the user who modified the entity lastly.
     *
     * @return the lastModifiedBy
     */
    @Override
    public Optional<User> getLastModifiedBy() {
        return Optional.empty();
    }

    /**
     * Sets the user who modified the entity lastly.
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    @Override
    public void setLastModifiedBy(User lastModifiedBy) {

    }

    /**
     * Returns the date of the last modification.
     *
     * @return the lastModifiedDate
     */
    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.empty();
    }

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedDate the date of the last modification to set
     */
    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {

    }

    /**
     * Returns the id of the entity.
     *
     * @return the id. Can be {@literal null}.
     */
    @Override
    public String getId() {
        return null;
    }

    /**
     * Returns if the {@code Persistable} is new or was persisted already.
     *
     * @return if {@literal true} the object is new.
     */
    @Override
    public boolean isNew() {
        return false;
    }

    public void auditChangedBy(final User user) {
        if (isNew()) {
            setCreatedBy(user);
            setCreatedDate(LocalDateTime.now());
        } else {
            setLastModifiedBy(user);
            setLastModifiedDate(LocalDateTime.now());
        }
    }

    /**
     * Determines whether the notification is address to the user
     *
     * @param user The user to test
     * @return Whether the user is addressed by the notification
     */
    public boolean addressedTo(
            final User user) {

        return this.user != null && this.user.equals(user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserNotification other = (UserNotification) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return this.id;
    }

    public static UserNotification to(final User user) {
        return new UserNotification(user);
    }

    public UserNotification at(final LocalDateTime time) {
        this.setTime(time);
        return this;
    }

    public UserNotification category(final NotificationCategory category) {
        this.setCategory(category);
        return this;
    }

    public UserNotification content(final String message) {
        this.setContent(message);
        return this;
    }

    public UserNotification action(final String action) {
        this.setAction(action);
        return this;
    }

    public UserNotification from(final User user) {
        if (user != null) {
            this.setCreatedBy(user);
            this.setCreatedDate(LocalDateTime.now());
        }
        return this;
    }
}
