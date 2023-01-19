package com.example.logtestapi.Service.Imp;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.logtestapi.Service.ITestService;

@Service
public class testApiservice implements ITestService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CompletableFuture<String> callService(String url) {

        final String response = restTemplate.getForObject(url, String.class);

        return CompletableFuture.completedFuture(response);
    }

    @Override
    public void StressTest(int iteration, String url) throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        // calculate the duration start and finish
        Instant start = Instant.now();

        List<CompletableFuture<String>> allFutures = new ArrayList<>();

        for (int i = 0; i < iteration; i++) {
            allFutures.add(callService(url));
        }

        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();

        for (int i = 0; i < iteration; i++) {
            System.out.println("response: " + allFutures.get(i).get().toString());
        }

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("Total time: " + timeElapsed + " ms");

    }

}
