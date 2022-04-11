package site.yalong.notebook.components;

import javafx.scene.control.TextArea;
import site.yalong.notebook.constance.GlobalConst;
import site.yalong.notebook.utils.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

import static site.yalong.notebook.constance.GlobalConst.FILE_PATH;

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
            //按ESC返回查看页面
            if (event.getCode().equals(GlobalConst.KEY_CODE_ESC)) {
                String text = this.getText();
                lastShowLabel.setText(text);
                this.setManaged(false);
                this.setVisible(false);
                this.setText(null);
                this.setDisable(true);
                //关闭闪烁的光标,不然会传到显示页面里
                this.setStyle("-fx-display-caret: false;");
                RootPane rootPane = (RootPane) lastShowLabel.getParent().getParent();
                //rootPane.getChildren()包含了lineBox和EditPane
                List<String> collect = rootPane.getChildren().stream()
                        .filter(node -> node instanceof LineBox)
                        .map(lineBox -> {
                            ShowLabel showLabel = (ShowLabel) ((LineBox) lineBox).getChildren().get(1);
                            //显示内容
                            lineBox.setVisible(true);
                            return showLabel.getText();
                        })
                        .collect(Collectors.toList());
                FileUtil.writeFile(FILE_PATH, collect);


            }

        });
    }
}
