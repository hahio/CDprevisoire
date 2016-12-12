package SoundCloudIsALie.SCiaL;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

public class SimpleSearch
{

	static public void search(String queryTerm){
		
		try {

            YouTube.Search.List search = App.YI.api.search().list("id,snippet");

            String apiKey = App.YI.apikey;
            search.setKey(apiKey);
            search.setQ(queryTerm);


            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
            	
            	Iterator<SearchResult> searchResultListiter = searchResultList.iterator();
            	
            	if (!searchResultListiter.hasNext()) {
                    System.out.println(" There aren't any results for your query.");
                }

                while (searchResultListiter.hasNext()) {

                    SearchResult singleVideo = searchResultListiter.next();
                    ResourceId rId = singleVideo.getId();

                    // Confirm that the result represents a video. Otherwise, the
                    // item will not contain a video ID.
                    if (rId.getKind().equals("youtube#video")) {
                        Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();

                        System.out.println(" Video Id" + rId.getVideoId());
                        System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                        System.out.println(" Thumbnail: " + thumbnail.getUrl());
                        System.out.println("\n-------------------------------------------------------------\n");
                    }
                }
                
            }
            
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage() + " more details : " + e.getDetails().toString());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
		
		return;
	}

}
