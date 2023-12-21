package ch8.camera;

public abstract class Camera {
    public void takePicture() {
        System.out.println("사진을 활영합니다.");
    }
    public void recordVideo() {
        System.out.println("동영상을 녹화합니다.");
    }
    public abstract void showMainFeature();
}
