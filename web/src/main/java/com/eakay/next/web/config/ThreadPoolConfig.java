package com.eakay.next.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;

@Configuration
@ConfigurationProperties(prefix = "thread.pool.executor")
public class ThreadPoolConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;

    private int keepAliveSeconds;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new TraceThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        return taskExecutor;
    }

    /**
     * 自定义可追踪线程池（拓展自ThreadPoolTaskExecutor），当发生异常时，直接追踪至调用者处
     */
    static class TraceThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

        @Override
        public void execute(Runnable task) {
            super.execute(wrap(task, clientTrace()));
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task, clientTrace()));
        }

        private Exception clientTrace() {
            return new Exception("异步任务调用失败，堆栈如下：");
        }

        private Runnable wrap(final Runnable task, final Exception clientTrace) {
            return () -> {
                try {
                    task.run();
                } catch (Exception e) {
                    logger.warn("异步任务调用失败，堆栈如下：", clientTrace);
                    throw e;
                }
            };
        }

    }

}
