package com.chan.spring_batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MainController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job simpleJob1;

    @RequestMapping("/index/{id}")
    public void handle(@PathVariable("id") String id) throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", id)
                        .addDate("date", new Date())
                                .toJobParameters();

        jobLauncher.run(simpleJob1, jobParameters);
    }
}
