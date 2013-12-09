import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Consulta extends JFrame {
    JComboBox combobox_1;
    JLabel label_1;
    JComboBox combobox_2;
    JTextField textfield_1;
    JScrollPane scrollpane_5;
    JLabel label_2;
    JButton button_1;
    JButton button_2;

    public Consulta() {
        ConsultaLayout customLayout = new ConsultaLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        combobox_1 = new JComboBox();
        combobox_1.addItem("tipos de consulta");
        combobox_1.addItem("item2");
        getContentPane().add(combobox_1);

        label_1 = new JLabel("Ventanas que desplegara");
        getContentPane().add(label_1);

        combobox_2 = new JComboBox();
        combobox_2.addItem("de donde se hara la consulta");
        combobox_2.addItem("item2");
        getContentPane().add(combobox_2);

        textfield_1 = new JTextField("consulta especifica");
        getContentPane().add(textfield_1);

        scrollpane_5 = new JScrollPane();
        getContentPane().add(scrollpane_5);

        label_2 = new JLabel("reporte de la captura");
        getContentPane().add(label_2);

        button_1 = new JButton("aceptar");
        getContentPane().add(button_1);

        button_2 = new JButton("cancelar");
        getContentPane().add(button_2);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        Consulta window = new Consulta();

        window.setTitle("Consulta");
        window.pack();
        window.show();
    }
}

class ConsultaLayout implements LayoutManager {

    public ConsultaLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 434 + insets.left + insets.right;
        dim.height = 314 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,136,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,136,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+176,136,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+48,168,184);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+8,168,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+240,88,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+240,80,24);}
    }
}
