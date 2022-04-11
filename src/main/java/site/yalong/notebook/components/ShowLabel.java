package site.yalong.notebook.components;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import site.yalong.notebook.constance.GlobalConst;

import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;


/**
 * @author YaLong
 * @date 2022/3/10 15:39
 */
public class ShowLabel extends Label {

    public ShowLabel(String text) {
        super(text);
        this.setMinSize(GlobalConst.TEXT_WIDTH, GlobalConst.TEXT_HEIGHT);
        this.setMaxWidth(GlobalConst.TEXT_WIDTH);
        this.setFont(GlobalConst.TEXT_FONT);
        //添加边框
        this.setStyle(GlobalConst.SHOW_BORDER_STYLE);
        //自动换行
        this.setWrapText(true);
        this.setContextMenu(new ChoiceMenu(this));
        this.setEventHandler(MOUSE_RELEASED, event -> {
            MouseButton button = event.getButton();
            //点击左键
            if (button == MouseButton.PRIMARY) {
                EditPane.lastShowLabel = this;
                LineBox lineBoxNow = (LineBox) this.getParent();
                RootPane rootPane = (RootPane) lineBoxNow.getParent();
                for (Node child : rootPane.getChildren()) {
                    child.setVisible(false);
                }
                //开启闪烁的光标
                rootPane.editPane.setStyle("-fx-display-caret: true;");
                rootPane.editPane.setManaged(true);
                rootPane.editPane.setVisible(true);
                rootPane.editPane.setText(this.getText());
                rootPane.editPane.setDisable(false);
            }
        });

    }

}
