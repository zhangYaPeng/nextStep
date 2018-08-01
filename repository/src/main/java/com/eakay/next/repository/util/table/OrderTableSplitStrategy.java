package com.eakay.next.repository.util.table;

/**
 * Created by 张亚鹏 on 2018/7/18.
 */
public class OrderTableSplitStrategy implements TableSplitStrategy {

    private int split = 10;

    public int getSplit() {
        return split;
    }

    public void setSplit(int split) {
        this.split = split;
    }

    @Override
    public String getTableName(Object... keys) {
        int id = (int) keys[0];
        return  "order_" + (id / split);

    }

}
