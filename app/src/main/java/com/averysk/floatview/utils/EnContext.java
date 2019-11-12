package com.averysk.floatview.utils;

import android.app.Application;

/**
 * Created by Averysk
 */
public class EnContext {

    private static final Application INSTANCE;
    private static final Application INSTANCE2;

    static {
        Application app = null;
        try {
            app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
            if (app == null)
                throw new IllegalStateException("Static initialization of Applications must be on main thread.");
        } catch (final Exception e) {
            e.printStackTrace();
            try {
                app = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (final Exception ex) {
                e.printStackTrace();
            }
        } finally {
            INSTANCE = app;
            INSTANCE2 = app;
        }
    }

    public static Application get() {
        return INSTANCE;
    }

    public static Application get2() {
        return INSTANCE2;
    }
}
