import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("defaultFont", new Font("Segoe UI", Font.PLAIN, 13));
        } catch (Exception ignored) {}

        new view.Dashboard();
    }
}
