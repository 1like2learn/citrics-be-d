package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.SearchHistory;
import org.springframework.data.repository.CrudRepository;

public interface SearchHistoryRepository extends CrudRepository<SearchHistory, Long> {
}
