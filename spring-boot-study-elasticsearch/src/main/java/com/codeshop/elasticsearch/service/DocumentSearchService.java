package com.codeshop.elasticsearch.service;

import com.codeshop.elasticsearch.model.ESDocument;

import java.io.IOException;

public interface DocumentSearchService {
    void save(ESDocument esDocument) throws IOException;
    void delete(String id);
    void getById(String id);
    void getByName(String name,String projectId);
}
