import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Consultas extends JFrame {
    JComboBox combobox_1;
    JLabel label_3;
    JLabel label_4;
    JComboBox combobox_2;
    JButton button_1;
    JButton button_2;

    public Consultas() {
        ConsultasLayout customLayout = new ConsultasLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        combobox_1 = new JComboBox();
        combobox_1.addItem("item1");
        combobox_1.addItem("item2");
        getContentPane().add(combobox_1);

        label_3 = new JLabel("Consulta");
        getContentPane().add(label_3);

        label_4 = new JLabel("Historial");
        getContentPane().add(label_4);

        combobox_2 = new JComboBox();
        combobox_2.addItem("item1");
        combobox_2.addItem("item2");
        getContentPane().add(combobox_2);

        button_1 = new JButton("Aceptar");
        getContentPane().add(button_1);

        button_2 = new JButton("Cancelar");
        getContentPane().add(button_2);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        Consultas window = new Consultas();

        window.setTitle("Consultas");
        window.pack();
        window.show();
    }
}

class ConsultasLayout implements LayoutManager {

    public ConsultasLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 322 + insets.left + insets.right;
        dim.height = 233 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+16,144,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+16,88,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+96,88,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+96,144,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+184,96,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+184,96,24);}
    }
}
