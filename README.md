# 简介
* 本项目为SpringBoot2.0 + TKMybatis + Druid多数据源配置
* 项目按照模块biz、client、repository、web采用maven来拆分
* 集成了MongoDB
* 集成了Redis，并开启了事务
* 配置文件和项目完全分离

# 启动
* 配置文件都在外部，通过java虚拟机的启动参数来配置
    * 在idea时，在VM options中配置：
        ````
        -Dspring.config.location=/Users/panda_zyp/Documents/Java/IDEA_WorkSpace/svn_21/config-test/firststep/application.properties
        -Dlogging.config=/Users/panda_zyp/Documents/Java/IDEA_WorkSpace/svn_21/config-test/firststep/log4j2.xml
        -Dapp.log.home=/Users/panda_zyp/Documents/logs/nextstep
     
    
  
   


