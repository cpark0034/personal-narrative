import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {
   private String[][] Byes = {
        {"Bye Bye!", "Adios", "Later"},
        {"Take care", "Thanks", "Adieu"},
     {"Farewell", "GoodBye", "안녕"}
     
    };

  
  //
  //this filter uses a 2d array
  //its goal is to determine what saying will finish my project
  //it will take a random row and random column
  //
  public void Bye() {
        int row = (int) (Math.random() * Byes.length);  // Random row index 
        int col = (int) (Math.random() * Byes[row].length);  // Random column index 

        //Print the color 
      
      clear("white");
      drawText(Byes[row][col], 150, 150);
    }

public void print(){
clear("white");

ImageFilter Dog = new ImageFilter("DogPhoto.jpg");
ImageFilter Chipotle = new ImageFilter("FoodPhoto.jpg");
ImageFilter BF = new ImageFilter("BoyfriendPhoto.jpg");
ImageFilter Shop = new ImageFilter("shoppingPhoto.jpg");
 setTextHeight(25);//sets the text size
drawText("Here are 4 of my favorite things!", 25, 128);//first line
pause(3.0);
  clear("white");
  playSound("bark.wav");//the sound I used is dogs barking
  pause(0.3);
    playSound("bark.wav");//i did 2 of them because it was short

   drawImage(Dog, 0, 0, 400);
pause(1.5);
 Dog.zeroRed();//first image filter removes the red
 drawImage(Dog, 0, 0, 400);
pause(2.5);

 drawImage(Chipotle, 0, 0, 400);
pause(1.5);
 Chipotle.pixelate(10);//second image filter makes it piexelated
 drawImage(Chipotle, 0, 0, 400);
pause(2.5);


   drawImage(BF, 0, 0, 400);
pause(1.5);
 BF.threshold(100);//third image filter gives it a threshold
 drawImage(BF, 0, 0, 400);
pause(2.5);



     drawImage(Shop, 0, 0, 400);
pause(1.5);
 Shop.motionBlur(50, "vertical");//fourth image filter gives it a threshold
 drawImage(Shop, 0, 0, 400);
pause(2.5);


//this uses my 2d array to say goodbye

Bye();
}

}

    