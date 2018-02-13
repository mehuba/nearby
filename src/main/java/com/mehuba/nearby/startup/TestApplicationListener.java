package com.mehuba.nearby.startup;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoyibin on 23:14 2018/2/12
 */
@Component
public class TestApplicationListener implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextRefreshedEvent) {
            System.out.println("ContextRefreshedEvent");
        }
        System.out.println(applicationEvent);
    }
}
