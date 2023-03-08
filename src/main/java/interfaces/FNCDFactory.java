package main.java.interfaces;

import main.java.activities.Activity;

public interface FNCDFactory<T> {
    T create(int type, Activity activity);
}
