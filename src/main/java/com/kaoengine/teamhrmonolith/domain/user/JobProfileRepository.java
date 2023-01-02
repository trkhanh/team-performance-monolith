package com.kaoengine.teamhrmonolith.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobProfileRepository extends MongoRepository<JobProfile, String> {
}