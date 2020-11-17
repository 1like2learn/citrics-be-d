package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.SearchHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchHistoryRepository extends CrudRepository<SearchHistory, Long>
{
    List<SearchHistory> findByUserUserid(long id);
}
