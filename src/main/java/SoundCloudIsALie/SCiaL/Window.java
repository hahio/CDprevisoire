package SoundCloudIsALie.SCiaL;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window
{

	public Window(Stage primaryStage) {
		
		primaryStage.setTitle("SoundCloudIsALie");
        
		Button btn = new Button();
        btn.setText("Search 'test'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                System.out.println("Results :");
                SimpleSearch.search("test");
            }
        });
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
		
	}

}
