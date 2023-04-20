package com.example.schedulers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class ExceptionScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionScheduler.class);

    @Scheduled(cron="10 * * * *")
    void scheduleNullPointerException() {
        LOG.error("Throwing NullPointerException : {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        throw new NullPointerException();
    }

    @Scheduled(cron="20 * * * *")
    void scheduleHttpException500() {
        String exceptionMessage = "Throwing INTERNAL_SERVER_ERROR : "+ new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
        LOG.error(exceptionMessage);
        throw new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exceptionMessage);
    }

    @Scheduled(cron="30 * * * *")
    void scheduleHttpException400() {
        String exceptionMessage = "Throwing BadRequest status : "+ new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
        LOG.error(exceptionMessage);
        throw new HttpStatusException(HttpStatus.BAD_REQUEST, exceptionMessage);
    }

    @Scheduled(cron="40 * * * *")
    void scheduleHttpException403() {
        String exceptionMessage = "Throwing FORBIDDEN status : "+ new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
        LOG.error(exceptionMessage);
        throw new HttpStatusException(HttpStatus.FORBIDDEN, exceptionMessage);
    }

    @Scheduled(cron="50 * * * *")
    void scheduleHttpException401() {
        String exceptionMessage = "Throwing UNAUTHORIZED status : "+ new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
        LOG.error(exceptionMessage);
        throw new HttpStatusException(HttpStatus.UNAUTHORIZED, exceptionMessage);
    }

    @Scheduled(cron="59 * * * *")
    void scheduleHttpException504() {
        String exceptionMessage = "Throwing GATEWAY_TIMEOUT status : "+ new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
        LOG.error(exceptionMessage);
        throw new HttpStatusException(HttpStatus.GATEWAY_TIMEOUT, exceptionMessage);
    }
}
