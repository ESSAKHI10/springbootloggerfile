package com.example.logtestapi.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface ITestService {
    CompletableFuture<String> callService(String url);

    void StressTest(int iteration, String url) throws InterruptedException, ExecutionException;

}
