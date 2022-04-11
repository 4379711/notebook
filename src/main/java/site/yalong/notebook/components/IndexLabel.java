package site.yalong.notebook.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import site.yalong.notebook.constance.GlobalConst;

/**
 * @author YaLong
 * @date 2022/4/8 17:50
 */
public class IndexLabel extends Label {
    public IndexLabel() {
        this.setMinSize(GlobalConst.BUTTON_WIDTH, GlobalConst.BUTTON_HEIGHT);
        this.setMaxSize(GlobalConst.BUTTON_WIDTH, GlobalConst.BUTTON_HEIGHT);
        this.setPrefSize(GlobalConst.BUTTON_WIDTH, GlobalConst.BUTTON_HEIGHT);
        this.setBorder(null);
        this.setFocused(false);
        this.setFocusTraversable(false);
        this.setAlignment(Pos.CENTER);
        this.setFont(GlobalConst.TEXT_FONT);
        this.setStyle(GlobalConst.INDEX_STYLE);
    }

    public void setIndex(String value) {
        this.setText(value + ". ");
    }
}
