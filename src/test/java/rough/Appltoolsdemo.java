package rough;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class Appltoolsdemo {
	

		  public void main(String[] args) throws IOException {

		        Eyes eyes = new Eyes();

		        // Initialize the eyes SDK and set your private API key.
		        eyes.setApiKey("YOUR_API_KEY");

		        // Define the OS and hosting application to identify the baseline.
		        eyes.setHostOS("Windows 10");
		        eyes.setHostApp("My maxthon browser");

		        BufferedImage img;

		        try {

		            // Start the test with a viewport size of 800x600.
		         //   eyes.open("Applitools site", "Java Screenshot test!","demo" ,new RectangleSize(800, 600));

		            // Load page image and validate.
		            img = ImageIO.read(new URL("https://applitools.com/blog/wp-content/uploads/2013/11/app-is-live-nov-2013.png"));

		            // Visual validation.
		         //   eyes.checkImage(img, "Contact-us page");

		            // End visual UI testing.
		            eyes.close();

		        } finally {

		            // If the test was aborted before eyes.close was called, ends the test as aborted.
		            eyes.abortIfNotClosed();

		        }
		  }

}
