/**
* Using JavaFX to display Latin words translated into English
* 10/16/2024
* CSC 251  - The Latin Translator Problem
* @author Benjamin Walker
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/**
 * Latin Translator
 */

public class LatinTranslator extends Application {
    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Create the buttons.
        Button sinisterButton = new Button("Sinister");
        Button dexterButton = new Button("Dexter");
        Button mediumButton = new Button("Medium");
        
        // Create the output label.
        Label outputLabel = new Label();
        
        // Register event handlers for the buttons.
        sinisterButton.setOnAction(e -> {
            outputLabel.setText("Left");
        });
        
        dexterButton.setOnAction(e -> {
            outputLabel.setText("Right");
        });
        
        mediumButton.setOnAction(e -> {
            outputLabel.setText("Center");
        });
        
        // Put the controls in a VBox.
        VBox vbox = new VBox(10, sinisterButton, dexterButton, mediumButton, 
                             outputLabel);
        
        // Set the VBox's alignment to center.
        vbox.setAlignment(Pos.CENTER);
        
        // Set the VBox's padding to 10 pixels.
        vbox.setPadding(new Insets(10));
        
        // Add the VBox to a scene.
        Scene scene = new Scene(vbox);
        
        // Set the scene to the stage and display it.
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
