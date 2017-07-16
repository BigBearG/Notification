package text.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1= (Button) findViewById(R.id.button1);
        Button button2= (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                Intent intent=new Intent(this,NotificationActivity.class);
                PendingIntent pi=PendingIntent.getActivity(this,0,intent,0);
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification= new NotificationCompat.Builder(MainActivity.this).setContentTitle("这是一个通知")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("这是一个通知内容dsfdfhfadffgjgfsghghgfdsadasfghfsasdfgdfaasdfgfsaasdgfhfaasdghgfasfdgbbfgsaeaeasf").setBigContentTitle("sDA")
                )/*.setContentText("这是一个通知内容dsfdfhfadffgjgfsghghgfdsadasfghfsasdfgdfaasdfgfsaasdgfhfaasdghgfasfdgbbfgsaeaeasf")*/
                .setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.ic_launcher
                ).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round)
                ).setContentIntent(pi
                )/*.第一种方法setAutoCancel(true)*/
                /*.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg"))
                ).setVibrate(new long[]{0,1000,1000,1000}).setLights(Color.RED,1000,1000)
                        */.setDefaults(NotificationCompat.DEFAULT_ALL).build();
                manager.notify(1,notification);
                break;
            case R.id.button2:
                Intent intent2=new Intent(this,NotificationActivity.class);
                PendingIntent pi2=PendingIntent.getActivity(this,0,intent2,0);
                NotificationManager manager2= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification2= new NotificationCompat.Builder(MainActivity.this).setContentTitle("这是一个通知"
                ).setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.ic_launcher
                ).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round)
                ).setContentIntent(pi2
                ).setDefaults(NotificationCompat.DEFAULT_ALL
                ).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.im_notification))
                ).setPriority(NotificationCompat.PRIORITY_MAX).build();
                manager2.notify(1,notification2);
                break;
        }
    }
}
