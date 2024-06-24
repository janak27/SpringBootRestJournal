package com.janak.journalapp.service;

import com.janak.journalapp.entity.JournalEntry;
import com.janak.journalapp.repo.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepoObj;

    public void saveEntry (JournalEntry entry){
        journalEntryRepoObj.save(entry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepoObj.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepoObj.findById(id);
    }

    public void deletebyid(ObjectId id){
        journalEntryRepoObj.deleteById(id);
    }
}
