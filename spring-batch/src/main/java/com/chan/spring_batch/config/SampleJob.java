package com.chan.spring_batch.config;

import com.chan.spring_batch.entity.CsvItemReader;
import com.chan.spring_batch.entity.Users;
import com.chan.spring_batch.entity.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

@Slf4j
@Configuration
public class SampleJob {

    @Autowired
    UserRepository userRepository;

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
    public Step simpleStep2(JobRepository jobRepository, Tasklet testTasklet2, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep2", jobRepository)
                .tasklet(testTasklet2, platformTransactionManager)
                .build();
    }

    @Bean
    public Tasklet testTasklet2() {
        return (contribution, chunkContext) -> {
            String logMessage = chunkContext.getStepContext()
                    .getJobParameters()
                    .get("logMessage")
                    .toString();
            log.info(">>>>> This is Step2 with message: {}", logMessage);
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Job chunkJob(JobRepository jobRepository, Step chunkStep) {
        return new JobBuilder("chunkJob", jobRepository)
                .start(chunkStep)
                .build();
    }

    @Bean
    public Step chunkStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager) {
        return new StepBuilder("chunkStep", jobRepository)
                .<String, String>chunk(10, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public ItemReader<String> itemReader() {
        return new ListItemReader<>(Arrays.asList("item1", "item2", "item3"));
    }

    @Bean
    public ItemProcessor<String, String> itemProcessor() {
        return item -> item.toUpperCase();
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        return items -> items.forEach(System.out::println);
    }

    @Bean
    public Job chunkJob2(JobRepository jobRepository, Step chunkStep2) {
        return new JobBuilder("chunkJob2", jobRepository)
                .start(chunkStep2)
                .build();
    }

    @Bean
    public Step chunkStep2(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager) {
        return new StepBuilder("chunkStep2", jobRepository)
                .<Users, Users>chunk(10, transactionManager)
                .reader(csvItemReader())
                .processor(userProcessor())
                .writer(userWriter(userRepository))
                .build();
    }

    @Bean
    public CsvItemReader csvItemReader() {
        log.info("csvRead Start!");
        return new CsvItemReader();
    }

    @Bean
    public ItemProcessor<Users, Users> userProcessor() {
        return users -> users;
    }

    @Bean
    public ItemWriter<Users> userWriter(UserRepository userRepository) {
        return new ItemWriter<Users>() {
            @Override
            public void write(Chunk<? extends Users> users) throws Exception {
                userRepository.saveAll(users);
            }
        };
    }
}
