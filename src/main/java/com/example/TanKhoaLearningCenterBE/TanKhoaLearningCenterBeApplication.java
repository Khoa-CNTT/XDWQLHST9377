package com.example.TanKhoaLearningCenterBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication(scanBasePackages = {"com.example" })
@EnableCaching
public class TanKhoaLearningCenterBeApplication {

    public static void main(String[] args) {

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        System.setProperty("log.timestamp", timestamp);

        SpringApplication.run(TanKhoaLearningCenterBeApplication.class, args);
    }

}
