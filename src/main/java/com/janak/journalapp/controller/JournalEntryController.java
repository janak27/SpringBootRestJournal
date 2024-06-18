package com.janak.journalapp.controller;

import com.janak.journalapp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private HashMap<Long,JournalEntry> journalEntryHashMap = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return  new ArrayList<>(journalEntryHashMap.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntryHashMap.put(entry.getId(),entry);
        if(entry == null){
            return false;
        }
        return true;
    }
    @GetMapping("id/{givenID}")
    public JournalEntry getEntry(@PathVariable Long givenID){
        return journalEntryHashMap.get(givenID);
    }

    @DeleteMapping("id/{givenID}")
    public JournalEntry deleteEntry(@PathVariable Long givenID){
        return journalEntryHashMap.remove(givenID);
    }

    @PutMapping("id/{givenID}")
    public JournalEntry updateEntry(@PathVariable Long givenID,@RequestBody JournalEntry entry){
        return journalEntryHashMap.put(givenID,entry);
    }
}
