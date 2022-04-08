package site.yalong.notebook.components;

import javafx.scene.control.Label;
import site.yalong.notebook.constance.GlobalConst;


/**
 * @author YaLong
 * @date 2022/3/10 15:39
 */
public class ShowLabel extends Label {

    public ShowLabel(String text) {
        super(text);
        this.setMinSize(GlobalConst.TEXT_WIDTH, GlobalConst.TEXT_HEIGHT);
        this.setFont(GlobalConst.TEXT_FONT);
        this.setBorder(null);
        //自动换行
        this.setWrapText(true);
        this.setContextMenu(new ChoiceMenu(this));
    }

}
