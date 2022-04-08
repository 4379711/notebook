package site.yalong.notebook;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import site.yalong.notebook.components.RootPane;

/**
 * @author YaLong
 * @date 2022/3/21 14:21
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("肥肥仔专用笔记本");
        Scene scene = new Scene(new RootPane());
        scene.setFill(null);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
