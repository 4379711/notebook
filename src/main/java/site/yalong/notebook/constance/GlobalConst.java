package site.yalong.notebook.constance;

import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author YaLong
 * @date 2022/3/10 15:35
 */
public class GlobalConst {
    public static final Integer LINE_WIDTH = 400;
    public static final Integer LINE_HEIGHT = 30;
    public static final Integer WIDTH = 400;
    public static final Integer HEIGHT = 600;
    public static final Integer TEXT_WIDTH = 360;
    public static final Integer TEXT_HEIGHT = 30;
    public static final Integer BUTTON_WIDTH = 35;
    public static final Integer BUTTON_HEIGHT = 30;
    public static final String FILE_PATH = "DATA";
    public static final Font TEXT_FONT = Font.font("宋体", FontWeight.THIN, 20);
    public static final KeyCode KEY_CODE_ESC = KeyCode.ESCAPE;
    public static final String COVER_STYLE = "-fx-background-color: #ff9900;";
    public static final String SHOW_BORDER_STYLE = "-fx-border-color: grey;-fx-border-width:1px;-fx-border-radius:5px;";
    public static final String INDEX_STYLE = "-fx-text-fill: black;";
}
