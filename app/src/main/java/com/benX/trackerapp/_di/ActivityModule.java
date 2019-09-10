package com.benX.trackerapp._di;


import com.benX.trackerapp._di.module.HomeModule;
import com.benX.trackerapp._di.scopes.ActivityScope;
import com.benX.trackerapp.main.home.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by funmiayinde on 2019-09-09.
 */

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {HomeModule.class})
    abstract HomeActivity bindHomeActivity();

}
