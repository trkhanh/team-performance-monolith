package com.kaoengine.teamhrmonolith.domain.user;

import io.micrometer.common.util.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Auditable;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.Optional;

public class JobProfile implements Auditable<User, String, LocalDateTime> {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @DBRef
    private User createdBy;
    @DBRef
    private Optional<User> modifiedBy;
    private LocalDateTime createdDate;
    private Optional<LocalDateTime> modifiedDate;

    public JobProfile(String id) {
        super();
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return StringUtils.isBlank(this.id);
    }

    @Override
    public Optional<User> getCreatedBy() {
        return Optional.ofNullable(this.createdBy);
    }

    @Override
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.ofNullable(this.createdDate);
    }

    /**
     * Sets the creation date of the entity.
     *
     * @param creationDate the creation date to set
     */
    @Override
    public void setCreatedDate(LocalDateTime creationDate) {
        this.createdDate = creationDate;
    }

    @Override
    public Optional<User> getLastModifiedBy() {
        return this.modifiedBy;
    }

    @Override
    public void setLastModifiedBy(User lastModifiedBy) {
        this.modifiedBy = Optional.of(lastModifiedBy);
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return this.modifiedDate;
    }

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedDate the date of the last modification to set
     */
    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.modifiedDate = Optional.of(lastModifiedDate);
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
}