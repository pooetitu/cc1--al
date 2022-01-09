package com.al.cc2;

import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.kernel.CommandBus;
import com.al.cc2.use_cases.subscription.application.ProcessSubscriptionPayments;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {
    private final ApplicationLogger logger;
    private final CommandBus commandBus;

    public SchedulerConfiguration(ApplicationLogger logger, CommandBus commandBus) {
        this.logger = logger;
        this.commandBus = commandBus;
    }

    @Scheduled(cron = "0 0 4 ? * *")
    public void processSubscriptionPayments() throws Exception {
        logger.info("Processing membership subscriptions");
        commandBus.send(new ProcessSubscriptionPayments());
    }
}
