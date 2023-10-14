package com.zht.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class FlushTask {
    @Scheduled(initialDelay = 1, fixedRate = 1,timeUnit = TimeUnit.SECONDS)
    private void myTasks3() {
        log.debug("我是一个定时任务!");
    }

}
