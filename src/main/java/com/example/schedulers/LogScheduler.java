package com.example.schedulers;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class LogScheduler {
    private static final Logger LOG = LoggerFactory.getLogger(LogScheduler.class);

    @Scheduled(cron="1 * * * *")
    void scheduleInfoLogging() {
        LOG.info("Random INFO logging: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

    @Scheduled(cron="15 * * * *")
    void scheduleTraceLogging() {
        LOG.trace("Random TRACE logging: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

    @Scheduled(cron="30 * * * *")
    void scheduleDebugLogging() {
        LOG.debug("Random DEBUG logging: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

    @Scheduled(cron="45 * * * *")
    void scheduleErrorLogging() {
        LOG.error("Random ERROR logging: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

}
