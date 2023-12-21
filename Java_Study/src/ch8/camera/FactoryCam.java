package ch8.camera;

import ch8.camera.Camera;
import ch8.detector.Detectable;
import ch8.reporter.Reportable;

public class FactoryCam extends Camera implements Detectable, Reportable {

    private Detectable detector; // 객체 생성
    private Reportable reporter;

    public void setDetector(Detectable detector) { // setter
        this.detector = detector;
    }

    public void setReporter(Reportable reporter) {
        this.reporter = reporter;
    }

    @Override
    public void showMainFeature() {
        System.out.println("화재 감지");
    }

    @Override
    public void detect() {
        detector.detect();
    }

    @Override
    public void report() {
        reporter.report();
    }

}
