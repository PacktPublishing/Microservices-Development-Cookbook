package com.packtpub.microservices.ch06.attachment;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import com.packtpub.microservices.ch06.attachment.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(Configuration.class)
public class Application {

    private final Configuration config;

    public Application(Configuration config) {
        this.config = config;
    }

    @Bean
    public AmazonS3 getS3Client() {
        AmazonS3ClientBuilder client = AmazonS3ClientBuilder.standard();
        AWSCredentials credentials = new BasicAWSCredentials(config.getAwsAccessKeyId(), config.getAwsSecretAccessKey());
        return client.withCredentials(
                new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
