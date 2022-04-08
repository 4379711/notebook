package site.yalong.notebook.components;

import javafx.scene.control.Label;
import site.yalong.notebook.constance.GlobalConst;

/**
 * @author YaLong
 * @date 2022/4/8 17:50
 */
public class IndexLabel extends Label {
    public IndexLabel() {
        super();
        this.setBorder(null);
        this.setFocused(false);
        this.setFocusTraversable(false);
        this.setFont(GlobalConst.TEXT_FONT);
        this.setStyle("-fx-text-fill:pink;");
    }

    public void setIndex(String value) {
        this.setText(value + ". ");
    }
}
