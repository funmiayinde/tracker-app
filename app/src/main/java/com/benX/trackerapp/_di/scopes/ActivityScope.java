package com.benX.trackerapp._di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Singleton;

/**
 * Created by funmiayinde on 2019-09-09.
 */

@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
