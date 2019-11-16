package com.codeshop.elasticsearch.mapper;

import com.codeshop.elasticsearch.model.ESDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSearchRepository extends ElasticsearchRepository<ESDocument, String> {

}
