package ch8;

import ch8.camera.Camera;
import ch8.camera.FactoryCam;
import ch8.camera.SpeedCam;

public class _01_AbstractClass {
    public static void main(String[] args) {
        FactoryCam factoryCam = new FactoryCam();
        factoryCam.showMainFeature();

        SpeedCam speedCam = new SpeedCam();
        speedCam.showMainFeature();
    }
}
