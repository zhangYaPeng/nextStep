package com.eakay.next.web.config;

import com.eakay.next.repository.util.table.OrderTableSplitStrategy;
import com.eakay.next.repository.util.table.TableSplitStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 张亚鹏 on 2018/7/23.
 */
@Configuration
public class OtherConfig {

    @Bean
    public TableSplitStrategy orderTableSplitStrategy() {
        OrderTableSplitStrategy tableSplitStrategy = new OrderTableSplitStrategy();
        tableSplitStrategy.setSplit(10);

        return tableSplitStrategy;
    }
}
