package com.driveme.driveme.arq.db;

import com.driveme.driveme.arq.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, String> {
}
