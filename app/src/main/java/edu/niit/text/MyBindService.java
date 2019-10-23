package edu.niit.text;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {
    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyBindService","onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        for (int i=0 ;i<10;i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("MyBindService","onStartCommand executed"+i);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyBindService","onDestroy executed");
    }
    private MyBinder myBinder=new MyBinder();
    class MyBinder extends Binder{
        public void startDownload(){
            Log.i("MyBindService","startDownload executed");
        }
        public int getProgress(){
            Log.i("MyBindService","getProgress executed");
            return 0;
        }
    }
}
