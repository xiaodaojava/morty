package com.platform.oecp.business.manager;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @className: TaskScheduler
 * @author: LILIANG
 * @date: Create In 2020/3/29 21:30
 * @description:
 */
public class ThreadPoolConfig {

    /**
     * IO 线程池
     */
    public static ThreadPoolExecutor ioExecutor;

    public static final int nThreads = Runtime.getRuntime().availableProcessors();

    static {
        ThreadFactory ioFactory = new ThreadFactoryBuilder().setNameFormat("io-pool-%d").build();
        LinkedBlockingDeque<Runnable> ioTaskQueue = new LinkedBlockingDeque<>(10);
        ioExecutor = new ThreadPoolExecutor(nThreads, 2*nThreads+1, 1L, TimeUnit.MINUTES, ioTaskQueue, ioFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
