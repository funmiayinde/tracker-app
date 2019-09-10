package com.benX.trackerapp.core.base;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by funmiayinde on 2019-09-09.
 */
public interface BaseRepository<T, P> {

    Flowable<T> create(P data, HashMap query);

    Flowable<T> edit(String id, P data, HashMap query);

    Flowable<T> get(String id, HashMap query);

    Flowable<List<T>> find(HashMap query);

    Flowable<T> delete(String id);
}
