package com.packtpub.microservices.ch06.attachment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("attachment")
public class Configuration {

    private String awsAccessKeyId;

    private String awsSecretAccessKey;

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }

    public String getAwsSecretAccessKey() {
        return awsSecretAccessKey;
    }

    public void setAwsSecretAccessKey(String awsSecretAccessKey) {
        this.awsSecretAccessKey = awsSecretAccessKey;
    }
}
