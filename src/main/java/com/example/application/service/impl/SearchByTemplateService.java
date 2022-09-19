package com.example.application.service.impl;

import com.example.application.model.Lector;
import com.example.application.service.LectorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SearchByTemplateService {
    private final LectorService lectorService;

    public SearchByTemplateService(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    public List<Lector> search(String regex) {
        return lectorService.getLectorsByNameLike("%" + regex + "%");
    }
}
