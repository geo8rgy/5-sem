import java.util.ArrayList;
import java.util.List;

// Абстрактный класс для слайдов
abstract class Slide {
    public abstract void display();
}

// Текстовый слайд
class TextSlide extends Slide {
    private String text;

    public TextSlide(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("Displaying text slide: " + text);
    }
}

// Графический слайд
class GraphicSlide extends Slide {
    private String graphic;

    public GraphicSlide(String graphic) {
        this.graphic = graphic;
    }

    @Override
    public void display() {
        System.out.println("Displaying graphic slide: " + graphic);
    }
}

// Видео слайд
class VideoSlide extends Slide {
    private String video;

    public VideoSlide(String video) {
        this.video = video;
    }

    @Override
    public void display() {
        System.out.println("Displaying video slide: " + video);
    }
}

// Абстрактная фабрика для создания слайдов
interface SlideFactory {
    Slide createSlide(String content);
}

// Фабрика для создания текстовых слайдов
class TextSlideFactory implements SlideFactory {
    @Override
    public Slide createSlide(String content) {
        return new TextSlide(content);
    }
}

// Фабрика для создания графических слайдов
class GraphicSlideFactory implements SlideFactory {
    @Override
    public Slide createSlide(String content) {
        return new GraphicSlide(content);
    }
}

// Фабрика для создания видео слайдов
class VideoSlideFactory implements SlideFactory {
    @Override
    public Slide createSlide(String content) {
        return new VideoSlide(content);
    }
}

// Класс для управления презентацией
class Presentation {
    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public void displayPresentation() {
        for (Slide slide : slides) {
            slide.display();
        }
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        SlideFactory textSlideFactory = new TextSlideFactory();
        SlideFactory graphicSlideFactory = new GraphicSlideFactory();
        SlideFactory videoSlideFactory = new VideoSlideFactory();

        Presentation presentation = new Presentation();

        presentation.addSlide(textSlideFactory.createSlide("Welcome to the presentation"));
        presentation.addSlide(graphicSlideFactory.createSlide("Graphic 1"));
        presentation.addSlide(videoSlideFactory.createSlide("Video 1"));

        presentation.displayPresentation();
    }
}
     
