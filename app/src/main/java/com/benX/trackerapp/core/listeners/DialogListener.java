package com.benX.trackerapp.core.listeners;

/**
 * Created by funmiayinde on 2019-09-10.
 */
public interface DialogListener {

    void onPositiveClick();

    default void onNegativeClick() {
    }
}
