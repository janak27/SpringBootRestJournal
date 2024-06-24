package com.janak.journalapp.repo;

import com.janak.journalapp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {


}

//controller(endpoint) -> service(business logic) -> repo(db queries)