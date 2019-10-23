package edu.niit.text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyBindService.MyBinder myBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder=(MyBindService.MyBinder) service;
            myBinder.startDownload();
            myBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start_service:    //启动服务
                Intent intent=new Intent(this,MyService.class);
                startService(intent);
                 break;
            case R.id.btn_stop_service:     //停止服务
                intent=new Intent(this,MyService.class);
                stopService(intent);
                break;
            case R.id.btn_bind_service:     //绑定服务
                intent =new Intent(this,MyBindService.class);
                bindService(intent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:   //解绑服务
                unbindService(connection);
                break;
            case R.id.btn_foreground_service:
                intent =new Intent(this,MyForeService.class);
                startService(intent);
                break;
            case R.id.btn_stop_foreground_service:
                intent =new Intent(this,MyForeService.class);
                stopService(intent);
                break;
            case R.id.btn_intent_service:
                intent =new Intent(this,MyIntentService.class);
                startService(intent);
            break;
            case R.id.btn_start:
                break;
        }
    }
}
