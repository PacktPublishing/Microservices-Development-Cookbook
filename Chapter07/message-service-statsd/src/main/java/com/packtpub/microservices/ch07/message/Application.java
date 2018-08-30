package com.packtpub.microservices.ch07.message;

import com.packtpub.microservices.ch07.message.clients.SocialGraphClient;

import io.micrometer.core.instrument.Clock;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdMeterRegistry;
import io.micrometer.statsd.StatsdMetrics;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.export.statsd.StatsdProperties;
import org.springframework.boot.actuate.autoconfigure.metrics.export.statsd.StatsdPropertiesConfigAdapter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class Application {

    @Bean
    public MessageRepository messageRepository() {
        return new MessageRepository();
    }

    @Bean
    public SocialGraphClient socialGraphClient() {
        return new SocialGraphClient("http://localhost:4567");
    }

    @Bean
    public StatsdConfig statsdConfig(StatsdProperties statsdProperties) {
        return new StatsdPropertiesConfigAdapter(statsdProperties);
    }

    @Bean
    public StatsdMeterRegistry statsdMeterRegistry(StatsdConfig statsdConfig,
                                                   Clock clock) {
        return new StatsdMeterRegistry(statsdConfig, clock);
    }

    @Bean
    public StatsdMetrics statsdMetrics() {
        return new StatsdMetrics();
    }


    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Application.class);
        logger.info("Starting application");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("SocialServiceCall-");
        executor.initialize();
        return executor;
    }
}