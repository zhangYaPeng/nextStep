package com.eakay.next.web.controller.wiki;

import com.eakay.next.biz.service.wiki.WikiCategoryService;
import com.eakay.next.client.util.response.ResponseObject;
import com.eakay.next.client.util.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wiki")
public class WikiController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WikiCategoryService wikiCategoryService;


    @PostMapping("/add")
    public ResponseObject add(Integer flag) {

        if ( flag == null ) {
            flag = 0;
        }

        wikiCategoryService.addWiki(flag);

        return ResponseUtil.getOK();
    }


}
