package com.Sakhii.Suraksha;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class ShakeDetector implements SensorEventListener {
    private static final float SHAKE_THRESHOLD = 12f;
    private static final int SHAKE_SLOP_TIME_MS = 500;

    private final SensorManager sensorManager;
    private final Sensor accelerometer;
    private final Runnable onShake;

    private long lastShakeTimestamp = 0;
    private int shakeCount = 0;

    public ShakeDetector(Context ctx, Runnable onShake) {
        sensorManager = (SensorManager) ctx.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.onShake = onShake;
    }

    public void start() {
        if (accelerometer != null) sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    public void stop() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        double gForce = Math.sqrt(x*x + y*y + z*z) / 9.81;
        if (gForce > SHAKE_THRESHOLD) {
            final long now = System.currentTimeMillis();
            if (lastShakeTimestamp + SHAKE_SLOP_TIME_MS > now) {
                return;
            }
            lastShakeTimestamp = now;
            shakeCount++;
            if (shakeCount >= 3) { // user requested 3 shakes
                shakeCount = 0;
                if (onShake != null) onShake.run();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}
