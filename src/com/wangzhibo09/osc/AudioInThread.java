// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.wangzhibo09.osc;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.wangzhibo09.osc:
//            OscActivity

public class AudioInThread extends Thread
{

    public AudioInThread()
    {
    }

    public void run()
    {
        OscActivity.threadStart = true;
        sampleRate = 44100;
        bufferSize = AudioRecord.getMinBufferSize(sampleRate, 16, 2);
        if(bufferSize < (2 * sampleRate) / 10)
            bufferSize = (2 * sampleRate) / 10;
        sound = new short[bufferSize];
        AudioRecord audiorecord = new AudioRecord(1, sampleRate, 16, 2, bufferSize);
        audiorecord.startRecording();
        int i = 0;
        do
        {
            if(OscActivity.guiStop)
            {
                audiorecord.stop();
                OscActivity.audioInStop = true;
                return;
            }
            Message message;
            if(i == 0)
                audiorecord.read(sound, 0, bufferSize / 2);
            else
                audiorecord.read(sound, bufferSize / 2, bufferSize / 2);
            message = new Message();
            message.arg1 = 1;
            message.arg2 = i;
            OscActivity.myHandler.sendMessage(message);
            i = 1 - i;
        } while(true);
    }

    public static int baud = 9600;
    public static int bufferSize = 0;
    public static int sampleRate = 44100;
    public static short sound[] = null;

}
