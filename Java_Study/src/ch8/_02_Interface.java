package ch8;

import ch8.camera.FactoryCam;
import ch8.detector.AdvancedFireDetector;
import ch8.detector.Detectable;
import ch8.detector.FireDetector;
import ch8.reporter.NormalReporter;
import ch8.reporter.VideoReporter;

public class _02_Interface {
    public static void main(String[] args) {
        NormalReporter normalReporter = new NormalReporter();
        normalReporter.report();

        VideoReporter videoReporter = new VideoReporter();
        videoReporter.report();

        System.out.println("-------------------------");

        Detectable fireDetector = new FireDetector();
        fireDetector.detect();

        Detectable advancedFireDetector = new AdvancedFireDetector();
        advancedFireDetector.detect();

        System.out.println("-------------------------");

        FactoryCam factoryCam = new FactoryCam();
        factoryCam.setDetector(advancedFireDetector);
        factoryCam.setReporter(videoReporter);

        factoryCam.detect();
        factoryCam.report();
    }
}
