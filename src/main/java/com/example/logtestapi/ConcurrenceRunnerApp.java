package com.example.logtestapi;

// import java.time.Duration;
// import java.time.Instant;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.logtestapi.Service.ITestService;

@Component
public class ConcurrenceRunnerApp implements CommandLineRunner {
    //
    // @Autowired
    // private ITestService asyncService;

    @Override
    public void run(String... args) throws Exception {

        // asyncService.StressTest(10, "http://localhost:8080/api/v1/user/sayHello");
        // asyncService.StressTest(10, "http://localhost:8080/api/v1/user/all");
    }

}
