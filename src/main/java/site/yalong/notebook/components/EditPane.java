package site.yalong.notebook.components;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import site.yalong.notebook.constance.GlobalConst;

/**
 * @author YaLong
 * @date 2022/4/8 18:44
 */
public class EditPane extends TextArea {
    public static ShowLabel lastShowLabel;

    public EditPane() {
        this.setMinSize(GlobalConst.WIDTH, GlobalConst.HEIGHT);
        this.setFont(GlobalConst.TEXT_FONT);
        this.setBorder(null);
        //自动换行
        this.setWrapText(true);
        this.setOpacity(0.7);
        this.setStyle("-fx-text-fill:blue;");
        this.setOnKeyReleased(event -> {
            //按F9返回查看页面
            if (event.getCode().equals(KeyCode.F9)) {
                String text = this.getText();
                lastShowLabel.setText(text);
                RootPane rootPane = (RootPane) lastShowLabel.getParent().getParent();
                rootPane.editPane.setManaged(false);
                rootPane.editPane.setVisible(false);
                rootPane.editPane.setText(null);
                for (Node child : rootPane.getChildren()) {
                    child.setVisible(true);
                }
                //关闭闪烁的光标,不然会传到显示页面里
                this.setStyle("-fx-display-caret: false;");
            }

        });
    }
}
