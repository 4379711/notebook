package site.yalong.notebook.components;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import site.yalong.notebook.constance.GlobalConst;


/**
 * @author YaLong
 * @date 2022/3/10 15:43
 */
public class ChoiceMenu extends ContextMenu {

    public ChoiceMenu(ShowLabel showLabel) {
        ObservableList<MenuItem> items = this.getItems();
        MenuItem addLine = new MenuItem("添加");
        MenuItem coverColor = new MenuItem("标记");
        MenuItem deleteLine = new MenuItem("删除");
        items.addAll(addLine, coverColor, deleteLine);

        addLine.setOnAction(e -> {
            LineBox lineBoxNow = (LineBox) showLabel.getParent();
            RootPane rootPane = (RootPane) lineBoxNow.getParent();
            ObservableList<Node> lines = rootPane.getChildren();
            // 当前行的位置
            int nowLineNumber = lines.indexOf(lineBoxNow);
            LineBox lineBox = LineBox.builder(nowLineNumber + 1);
            lines.add(nowLineNumber + 1, lineBox);
            // 这个位置以后的每一行序号重新赋值
            for (int i = nowLineNumber; i < lines.size(); i++) {
                LineBox tmp = (LineBox) lines.get(i);
                IndexLabel node = (IndexLabel) tmp.getChildren().get(0);
                node.setIndex(String.valueOf(i));
            }
            //鼠标焦点放在新增的输入框内
            ShowLabel newPane = (ShowLabel) lineBox.getChildren().get(1);
            newPane.requestFocus();
        });

        coverColor.setOnAction(e -> {
            LineBox lineBoxNow = (LineBox) showLabel.getParent();
            ShowLabel indexLabel = (ShowLabel) lineBoxNow.getChildren().get(1);
            MenuItem menuItem = this.getItems().get(1);
            MenuItem source = (MenuItem) e.getSource();
            if ("标记".equals(source.getText())) {
                indexLabel.setStyle(GlobalConst.SHOW_BORDER_STYLE + GlobalConst.COVER_STYLE);
                menuItem.setText("恢复");
            } else {
                indexLabel.setStyle(GlobalConst.SHOW_BORDER_STYLE + "-fx-text-fill:rgb(0,0,0);");
                menuItem.setText("标记");
            }
        });

        deleteLine.setOnAction(e -> {
            LineBox lineBoxNow = (LineBox) showLabel.getParent();
            RootPane rootPane = (RootPane) lineBoxNow.getParent();
            ObservableList<Node> lines = rootPane.getChildren();
            if (lines.size() <= 1) {
                return;
            }
            // 当前行的位置
            int nowLineNumber = lines.indexOf(lineBoxNow);
            lines.remove(lineBoxNow);

            // 这个位置以后的每一行序号重新赋值
            for (int i = nowLineNumber; i < lines.size(); i++) {
                LineBox lineBox = (LineBox) lines.get(i);
                ((IndexLabel) lineBox.getChildren().get(0)).setIndex(String.valueOf(i));
            }
            //鼠标焦点放在最后一行的输入框内
            lines.get(lines.size() - 1).requestFocus();
        });
    }

}
