package me.vdipalma.a2dpchecker;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.media.AudioDeviceInfo;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.vdipalma.a2dpchecker.databinding.ItemDeviceBinding;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {
    AudioDeviceInfo[] dataset;

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_device, viewGroup, false);
        return new DeviceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder deviceViewHolder, int i) {
        deviceViewHolder.bind(dataset[i]);
    }

    public void setDataset(AudioDeviceInfo[] dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }


    public class DeviceViewHolder extends RecyclerView.ViewHolder {

        private final ItemDeviceBinding binding;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(AudioDeviceInfo info) {
            binding.name.setText(info.getProductName());

            switch (info.getType()) {
                case AudioDeviceInfo.TYPE_UNKNOWN:
                    binding.type.setText("TYPE_UNKNOWN");
                    break;
                case AudioDeviceInfo.TYPE_BUILTIN_EARPIECE:
                    binding.type.setText("TYPE_BUILTIN_EARPIECE");
                    break;
                case AudioDeviceInfo.TYPE_BUILTIN_SPEAKER:
                    binding.type.setText("TYPE_BUILTIN_SPEAKER");
                    break;
                case AudioDeviceInfo.TYPE_WIRED_HEADSET:
                    binding.type.setText("TYPE_WIRED_HEADSET");
                    break;
                case AudioDeviceInfo.TYPE_WIRED_HEADPHONES:
                    binding.type.setText("TYPE_WIRED_HEADPHONES");
                    break;
                case AudioDeviceInfo.TYPE_LINE_ANALOG:
                    binding.type.setText("TYPE_LINE_ANALOG");
                    break;
                case AudioDeviceInfo.TYPE_LINE_DIGITAL:
                    binding.type.setText("TYPE_LINE_DIGITAL");
                    break;
                case AudioDeviceInfo.TYPE_BLUETOOTH_SCO:
                    binding.type.setText("TYPE_BLUETOOTH_SCO");
                    break;
                case AudioDeviceInfo.TYPE_BLUETOOTH_A2DP:
                    binding.type.setText("TYPE_BLUETOOTH_A2DP");
                    break;
                case AudioDeviceInfo.TYPE_HDMI:
                    binding.type.setText("TYPE_HDMI");
                    break;
                case AudioDeviceInfo.TYPE_HDMI_ARC:
                    binding.type.setText("TYPE_HDMI_ARC");
                    break;
                case AudioDeviceInfo.TYPE_USB_DEVICE:
                    binding.type.setText("TYPE_USB_DEVICE");
                    break;
                case AudioDeviceInfo.TYPE_USB_ACCESSORY:
                    binding.type.setText("TYPE_USB_ACCESSORY");
                    break;
                case AudioDeviceInfo.TYPE_DOCK:
                    binding.type.setText("TYPE_DOCK");
                    break;
                case AudioDeviceInfo.TYPE_FM:
                    binding.type.setText("TYPE_FM");
                    break;
                case AudioDeviceInfo.TYPE_BUILTIN_MIC:
                    binding.type.setText("TYPE_BUILTIN_MIC");
                    break;
                case AudioDeviceInfo.TYPE_FM_TUNER:
                    binding.type.setText("TYPE_FM_TUNER");
                    break;
                case AudioDeviceInfo.TYPE_TV_TUNER:
                    binding.type.setText("TYPE_TV_TUNER");
                    break;
                case AudioDeviceInfo.TYPE_TELEPHONY:
                    binding.type.setText("TYPE_TELEPHONY");
                    break;
                case AudioDeviceInfo.TYPE_AUX_LINE:
                    binding.type.setText("TYPE_AUX_LINE");
                    break;
                case AudioDeviceInfo.TYPE_IP:
                    binding.type.setText("TYPE_IP");
                    break;
                case AudioDeviceInfo.TYPE_BUS:
                    binding.type.setText("TYPE_BUS");
                    break;
                case AudioDeviceInfo.TYPE_USB_HEADSET:
                    binding.type.setText("TYPE_USB_HEADSET");
                    break;
                case AudioDeviceInfo.TYPE_HEARING_AID:
                    binding.type.setText("TYPE_HEARING_AID");
                    break;
            }

        }
    }
}
