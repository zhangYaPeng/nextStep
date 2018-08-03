package com.eakay.next.biz.service.wiki.impl;

import com.eakay.next.biz.job.MyJob;
import com.eakay.next.biz.service.wiki.WikiCategoryService;
import com.eakay.next.client.domain.WikiCategoryDO;
import com.eakay.next.client.domain.WikiDO;
import com.eakay.next.client.exceptions.CommonRuntimeException;
import com.eakay.next.client.formbean.wiki.WikiCategory4ListFormBean;
import com.eakay.next.repository.mybatis.master.WikiCategoryDOMasterMapper;
import com.eakay.next.repository.mybatis.master.WikiDOMasterMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class WikiCategoryServiceImpl implements WikiCategoryService {

    @Autowired
    private WikiCategoryDOMasterMapper wikiCategoryMasterMapper;

    @Autowired
    private WikiDOMasterMapper wikiDOMasterMapper;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public List<WikiCategoryDO> list(WikiCategory4ListFormBean formBean) {
        Example example = new Example(WikiCategoryDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0);

        List<WikiCategoryDO> list = wikiCategoryMasterMapper.selectByExample(example);
        return list;
    }

    @Override
    public WikiCategoryDO selectById(Integer wikiCategoryId) {
        return wikiCategoryMasterMapper.selectByPrimaryKey(wikiCategoryId);
    }

    @Override
    public void changeStatus(Integer wikiCategoryId, Integer state) {
        WikiCategoryDO wikiCategory = new WikiCategoryDO();
        wikiCategory.setId(wikiCategoryId);
        wikiCategory.setState(state);

        wikiCategoryMasterMapper.updateByPrimaryKeySelective(wikiCategory);
    }

    @Override
    public void delete(Integer wikiCategoryId) {
        WikiCategoryDO wikiCategory = new WikiCategoryDO();
        wikiCategory.setId(wikiCategoryId);
        wikiCategory.setDeleted(1);

        wikiCategoryMasterMapper.updateByPrimaryKeySelective(wikiCategory);
    }

    @Override
    public void update(WikiCategoryDO wikiCategory) {
        wikiCategoryMasterMapper.updateByPrimaryKeySelective(wikiCategory);
    }

    @Override
    public void add(WikiCategoryDO wikiCategory) {
        wikiCategoryMasterMapper.insertSelective(wikiCategory);
    }

    @Transactional(value = "masterTX", rollbackFor = Exception.class)
    @Override
    public void addWiki(int flag) {
        WikiCategoryDO wikiCategory = new WikiCategoryDO();
        wikiCategory.setCreateTime(new Date());
        wikiCategory.setUpdateTime(new Date());
        wikiCategory.setDeleted(0);
        wikiCategory.setMerchantId(456);
        wikiCategory.setSort(1);
        wikiCategory.setState(1);
        wikiCategory.setTitle("标题" + System.currentTimeMillis());
        wikiCategoryMasterMapper.insertSelective(wikiCategory);

        WikiDO wikiDO = new WikiDO();
        wikiDO.setCategoryId(wikiCategory.getId());
        wikiDO.setCreateTime(new Date());
        wikiDO.setUpdateTime(new Date());
        Random random = new Random();
        wikiDO.setStars(random.nextInt(500));
        wikiDO.setViews(random.nextInt(500));
        wikiDO.setTitle("文章标题" + new DateTime().toString("yyMMddHHmmssSSS"));
        wikiDOMasterMapper.insertSelective(wikiDO);

        if ( flag == 1 ) {
            throw new CommonRuntimeException("我出错了");
        }
    }

    @Override
    public void testType2(int type) {
        int b = 1;
        b = b * 50;

        try {
            Thread.sleep(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        b = 100;

        taskExecutor.execute(new MyJob(type + ""));

    }
}
