// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.wangzhibo09.osc;

import net.youmi.android.AdManager;
import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import android.app.Activity;
import android.os.*;
import android.widget.LinearLayout;

import com.android.adlib.ADbaseActivity;
import com.myappshipo.osc.R;

// Referenced classes of package com.wangzhibo09.osc:
//            AudioInThread, OscView

public class OscActivity extends ADbaseActivity
{

    public OscActivity()
    {
    }

    private void DestroyThread()
    {
        guiStop = true;
        do
        {
            if(audioInStop)
                return;
            SystemClock.sleep(10L);
        } while(true);
    }

    private void InitThread()
    {
        guiStop = false;
        threadStart = false;
        audioInStop = false;
        (new AudioInThread()).start();
        do
        {
            if(threadStart)
                return;
            SystemClock.sleep(10L);
        } while(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        
        AdManager.getInstance(this).init("f874cd7da61a52ac",
        	    "51325751e84918f3", false);
        
      LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
      AdView adView = new AdView(this, AdSize.FIT_SCREEN);
      adLayout.addView(adView);
        
        myHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
//                message.arg1;
//                JVM INSTR tableswitch 0 1: default 32
//            //                           0 32
//            //                           1 33;
//                   goto _L1 _L1 _L2
//_L1:
//                return;
//_L2:
//                int i;
//                OscView oscview;
//                int j;
//                i = 0;
//                if(message.arg2 == 1)
//                    i = AudioInThread.bufferSize / 2;
//                oscview = (OscView)findViewById(0x7f060001);
//                j = 0;
//_L5:
//                if(j < oscview.Width) goto _L4; else goto _L3
//_L3:
//                oscview.invalidate();
//                  goto _L1
//_L4:
//                oscview.datY1[j] = AudioInThread.sound[i + j];
//                j++;
//                  goto _L5
                
                switch (message.arg1) {
				case 0:
					
					break;
				case 1:
	                int i;
	                OscView oscview;
	                int j;
	                i = 0;
	                if(message.arg2 == 1)
	                    i = AudioInThread.bufferSize / 2;
	                oscview = (OscView)findViewById(0x7f060001);
	                j = 0;
					
	                for(j=0;j<oscview.Width;j++) {
	                	oscview.datY1[j] = AudioInThread.sound[i + j];
	                }
	                
	                oscview.invalidate();
					break;

				default:
					break;
				}
                
            }

//            final OscActivity this$0;
//
//            
//            {
//                this$0 = OscActivity.this;
//                super();
//            }
        }
;
        InitThread();
    }

    public void onDestroy()
    {
        super.onDestroy();
        DestroyThread();
    }

    public static boolean audioInStop = false;
    public static boolean guiStop = false;
    public static Handler myHandler = null;
    public static boolean threadStart = false;

}
