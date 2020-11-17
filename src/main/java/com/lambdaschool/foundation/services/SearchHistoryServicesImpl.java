package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.SearchHistory;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchHistoryServicesImpl implements SearchHistoryServices
{

    @Autowired
    SearchHistoryRepository historyRepository;

    @Autowired
    HelperFunctions helperFunctions;

    @Autowired
    UserService userService;

    @Override
    public List<SearchHistory> findAll()
    {
        List<SearchHistory> history = new ArrayList<>();
        historyRepository.findAll().iterator().forEachRemaining(history::add);
        return history;
    }

    @Override
    public List<SearchHistory> findUserHistory()
    {
        String username = helperFunctions.getCurrentUsername();
        if(username == null || username.equalsIgnoreCase("anonymousUser"))
        {
            throw new EntityNotFoundException(String.format("User is not authenticated"));
        }
        User currentUser = userService.findByName(username);
        var history = historyRepository.findByUserUserid(currentUser.getUserid());
        return history;
    }

    @Override
    public SearchHistory findById(long id)
    {
        return historyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Id %d not found", id)));
    }

    @Transactional
    @Override
    public SearchHistory save(SearchHistory searchHistory)
    {
        var histToSave = new SearchHistory();

//        if(searchHistory.getAvgTempMax() != null)
        histToSave.setAvgTempMax(searchHistory.getAvgTempMax());
        histToSave.setAvgTempMin(searchHistory.getAvgTempMin());
        histToSave.setPopulationMax(searchHistory.getPopulationMax());
        histToSave.setPopulationMin(searchHistory.getPopulationMin());
        histToSave.setRentMax(searchHistory.getRentMax());
        histToSave.setRentMin(searchHistory.getRentMin());
        histToSave.setSalaryMax(searchHistory.getSalaryMax());
        histToSave.setSalaryMin(searchHistory.getSalaryMin());
        histToSave.setWalkabilityMax(searchHistory.getWalkabilityMax());
        histToSave.setWalkabilityMin(searchHistory.getWalkabilityMin());

        var user = userService.findByName(helperFunctions.getCurrentUsername());
        if(user == null)
        {
            throw new EntityNotFoundException(String.format("User is either not in database or is not authenticated"));
        }
        histToSave.setUser(user);

        return historyRepository.save(histToSave);
    }

    @Override
    public void delete(long id)
    {
        var history = findById(id);
        if(helperFunctions.isAuthorizedToMakeChange(history.getUser().getUsername()))
        {
            historyRepository.deleteById(id);
        }
    }

    @Override
    public void delete(SearchHistory searchHistory)
    {
        var history = findById(searchHistory.getId());
        if(helperFunctions.isAuthorizedToMakeChange(searchHistory.getUser().getUsername()))
        {
            historyRepository.deleteById(history.getId());
        }
    }

    @Transactional
    @Override
    public void deleteAllUsersHistory()
    {
        var history = findUserHistory();
        for(var hist : history)
        {
            if(helperFunctions.isAuthorizedToMakeChange(hist.getUser().getUsername()))
            {
                delete(hist.getId());
            }
        }
    }
}
