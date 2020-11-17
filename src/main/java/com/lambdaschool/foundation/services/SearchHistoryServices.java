package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.SearchHistory;

import java.util.List;

public interface SearchHistoryServices {
    List<SearchHistory> findAll();
    List<SearchHistory> findUserHistory();
    SearchHistory findById(long id);

    SearchHistory save(SearchHistory searchHistory);

    void deleteAllUsersHistory();
    void delete(long id);
    void delete(SearchHistory searchHistory);
}
