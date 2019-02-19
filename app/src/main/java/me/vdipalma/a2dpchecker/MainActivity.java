package me.vdipalma.a2dpchecker;

import android.databinding.DataBindingUtil;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import me.vdipalma.a2dpchecker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AudioManager audioM;
    private ActivityMainBinding binding;
    private DevicesAdapter devicesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        audioM = (AudioManager) getApplicationContext().getSystemService(getApplicationContext().AUDIO_SERVICE);

        binding.devicesList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        devicesAdapter = new DevicesAdapter();
        binding.devicesList.setAdapter(devicesAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AudioDeviceInfo[] devices = audioM.getDevices(AudioManager.GET_DEVICES_ALL);
        devicesAdapter.setDataset(devices);
    }
}
