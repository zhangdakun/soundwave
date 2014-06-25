// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.wangzhibo09.osc;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.wangzhibo09.osc:
//            AudioInThread

public class OscView extends View
{

    public OscView(Context context)
    {
        super(context);
        Width = 320;
        Height = 240;
        datY1 = new int[2048];
        mPaint = null;
        Init();
    }

    public OscView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        Width = 320;
        Height = 240;
        datY1 = new int[2048];
        mPaint = null;
        Init();
    }

    private void Init()
    {
        mPaint = new Paint();
        mPaint.setColor(0xff000000);
        int i = 0;
        do
        {
            if(i >= 2048)
                return;
            datY1[i] = 0;
            i++;
        } while(true);
    }

    private int measure(int i, boolean flag)
    {
        int j;
        int k;
        int l;
        if(flag)
            j = 320;
        else
            j = 240;
        k = android.view.View.MeasureSpec.getMode(i);
        l = android.view.View.MeasureSpec.getSize(i);
        if(k == 0x80000000)
        {
            if(j > l)
                j = l;
            if(!flag)
                j = (int)(0.84999999999999998D * (double)l);
        } else
        if(k == 0x40000000)
            j = l;
        else
        if(j > l)
            j = l;
        if(flag)
        {
            if(j > 2048)
                j = 2048;
            Width = j;
        } else
        {
            Height = j;
        }
        return j;
    }

    protected void onDraw(Canvas canvas)
    {
        int i;
        float f;
        float f1;
        int j;
        mPaint.setColor(0xff888888);
        canvas.drawRect(0.0F, 0.0F, Width, Height, mPaint);
        i = (int)((2.5D * (double)(Width + Height)) / 100D);
        f = ((float)Width - 2.0F * (float)i) / (float)10;
        f1 = ((float)Height - 2.0F * (float)i) / (float)10;
        mPaint.setColor(Color.rgb(200, 200, 200));
        j = 0;
//_L9:
//        if(j <= 10) goto _L2; else goto _L1
//_L1:
//        int k = 0;
//_L10:
//        if(k <= 10) goto _L4; else goto _L3
//_L3:
//        float f2;
//        float f3;
//        int l;
//        f2 = (float)i + (f1 * (float)10) / 2.0F;
//        f3 = (float)i + (f * (float)10) / 2.0F;
//        canvas.drawLine(0.0F, f2, Width, f2, mPaint);
//        canvas.drawLine(f3, 0.0F, f3, Height, mPaint);
//        l = 0;
//_L11:
//        if(l <= 50) goto _L6; else goto _L5
//_L5:
//        int i1 = 0;
//_L12:
//        if(i1 <= 50) goto _L8; else goto _L7
//_L7:
//        int j1;
//        float f4 = f * (1.0F / (float)AudioInThread.sampleRate);
//        String s = (new StringBuilder("Time:")).append(String.valueOf((float)Math.round(1000F * (100F * f4)) / 100F)).append("ms/Grid").toString();
//        mPaint.setColor(-1);
//        canvas.drawText(s, i, 0.8F * (float)i, mPaint);
//        mPaint.setColor(0xff00ff00);
//        j1 = 0;
//_L13:
		// if(j1 >= -1 + Width)
//            return;
//        break MISSING_BLOCK_LABEL_489;
//_L2:
//        canvas.drawLine(i, (float)i + f1 * (float)j, Width - i, (float)i + f1 * (float)j, mPaint);
//        j++;
//          goto _L9
//_L4:
//        canvas.drawLine((float)i + f * (float)k, i, (float)i + f * (float)k, Height - i, mPaint);
//        k++;
//          goto _L10
//_L6:
//        canvas.drawLine((float)i + (f * (float)l) / 5F, f2 - f1 / (float)15, (float)i + (f * (float)l) / 5F, f2 + f1 / (float)15, mPaint);
//        l++;
//          goto _L11
//_L8:
//        canvas.drawLine(f3 - f / (float)15, (float)i + (f1 * (float)i1) / 5F, f3 + f / (float)15, (float)i + (f1 * (float)i1) / 5F, mPaint);
//        i1++;
//          goto _L12
//        canvas.drawLine(j1, f2 - ((float)datY1[j1] / 32768F) * ((f1 * (float)10) / 2.0F), j1 + 1, f2 - ((float)datY1[j1 + 1] / 32768F) * ((f1 * (float)10) / 2.0F), mPaint);
//        j1++;
//          goto _L13
        
        
        for(j=0;j <= 10;j++) {
        	canvas.drawLine(i, (float)i + f1 * (float)j, Width - i, (float)i + f1 * (float)j, mPaint);
        }
        
        int k = 0;
        
        for(k=0;k <= 10;k++) {
        	canvas.drawLine((float)i + f * (float)k, i, (float)i + f * (float)k, Height - i, mPaint);
        }
        
		float f2;
		float f3;
		int l;
		f2 = (float) i + (f1 * (float) 10) / 2.0F;
		f3 = (float) i + (f * (float) 10) / 2.0F;
		canvas.drawLine(0.0F, f2, Width, f2, mPaint);
		canvas.drawLine(f3, 0.0F, f3, Height, mPaint);
		l = 0;

		for (l = 0; l <= 50; l++) {
			canvas.drawLine((float) i + (f * (float) l) / 5F, f2 - f1
					/ (float) 15, (float) i + (f * (float) l) / 5F, f2 + f1
					/ (float) 15, mPaint);
		}

		int i1 = 0;
		for (i1 = 0; i1 <= 50; i1++) {
			canvas.drawLine(f3 - f / (float) 15, (float) i + (f1 * (float) i1)
					/ 5F, f3 + f / (float) 15, (float) i + (f1 * (float) i1)
					/ 5F, mPaint);
		}

		int j1;
		float f4 = f * (1.0F / (float) AudioInThread.sampleRate);
		String s = (new StringBuilder("Time:"))
				.append(String.valueOf((float) Math.round(1000F * (100F * f4)) / 100F))
				.append("ms/Grid").toString();
		mPaint.setColor(-1);
		canvas.drawText(s, i, 0.8F * (float) i, mPaint);
		mPaint.setColor(0xff00ff00);
		j1 = 0;

		for (j1 = 0; j1 < -1 + Width; j1++) {
			canvas.drawLine(j1, f2 - ((float) datY1[j1] / 32768F)
					* ((f1 * (float) 10) / 2.0F), j1 + 1, f2
					- ((float) datY1[j1 + 1] / 32768F)
					* ((f1 * (float) 10) / 2.0F), mPaint);
		}
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(measure(i, true), measure(j, false));
    }

    private static final int defaultHeight = 240;
    private static final int defaultWidth = 320;
    private static final int maxWidth = 2048;
    public int Height;
    public int Width;
    public int datY1[];
    private Paint mPaint;
}
