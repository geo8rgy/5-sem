// Абстракция для камеры
abstract class Camera {
    protected VideoRecorder videoRecorder;

    public Camera(VideoRecorder videoRecorder) {
        this.videoRecorder = videoRecorder;
    }

    public abstract void takePhoto();
    public abstract void recordVideo();
}

// Реализация для фронтальной камеры
class FrontCamera extends Camera {
    public FrontCamera(VideoRecorder videoRecorder) {
        super(videoRecorder);
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking photo with front camera");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording video with front camera");
        videoRecorder.record();
    }
}

// Реализация для задней камеры
class RearCamera extends Camera {
    public RearCamera(VideoRecorder videoRecorder) {
        super(videoRecorder);
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking photo with rear camera");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording video with rear camera");
        videoRecorder.record();
    }
}

// Реализация для 3D-камеры
class ThreeDCamera extends Camera {
    public ThreeDCamera(VideoRecorder videoRecorder) {
        super(videoRecorder);
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking 3D photo");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording 3D video");
        videoRecorder.record();
    }
}

// Интерфейс для видеозаписи
interface VideoRecorder {
    void record();
}

// Реализация для видеозаписи в формате MP4
class MP4VideoRecorder implements VideoRecorder {
    @Override
    public void record() {
        System.out.println("Recording video in MP4 format");
    }
}

// Реализация для видеозаписи в формате AVI
class AVIVideoRecorder implements VideoRecorder {
    @Override
    public void record() {
        System.out.println("Recording video in AVI format");
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        VideoRecorder mp4Recorder = new MP4VideoRecorder();
        VideoRecorder aviRecorder = new AVIVideoRecorder();

        Camera frontCamera = new FrontCamera(mp4Recorder);
        Camera rearCamera = new RearCamera(aviRecorder);
        Camera threeDCamera = new ThreeDCamera(mp4Recorder);

        frontCamera.takePhoto();
        frontCamera.recordVideo();

        rearCamera.takePhoto();
        rearCamera.recordVideo();

        threeDCamera.takePhoto();
        threeDCamera.recordVideo();
    }
}
