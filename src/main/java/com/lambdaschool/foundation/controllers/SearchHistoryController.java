package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.SearchHistory;
import com.lambdaschool.foundation.services.SearchHistoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/history")
public class SearchHistoryController
{
    @Autowired
    SearchHistoryServices historyServices;

    @GetMapping(path = "/myhistory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMySearchHistory()
    {
        var history = historyServices.findUserHistory();
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @PostMapping(path = "/myhistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewSearchHistory(@RequestBody SearchHistory history)
    {
        historyServices.save(history);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable long id)
    {
        historyServices.delete(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/myhistory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMyHistory()
    {
        historyServices.deleteAllUsersHistory();
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
