package com.benX.trackerapp.core.listeners.schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by funmiayinde on 2019-09-10.
 */
public class AppRxSchedulers {

    public Scheduler scheduler = Schedulers.single();
    public Scheduler network = Schedulers.io();
    public Scheduler newThread = Schedulers.newThread();
    public Scheduler computation = Schedulers.computation();
    public Scheduler mainThread = AndroidSchedulers.mainThread();

    public Scheduler threadPoolSchedulers() {
        int threadCount = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPoolExecutorService = Executors.newFixedThreadPool(threadCount);
        return Schedulers.from(threadPoolExecutorService);
    }
}
