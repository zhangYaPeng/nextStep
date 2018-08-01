package com.eakay.next.biz.service.wiki;

import com.eakay.next.client.formbean.wiki.WikiCategory4ListFormBean;
import com.eakay.next.client.domain.WikiCategoryDO;

import java.util.List;

public interface WikiCategoryService {

    List<WikiCategoryDO> list(WikiCategory4ListFormBean formBean);

    WikiCategoryDO selectById(Integer wikiCategoryId);

    void changeStatus(Integer wikiCategoryId, Integer state);

    void delete(Integer wikiCategoryId);

    void update(WikiCategoryDO wikiCategory);

    void add(WikiCategoryDO wikiCategory);

    void addWiki(int flag);

}
