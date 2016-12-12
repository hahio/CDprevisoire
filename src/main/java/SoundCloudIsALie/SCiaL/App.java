package SoundCloudIsALie.SCiaL;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{

	static YoutubeInterface YI;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		YI = new YoutubeInterface();
		Window w = new Window(primaryStage);
		
	}
    
}
