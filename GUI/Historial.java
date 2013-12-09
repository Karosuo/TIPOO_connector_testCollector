import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Historial extends JFrame {
    JComboBox combobox_1;
    JLabel label_1;
    JComboBox combobox_2;
    JScrollPane scrollpane_5;
    JLabel label_2;
    JButton button_1;

    public Historial() {
        HistorialLayout customLayout = new HistorialLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        combobox_1 = new JComboBox();
        combobox_1.addItem("Consultas");
        getContentPane().add(combobox_1);

        label_1 = new JLabel("Ventanas que desplegara");
        getContentPane().add(label_1);

        combobox_2 = new JComboBox();
        combobox_2.addItem("fecha");
        combobox_2.addItem("Orden compra");
        combobox_2.addItem("num remision");
        getContentPane().add(combobox_2);

        scrollpane_5 = new JScrollPane();
        getContentPane().add(scrollpane_5);

        label_2 = new JLabel("generacion del Historial");
        getContentPane().add(label_2);

        button_1 = new JButton("aceptar");
        getContentPane().add(button_1);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        Historial window = new Historial();

        window.setTitle("Historial");
        window.pack();
        window.show();
    }
}

class HistorialLayout implements LayoutManager {

    public HistorialLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 434 + insets.left + insets.right;
        dim.height = 290 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+56,136,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,192,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,136,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+48,168,184);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+8,176,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+240,88,24);}
    }
}
