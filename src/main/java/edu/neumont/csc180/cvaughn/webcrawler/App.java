package edu.neumont.csc180.cvaughn.webcrawler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URI;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public void crawl()
    {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://en.wikipedia.org/wiki/Hyper_text_Transfer_Protocol"))
                .build();
            HttpResponse<String> response = HttpClient.newBuilder()
                .build().send(request, BodyHandlers.ofString());
            Pattern linkTagPattern = Pattern.compile("(?i)<a([^>]+)>(.+?)</a>");
            Matcher linkTagMatcher = linkTagPattern.matcher(response.body());
            while (linkTagMatcher.find())
            {
                System.out.println(linkTagMatcher.group());
                Pattern linkPattern = Pattern.compile("");
                Matcher linkMatcher = linkPattern.matcher(linkTagMatcher.group());
                while(linkMatcher.find())
                {
                    
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}