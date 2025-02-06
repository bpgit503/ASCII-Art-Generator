import processing.core.PApplet;
import processing.core.PImage;

public class ASCIIArtGenerator extends PApplet {
    private static final String density = "Ñ@#W$9876543210?!abc;:+=-,._ ";
    private PImage photo;


    private String[] photos = {"EAM_Nuvolari_S1_640x480.jpg", "buffalo.jpg", "sheep.jpg"};


    public static void main(String[] args) {
        PApplet.main("ASCIIArtGenerator");

    }

    public void settings() {
        size(640, 480);
    }

    /**
     *To change image:
     * add file path to photo variable
     * run program
     * check console for width and hieght of photo
     * add width and height to size method in settings
     */
    public void setup() {
        photo = loadImage("EAM_Nuvolari_S1_640x480.jpg");
        if (photo == null) {
            System.out.println("Failed to load image");
            exit();
        }
        System.out.println(photo.width + "x" + photo.height);
        surface.setSize(photo.width, photo.height);
        background(0);
        photo.loadPixels();
        noLoop();
    }


    public void draw() {
        int widthSize = 8;
        textSize(widthSize);

        for (int i = 0; i < photo.width; i += widthSize) {
            for (int j = 0; j < photo.height; j += widthSize) {
                int pixelIndex = (i + j * photo.width);
                int pixelColor = photo.pixels[pixelIndex];

                int r = (int) red(pixelColor);
                int g = (int) green(pixelColor);
                int b = (int) blue(pixelColor);
                float avg = (r + g + b) / 3;

                fill(avg);
                int charIndex = (int) map(avg, 0, 255, density.length() - 1, 0);
                char asciiChar = density.charAt(charIndex);
                text(asciiChar, i, j);


            }
        }


    }
}
