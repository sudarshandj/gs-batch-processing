package com.example.gsbatchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void afterJob (JobExecution jobExceution) {
        if(jobExceution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! Job Completed!");

            jdbcTemplate.query("Select fname,lname from person",
                    (rs , row) -> new Person(
                            rs.getString(1),
                            rs.getString(1))
                    ).forEach(person -> log.info("Found < " +person+ "<> in the database.")
            );
        }
    }
}
