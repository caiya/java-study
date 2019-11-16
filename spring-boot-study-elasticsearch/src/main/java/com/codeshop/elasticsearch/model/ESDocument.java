package com.codeshop.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "poms", type = "content")
public class ESDocument {
    @Id
    private String id;

    @Field(analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String name;

    private String projectId;

    public ESDocument(String id, String name, String projectId) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
    }

    public ESDocument() {
    }
}
