// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.wangzhibo09.osc;

import android.app.Application;

public class OscApplication extends Application
{

    public OscApplication()
    {
    }

    public static OscApplication getInstance()
    {
        return singleton;
    }

    public final void onCreate()
    {
        super.onCreate();
        singleton = this;
    }

    public final void onTerminate()
    {
        super.onTerminate();
    }

    private static OscApplication singleton;
}
