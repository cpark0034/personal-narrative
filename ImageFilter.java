import org.code.media.Pixel;
import org.code.media.Color;  // Make sure to import the Color class
public class ImageFilter extends ImagePlus {

  
  
  public ImageFilter(String filename) {
        super(filename);
}
//
  //
  //this method takes all of one color away from an image
  //it is the first method i call
  //
  
 public void zeroRed() {
    // 0. Get the 2D array of pixels
    Pixel[][] pixels = getImagePixels();
    
//for statement that goes through array
   for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
//gets current pixel
        Pixel currentPixel = pixels[row][col];
      
//mow it sets green to 0
        currentPixel.setRed(0);
      }
    }
 }
//
  //
  //this is the second filter I use
  //it makes the image pixelated
  //
 public void pixelate(int gridSize) {
    int numRows = getHeight();  
    int numCols = getWidth();   //get width and height
    
//uses a parameter to determine how it should go through the pic
    
    for (int rowStart = 0; rowStart < numRows; rowStart += gridSize) {
        for (int colStart = 0; colStart < numCols; colStart += gridSize) {
            // Determine the end row and column for the current block
            int rowEnd = Math.min(rowStart + gridSize, numRows);
        int colEnd = Math.min(colStart + gridSize, numCols);
      
            int redSum = 0;
          int greenSum = 0; 
          int blueSum = 0;
            int pixelCount = 0;          
          //rowstart finds the start of the image area, row end is the end of the area
          for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); 
                    redSum += pixel.getRed();        
                    greenSum += pixel.getGreen();     
                    blueSum += pixel.getBlue();      
                    pixelCount++;                     //adds another count
                }
            }
            
            int avgRed = redSum / pixelCount;
        int avgGreen = greenSum / pixelCount;//divides the area colors by pixel count, which is how many there are
          int avgBlue = blueSum / pixelCount;
            
//now sets the area to be the avg color
          for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); // Get the Pixel object at (row, col)
            
             pixel.setRed(avgRed);             
             pixel.setGreen(avgGreen);     
                pixel.setBlue(avgBlue);           
         }
      }
   }
}
}


//
  //This is the third one I used
  //sets a threshold
  //this determines if each pixel is black or white
  //

  
  public void threshold(int value) {
    Pixel[][] imagePixels = getImagePixels(); 

    // Traverse the 2D array of pixels
    for (int row = 0; row < getHeight(); row++) {
        for (int col = 0; col < getWidth(); col++) {
            // Get the current pixel
            Pixel currentPixel = imagePixels[row][col];

//gets the value for current pixel
          int red = currentPixel.getRed();
            int green = currentPixel.getGreen();
            int blue = currentPixel.getBlue();

//finds the greyscale
          int avgRGB = (red + green + blue) / 3;

//if less set to black
          if (avgRGB < value) {
                currentPixel.setRed(0);
                currentPixel.setGreen(0);
                currentPixel.setBlue(0);
            } else {
//else set to white
                currentPixel.setRed(255);
                currentPixel.setGreen(255);
                currentPixel.setBlue(255);
            }
        }
    }
}

//
//this is the last filter I used, which is themotion blur filter
  //
public void motionBlur(int length, String direction) {
    Pixel[][] imagePixels = getImagePixels();  
  //thats the array

//for statement to go through array
  for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        int redTotal = 0, greenTotal = 0, blueTotal = 0;
        int count = 0;

//gets the left and right
        for (int i = 0; i < length; i++) {
          int newX = x;
          int newY = y;

//changes based on direction
          if (direction.equals("horizontal")) {
            newX = x + i;
          } else if (direction.equals("vertical")) {
            newY = y + i;
          } else if (direction.equals("diagonal")) {
            newX = x + i;
            newY = y + i;
          }

          if (newX >= 0 && newX < getWidth() && newY >= 0 && newY < getHeight()) {
            Pixel currentPixel = imagePixels[newY][newX];
            redTotal += currentPixel.getRed();
            greenTotal += currentPixel.getGreen();
            blueTotal += currentPixel.getBlue();
            count++;
          }
        }

//finds avg colors of pixels nearby
        int avgRed = redTotal / count;
        int avgGreen = greenTotal / count;
        int avgBlue = blueTotal / count;

//new color object
        Color avgColor = new Color(avgRed, avgGreen, avgBlue);

        setPixel(x, y, avgColor);  
      }
    }
  }









}