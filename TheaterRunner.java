import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {
    
  MyStory images = new MyStory();

images.print();
  Theater.playScenes(images);

    
  }
}