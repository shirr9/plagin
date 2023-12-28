import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.jetbrains.annotations.NotNull;
public class Plagin1 extends AnAction{
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        String selectedText = editor.getSelectionModel().getSelectedText();
        String encoded = "";
        try {
            encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = String.format("https://www.google.ru/search?q=%s", encoded);
        BrowserUtil.browse(url);
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}