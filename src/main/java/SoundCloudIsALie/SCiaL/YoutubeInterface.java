package SoundCloudIsALie.SCiaL;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;

public class YoutubeInterface {

	public String apikey;
	private final String PROPERTIES_FILENAME = "youtube.apikey";
	public YouTube api;

	
	public YoutubeInterface() {
		
		api = new YouTube.Builder(Auth.HTTP_TRANSPORT,
				Auth.JSON_FACTORY,
				new HttpRequestInitializer() {
					public void initialize(HttpRequest request) throws IOException {
					}
				}
			).setApplicationName("youtube-scial").build();
		
		getApiKey();
		
	}

	public void getApiKey(){
				
		//Load Youtube API key
		Properties properties = new Properties();
        try {
        	System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            InputStream in = new FileInputStream("./assets/"+PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }
		this.apikey = properties.getProperty("apikey");
		
	}
	
}
