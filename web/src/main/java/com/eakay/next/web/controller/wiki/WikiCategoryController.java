package com.eakay.next.web.controller.wiki;

import com.eakay.next.biz.service.wiki.WikiCategoryService;
import com.eakay.next.client.domain.WikiCategoryDO;
import com.eakay.next.client.formbean.wiki.WikiCategory4AddFormBean;
import com.eakay.next.client.formbean.wiki.WikiCategory4ListFormBean;
import com.eakay.next.client.formbean.wiki.WikiCategory4UpdateFormBean;
import com.eakay.next.client.util.BeanCopierUtil;
import com.eakay.next.client.util.response.ResponseObject;
import com.eakay.next.client.util.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wikiCategory")
public class WikiCategoryController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WikiCategoryService wikiCategoryService;


    @PostMapping("/add")
    public ResponseObject add(@Validated WikiCategory4AddFormBean formBean) {

        WikiCategoryDO wikiCategory = new WikiCategoryDO();
        BeanCopierUtil.copy(formBean, wikiCategory);

        wikiCategoryService.add(wikiCategory);

        return ResponseUtil.getOK();
    }


    @PostMapping("/update")
    public ResponseObject update(@Validated WikiCategory4UpdateFormBean formBean) {

        WikiCategoryDO wikiCategory = new WikiCategoryDO();
        BeanCopierUtil.copy(formBean, wikiCategory);

        wikiCategoryService.update(wikiCategory);

        return ResponseUtil.getOK();
    }


    @PostMapping("/delete")
    public ResponseObject delete(@RequestParam Integer id) {

        wikiCategoryService.delete(id);

        return ResponseUtil.getOK();
    }


    @PostMapping("/changeStatus")
    public ResponseObject changeStatus(@RequestParam Integer id, @RequestParam Integer state) {

        wikiCategoryService.changeStatus(id, state);

        return ResponseUtil.getOK();
    }


    @PostMapping("/list")
    public ResponseObject<List<WikiCategoryDO>> list(@Validated WikiCategory4ListFormBean formBean) {

        List<WikiCategoryDO> list = wikiCategoryService.list(formBean);

        return ResponseUtil.getOK(list);
    }


    @PostMapping("/info")
    public ResponseObject<WikiCategoryDO> info(@RequestParam Integer id) {

        WikiCategoryDO info = wikiCategoryService.selectById(id);

        return ResponseUtil.getOK(info);
    }


}
