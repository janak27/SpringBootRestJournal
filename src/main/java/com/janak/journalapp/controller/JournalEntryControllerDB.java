package com.janak.journalapp.controller;

import com.janak.journalapp.entity.JournalEntry;
import com.janak.journalapp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerDB {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){

        return journalEntryService.getAll();
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;
    }
    @GetMapping("id/{givenID}")
    public JournalEntry getEntry(@PathVariable ObjectId givenID){
        return journalEntryService.findById(givenID).orElse(null);
    }

    @DeleteMapping("id/{givenID}")
    public boolean deleteEntry(@PathVariable ObjectId givenID){
        journalEntryService.deletebyid(givenID);
        return true;
    }

    @PutMapping("id/{givenID}")
    public JournalEntry updateEntry(@PathVariable ObjectId givenID,@RequestBody JournalEntry newentry){
        JournalEntry old = journalEntryService.findById(givenID).orElse(null);
        if(old != null){
            old.setTitle(newentry.getTitle() != null && newentry.getTitle().equals(" ") ? newentry.getTitle() : old.getTitle());
            old.setContent(newentry.getContent() != null && newentry.getContent().equals("") ? newentry.getContent() : old.getContent());
        }

        journalEntryService.saveEntry(old);
        return old;
    }
}
