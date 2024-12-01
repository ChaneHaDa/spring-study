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

    @Autowired
    Job simpleJob2;

    @Autowired
    Job chunkJob;

    @RequestMapping("/tasklet1/{id}")
    public void taskletHandle(@PathVariable("id") String id) throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", id)
                        .addDate("date", new Date())
                                .toJobParameters();

        jobLauncher.run(simpleJob1, jobParameters);
    }

    @RequestMapping("/tasklet2/{id}")
    public void taskletHandle2(@PathVariable("id") String id) throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", id)
                .addDate("date", new Date())
                .toJobParameters();

        jobLauncher.run(simpleJob2, jobParameters);
    }

    @RequestMapping("/chunk/{id}")
    public void chunkHandle(@PathVariable("id") String id) throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("id", id)
                .addDate("date", new Date())
                .toJobParameters();

        jobLauncher.run(chunkJob, jobParameters);
    }
}
