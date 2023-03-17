package com.example.gagooda_project.mapper;

import com.example.gagooda_project.dto.PagingDto;
import com.example.gagooda_project.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProductMapper productMapper;

    @Test
    void pageForCategory() {
        PagingDto paging = new PagingDto();
        paging.setPage(1);
        paging.setRows(10);
        paging.setDirect("DESC");
        paging.setOrderField("mod_date");

        Map<String, Object> map = new HashMap<>();
        List<String> categoryIdList = new ArrayList<>();
        categoryIdList.add("51");
        categoryIdList.add("611");
        map.put("categoryIdList", categoryIdList);

        List<String> catDetList = new ArrayList<>();
        catDetList.add("p0");
        catDetList.add("p1");
        map.put("catDetList", catDetList);
//        map.put("searchWord", "'%가구%'");

        System.out.println(map.get("searchWord"));
        List<ProductDto> list = productMapper.pageForPaging(paging, map);
        for (ProductDto product : list) {
            log.info("product Dto: " + product);
        }
        log.info("list size: " + list.size());
    }

    @Test
    void mainListBySales() {
        System.out.println(productMapper.mainListBySales("GAGOODA"));
    }
}