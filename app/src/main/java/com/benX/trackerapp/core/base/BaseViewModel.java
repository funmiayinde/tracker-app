package com.benX.trackerapp.core.base;

import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.Disposable;

/**
 * Created by funmiayinde on 2019-09-09.
 */
public class BaseViewModel extends ViewModel implements Observable {

    protected Disposable mDisposable;
    protected PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }

    public void notifyChanges() {
        callbacks.notifyCallbacks(this, 0, null);
    }

    public void notifyPropertyChanges(int fieldId) {
        callbacks.notifyCallbacks(this, fieldId, null);
    }

    protected void disposeDisposable() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
