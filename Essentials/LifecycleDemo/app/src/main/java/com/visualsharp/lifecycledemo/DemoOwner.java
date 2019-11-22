package com.visualsharp.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public class DemoOwner implements LifecycleOwner {

    private LifecycleRegistry lifecycleRegistry;

    public DemoOwner() {
        this.lifecycleRegistry = new LifecycleRegistry(this);
        getLifecycle().addObserver(new DemoObserver());
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    public void startOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }
    public void stopOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }
}
