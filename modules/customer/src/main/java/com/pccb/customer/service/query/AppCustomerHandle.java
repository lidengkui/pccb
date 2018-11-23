package com.pccb.customer.service.query;

import com.pccb.customer.entity.AppCustomerEntity;
import com.pccb.customer.service.AppCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

@Component
public class AppCustomerHandle implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(AppCustomerHandle.class);
    private LinkedBlockingQueue<AppCustomerTask> queue;
    @Autowired
    private AppCustomerService customerService;

    public AppCustomerHandle() {
        this.queue = AppCustomerTaskService.rechargeRecheckTaskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                logger.debug("当前队列数量：" + queue.size());
                System.out.println("==============队列数量：" + queue.size());
                AppCustomerTask task = queue.take();
                reCheckNew(task);

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public void reCheckNew(AppCustomerTask task) {
        try {
            AppCustomerEntity list = customerService.findByAppCode(task.getCode());
            System.out.println("-----------------------消费结果：" + list);
            System.out.println("-----------------------注入的service:" + customerService);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}