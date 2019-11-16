package com.codeshop.elasticsearch;

import com.codeshop.elasticsearch.model.ESDocument;
import com.codeshop.elasticsearch.service.DocumentSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTests {
    @Autowired
    private DocumentSearchService documentSearchService;

    @Test
    public void save() {
        documentSearchService.save(new ESDocument(UUID.randomUUID().toString(),"name1","1"));
    }
    @Test
    public void getById(){
        documentSearchService.getById("98c717e2-0e17-4887-86f6-e9cd347f97f7");
    }
    @Test
    public void getByName(){
        documentSearchService.getByName("name1","1");
    }
    @Test
    public void delete(){
        documentSearchService.delete("98c717e2-0e17-4887-86f6-e9cd347f97f7");
    }
}
