package ctg.pulse;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.harman.pulsesdk.DeviceModel;
import com.harman.pulsesdk.PulseColor;
import com.harman.pulsesdk.PulseNotifiedListener;
import com.harman.pulsesdk.PulseThemePattern;

import java.util.Timer;

public class MainActivity extends AppCompatActivity implements PulseNotifiedListener {

    boolean isConnectBT;
    static String Tag = "PulseDemo";
    Timer mTimer = null;
    PulseDemo pulseDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ctg.pulse.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(ctg.pulse.R.id.toolbar);
        setSupportActionBar(toolbar);
        pulseDemo = new PulseDemo();

    }

    private void cancelTimer()
    {
        if(mTimer!=null)
        {
            mTimer.cancel();
            mTimer=null;
        }
    }

    public void makeRedColor(View view){
        PulseColor pulseColor = new PulseColor();
        pulseColor.red = (byte)Color.red(-65536);
        pulseDemo.pulseHandler.SetBackgroundColor(pulseColor, true);

    }

    @Override
    public void onConnectMasterDevice() {
        Log.i(Tag, "onConnectMasterDevice");
        isConnectBT = true;
        cancelTimer();
        Toast.makeText(this, "onConnectMasterDevice", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisconnectMasterDevice() {

    }

    @Override
    public void onRetBrightness(int i) {

    }

    @Override
    public void onLEDPatternChanged(PulseThemePattern pulseThemePattern) {

    }

    @Override
    public void onSoundEvent(int i) {

    }

    @Override
    public void onRetCaptureColor(PulseColor pulseColor) {

    }

    @Override
    public void onRetCaptureColor(byte b, byte b1, byte b2) {

    }

    @Override
    public void onRetSetDeviceInfo(boolean b) {

    }

    @Override
    public void onRetGetLEDPattern(PulseThemePattern pulseThemePattern) {

    }

    @Override
    public void onRetRequestDeviceInfo(DeviceModel[] deviceModels) {

    }

    @Override
    public void onRetSetLEDPattern(boolean b) {

    }
}
