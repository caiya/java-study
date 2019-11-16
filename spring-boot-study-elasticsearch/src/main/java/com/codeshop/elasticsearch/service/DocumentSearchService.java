package com.codeshop.elasticsearch.service;

import com.codeshop.elasticsearch.model.ESDocument;

public interface DocumentSearchService {
    void save(ESDocument esDocument);
    void delete(String id);
    void getById(String id);
    void getByName(String name,String projectId);
}
