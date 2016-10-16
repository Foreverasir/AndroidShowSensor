package com.example.gzf.showsensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //检查设备
    StringBuffer str;
    Sensor s;
    TextView show;
    List<Sensor> allSensors;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        allSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        show = (TextView) findViewById(R.id.show);
    }

    //用于检测设备传感器
    public void onClick(View v) {
        str = new StringBuffer();
        str.append("该手机有" + allSensors.size() + "个传感器,分别是:\n");
        for (int i = 0; i < allSensors.size(); i++) {
            s = allSensors.get(i);
            str.append("\n设备名称:" + s.getName() + "\n");
            str.append("设备版本:" + s.getVersion() + "\n");
            str.append("通用类型号:" + s.getType() + "\n");
            str.append("设备商名称:" + s.getVendor() + "\n");
            str.append("传感器功耗:" + s.getPower() + "\n");
            str.append("传感器分辨率:" + s.getResolution() + "\n");
            str.append("传感器最大量程:" + s.getMaximumRange() + "\n");
            switch (s.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    str.append(i + ". 加速度传感器\n");
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    str.append(i + ". 线性加速度传感器\n");
                    break;
                case Sensor.TYPE_ORIENTATION:
                    str.append(i + ". 方向传感器（已不建议）\n");
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    str.append(i + ". 陀螺仪传感器\n");
                    break;
                case Sensor.TYPE_LIGHT:
                    str.append(i + ". 环境光线传感器\n");
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    str.append(i + ". 电磁场传感器\n");
                    break;
                case Sensor.TYPE_GRAVITY:
                    str.append(i + ". 重力传感器\n");
                    break;
                case Sensor.TYPE_PRESSURE:
                    str.append(i + ". 压力传感器\n");
                    break;
                case Sensor.TYPE_PROXIMITY:
                    str.append(i + ". 距离传感器\n");
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    str.append(i + ". 温度传感器（已淘汰）\n");
                    break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    str.append(i + ". 环境温度传感器\n");
                    break;
                case Sensor.TYPE_RELATIVE_HUMIDITY:
                    str.append(i + ". 环境湿度传感器\n");
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    str.append(i + ". 旋转矢量传感器\n");
                    break;
                case Sensor.TYPE_HEART_BEAT:
                    str.append(i + ". 心跳传感器\n");
                    break;
                case Sensor.TYPE_HEART_RATE:
                    str.append(i + ". 心率传感器\n");
                    break;
                case Sensor.TYPE_STEP_COUNTER:
                    str.append(i + ". 计步传感器\n");
                    break;
                default:
                    str.append(i + ". 其余特定传感器\n");
                    break;
            }
        }
        show.setText(str);
    }
}
