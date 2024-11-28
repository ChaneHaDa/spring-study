package com.chan.spring_batch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class SampleJob {

    @Bean
    public Job simpleJob1(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("simpleJob", jobRepository)
                .start(simpleStep1)
                .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("simpleStep1", jobRepository)
                .tasklet(testTasklet, platformTransactionManager).build();
    }

    @Bean
    public Tasklet testTasklet(){
        return ((contribution, chunkContext) -> {
            log.info(">>>>> This is Step1");
            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    public Job simpleJob2(JobRepository jobRepository, Step simpleStep2) {
        return new JobBuilder("simpleJob2", jobRepository)
                .start(simpleStep2)
                .build();
    }

    @Bean
    public Step simpleStep2(JobRepository jobRepository, Tasklet testTasklet2, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("simpleStep2", jobRepository)
                .tasklet(testTasklet2, platformTransactionManager).build();
    }

    @Bean
    public Tasklet testTasklet2(){
        return ((contribution, chunkContext) -> {
            log.info(">>>>> This is Step2");
            return RepeatStatus.FINISHED;
        });
    }

//    @Bean
//    public JobLauncher jobLauncher() throws Exception {
//        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
//        jobLauncher.setJobRepository(jobRepository);
//        jobLauncher.afterPropertiesSet();
//        return jobLauncher;
//    }
}
