package com.example.broadcastreceivers_v1_battarystate;


import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
                 //ТЕОРИЯ
//    Само широковещательное сообщение заключено в Intent объект
    //Intent храниться состояние зарядки.

//    Это вернет Intent с различными дополнениями, описанными в классе BatteryManager.
//    Используйте BatteryManager.EXTRA_LEVEL и BatteryManager.EXTRA_SCALE, чтобы определить оставшийся процент.

//    Если вам нужно знать в течение определенного периода времени при изменении батареи,
//    используйте подход BroadcastReceiver

    //    Чтобы получить уровень заряда батареи прямо сейчас, вызывайте:
//    registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    //более красивая запись и передача в переменную нашего registerReceiver  //из Туториала
    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED); //Intent храниться состояние зарядки.
    //привязка к нашему классу BatteryReceiver где у нас есть extends BroadcastReceiver
    private BatteryReceiver mBatteryReceiver = new BatteryReceiver();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //регистрируем приемник
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mBatteryReceiver, ifilter); //передаем сюда наши действия из BroadcastReceiver broadcastReceiver
    }

    //  Чтобы прекратить прием трансляций
    @Override
    protected void onPause() {
        unregisterReceiver(mBatteryReceiver);
        super.onPause();
    }


    //Такой вариант без доп класса BatteryReceiver у меня работает не корректно
//    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//      ----------______тут можно установить данные из BatteryReceiver
//            }
//        }
//    };

}



