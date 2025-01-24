package com.chan.spring_batch.entity;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class CsvItemReader implements ItemReader<Users> {
    private BufferedReader reader;
    private Iterable<CSVRecord> records;
    private java.util.Iterator<CSVRecord> iterator;

    public CsvItemReader() {
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new ClassPathResource("users.csv").getInputStream(), StandardCharsets.UTF_8));
            records = CSVFormat.DEFAULT.withHeader("name", "email").parse(reader);
            iterator = records.iterator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users read() throws Exception {
        if (iterator.hasNext()) {
            CSVRecord record = iterator.next();
            Users users = new Users();
            users.setName(record.get("name"));
            users.setEmail(record.get("email"));
            return users;
        }
        return null;
    }
}