package ch8.camera;

import ch8.camera.Camera;
import ch8.detector.Detectable;
import ch8.reporter.Reportable;

public class SpeedCam extends Camera implements Detectable, Reportable {
    private Detectable detectable;
    private Reportable reportable;

    public void setDetectable(Detectable detectable) {
        this.detectable = detectable;
    }

    public void setReportable(Reportable reportable) {
        this.reportable = reportable;
    }

    @Override
    public void showMainFeature() {
        System.out.println("속도 측정, 번호 인식");
    }

    public void detect() {
        detectable.detect();
    }

    public void report() {
        reportable.report();
    }
}
