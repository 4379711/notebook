package site.yalong.notebook.components;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import site.yalong.notebook.constance.GlobalConst;
import site.yalong.notebook.utils.FileUtil;

import java.util.ArrayList;

import static site.yalong.notebook.constance.GlobalConst.FILE_PATH;

/**
 * @author YaLong
 * @date 2022/3/10 15:28
 */
public class RootPane extends VBox {
    public EditPane editPane = new EditPane();

    public RootPane() {
        this.setMinSize(GlobalConst.WIDTH, GlobalConst.HEIGHT);
        BackgroundImage bg = new BackgroundImage(
                new Image("bg.jpg", GlobalConst.WIDTH + 10,
                        GlobalConst.HEIGHT + 10, true, true),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(bg));
        this.getChildren().add(editPane);
        editPane.setVisible(false);
        editPane.setManaged(false);
        loadData();
        this.setFocused(false);
    }

    public void loadData() {
        ArrayList<String> list = FileUtil.readFile(FILE_PATH);
        ObservableList<Node> nodes = this.getChildren();
        if (list.isEmpty()) {
            //添加一行空的
            nodes.add(LineBox.builder(nodes.size()));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            LineBox builder = LineBox.builder(i + 1, s);
            nodes.add(builder);
        }
    }


}
