package com.eakay.next.client.mq.common;

/**
 * 生产者通道常量
 * <br> 普通的通道就是一个普通的字符串而已
 * <br> 虚拟topic的通道是固定格式的：VirtualTopic.xxxxx
 */
public class ProducerConst {

    public static final String QUEUE_TEST = "queue.test";

    public static final String QUEUE_VIRTUAL_TOPIC_TEST = "VirtualTopic.test";

}
