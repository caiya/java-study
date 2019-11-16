package com.codeshop.elasticsearch.service.impl;

import com.codeshop.elasticsearch.mapper.DocumentSearchRepository;
import com.codeshop.elasticsearch.model.ESDocument;
import com.codeshop.elasticsearch.service.DocumentSearchService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentSearchServiceImpl implements DocumentSearchService {

    @Autowired
    private DocumentSearchRepository documentSearchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void save(ESDocument esDocument) {
        ESDocument document = documentSearchRepository.save(esDocument);
        System.out.println(document.toString());
    }

    @Override
    public void delete(String id) {
        documentSearchRepository.deleteById(id);
    }

    @Override
    public void getById(String id) {
        ESDocument document = documentSearchRepository.findById(id).orElse(new ESDocument());
        System.out.println(document.toString());
    }

    @Override
    public void getByName(String name, String projectId) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(new MatchQueryBuilder("name", name))
                .withQuery(new MatchQueryBuilder("projectId", projectId))
                .build();
        List<ESDocument> esDocuments = elasticsearchTemplate.queryForList(searchQuery, ESDocument.class);
        esDocuments.forEach(e -> System.out.println(e.toString()));
    }
}
