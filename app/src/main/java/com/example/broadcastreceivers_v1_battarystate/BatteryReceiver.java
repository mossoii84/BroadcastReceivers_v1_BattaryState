package com.example.broadcastreceivers_v1_battarystate;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {

    //Можно создать отдельный класс с extends BroadcastReceiver или сделать как
    // в MainActivity подключить этот класс  private BatteryReceiver mBatteryReceiver = new BatteryReceiver();
    // и сделать   registerReceiver(mBatteryReceiver, ifilter);

    //приемник
    @Override
    public void onReceive(Context context, Intent intent) {

        TextView  statusLabel = ((MainActivity)context).findViewById(R.id.statusLabel);
        TextView parcentageLabel = ((MainActivity)context).findViewById(R.id.parcentageLabel);
        ImageView  battaryImage = ((MainActivity)context).findViewById(R.id.batteryImage);

        String action = intent.getAction();
        //Status
        if(action !=null && action.equals(Intent.ACTION_BATTERY_CHANGED)){
            // Are we charging / charged?
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            String message = "";
            switch(status){
                case BatteryManager.BATTERY_STATUS_FULL:
                    message = "Full";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    message = "Charging";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    message = "Discharging";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    message = "No charging";
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    message = "Unknow";
                    break;
            }
            statusLabel.setText(message);

            //Porcentage
            // the current battery level
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int batteryPct = level * 100/scale;

                parcentageLabel.setText(batteryPct + "%");
       }

}



}
