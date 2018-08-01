package com.eakay.next.repository.util.table;

/**
 * Created by 张亚鹏 on 2018/7/18.
 */
public interface TableSplitStrategy {

    String getTableName(Object... keys);

}
