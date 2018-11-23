package com.pccb.customer.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;


@Component
public class AppCustomerTaskService {
    // 任务队列
    static LinkedBlockingQueue<AppCustomerTask> rechargeRecheckTaskQueue = new LinkedBlockingQueue<AppCustomerTask>();
    //任务线程
    static Thread rechargeRecheckTaskServiceThread;
    @Autowired
    private AppCustomerHandle consumer;

    //增加任务
    public boolean addTask(AppCustomerTask task) {
        if (rechargeRecheckTaskServiceThread == null) {
            // 消费者

            rechargeRecheckTaskServiceThread = new Thread(consumer);
            rechargeRecheckTaskServiceThread.start();
        }
        //添加到队列
        rechargeRecheckTaskQueue.offer(task);
        return true;
    }
}