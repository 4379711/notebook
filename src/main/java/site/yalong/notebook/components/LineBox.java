package site.yalong.notebook.components;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import site.yalong.notebook.constance.GlobalConst;

/**
 * @author YaLong
 * @date 2022/3/10 15:37
 */
public class LineBox extends HBox {
    public LineBox() {
        this.setMinSize(GlobalConst.LINE_WIDTH, GlobalConst.LINE_HEIGHT);
    }

    public static LineBox builder(int lineNumber, String text) {
        LineBox lineBox = new LineBox();
        ShowLabel showLabel = new ShowLabel(text);
        IndexLabel indexLabel = new IndexLabel();
        indexLabel.setIndex(String.valueOf(lineNumber));
        ObservableList<Node> children = lineBox.getChildren();
        children.add(indexLabel);
        children.add(showLabel);
        return lineBox;
    }

    public static LineBox builder(int lineNumber) {
        return builder(lineNumber, null);
    }
}
