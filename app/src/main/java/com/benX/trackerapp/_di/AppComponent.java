package com.benX.trackerapp._di;

import com.benX.trackerapp.TrackerApp;
import com.benX.trackerapp._di.module.ContributeActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by funmiayinde on 2019-09-09.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class, ContributeActivityModule.class})
public interface AppComponent {

    void inject(TrackerApp trackerApp);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(TrackerApp app);

        AppComponent build();
    }
}
