package com.eakay.next.client.mq.common;

/**
 * 消费者通道常量
 * <br> 普通的通道就是一个普通的字符串而已
 * <br> 虚拟topic的通道是固定格式的：Consumer.xxxxxx.VirtualTopic.xxxxx
 * <br> 说白了，对于虚拟topic，消费者通道的命名就是在生产者命名的基础上根据固定的格式再加一些业务名称
 */
public class SubscriberConst {

    /**
     * 普通通道
     */
    public static final String QUEUE_TEST = "queue.test";

    /**
     * 虚拟topic测试1
     */
    public static final String QUEUE_VIRTUAL_TOPIC_TEST1 = "Consumer.test1.VirtualTopic.test";


    /**
     * 通知系统冻结供货商
     */
    public static final String QUEUE_MERCHANT_STATUS_STOP = "queue.merchant.status.stop";
}
