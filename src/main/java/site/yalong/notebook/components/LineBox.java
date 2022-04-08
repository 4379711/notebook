package site.yalong.notebook.components;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import site.yalong.notebook.constance.GlobalConst;
import site.yalong.notebook.utils.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

import static site.yalong.notebook.constance.GlobalConst.FILE_PATH;

/**
 * @author YaLong
 * @date 2022/3/10 15:37
 */
public class LineBox extends HBox {
    public LineBox() {
        this.setMinSize(GlobalConst.LINE_WIDTH, GlobalConst.LINE_HEIGHT);
        this.setOnKeyReleased(e -> {
            //按F9保存
            if (e.getCode() == KeyCode.F9) {
                //获取所有的行
                ObservableList<Node> lines = this.getParent().getChildrenUnmodifiable();
                List<String> collect = lines.stream()
                        .map(i -> ((ShowLabel) ((LineBox) i).getChildren().get(1)).getText())
                        .collect(Collectors.toList());
                FileUtil.writeFile(FILE_PATH, collect);
            }

        });
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
