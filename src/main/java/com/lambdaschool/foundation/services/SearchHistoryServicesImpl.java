package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.SearchHistory;
import com.lambdaschool.foundation.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServicesImpl implements SearchHistoryServices {

    @Autowired
    SearchHistoryRepository historyRepository;

    @Override
    public List<SearchHistory> findAll() {
        return null;
    }

    @Override
    public List<SearchHistory> findUserHistory() {
        return null;
    }

    @Override
    public SearchHistory findById(long id) {
        return null;
    }

    @Override
    public SearchHistory save(SearchHistory searchHistory) {
        return null;
    }

    @Override
    public SearchHistory update(SearchHistory searchHistory) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(SearchHistory searchHistory) {

    }
}
