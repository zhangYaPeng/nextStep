package com.eakay.next.biz.job;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by 张亚鹏 on 2018/8/3.
 */
public class MyJob implements Runnable {

    private String name;

    public MyJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("正在执行[" + name + "]的任务");

        if (Objects.equals(name, "10") ) {
            throw new RejectedExecutionException("hehe，竟然是10");
        } else if ( Objects.equals(name, "100") ) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完了");
            return;
        }

        int b = 1 / 0;
        System.out.println(b);
    }
}
