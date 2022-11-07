package io.swagger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Component
public class ExpireDates {

    private static final Logger log = LoggerFactory.getLogger(ExpireDates.class);

    @Autowired
    private UserAccreditationService userAccreditationService;

    @Scheduled(fixedRate = 15000)
    public void backTask() {
        log.debug("Background process for updating accreditations");
        LocalDateTime time = LocalDateTime.now().minusDays(30);
        userAccreditationService.updateExpiredStatus(Timestamp.valueOf(time));
    }

}
