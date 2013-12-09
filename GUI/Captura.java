import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Captura extends JFrame {
    JLabel label_1;
    JLabel label_2;
    JTextField textfield_1;
    JTextField textfield_2;
    JComboBox combobox_1;
    JLabel label_3;
    JLabel label_4;
    JLabel label_5;
    JTextField textfield_3;
    JLabel label_6;
    JTextField textfield_4;
    JLabel label_7;
    JTextField textfield_5;
    JComboBox combobox_2;
    JCheckBox checkbox_1;
    JButton button_1;
    JButton button_2;
    JLabel label_8;

    public Captura() {
        CapturaLayout customLayout = new CapturaLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("No. Orden");
        getContentPane().add(label_1);

        label_2 = new JLabel("Usuario Facultado");
        getContentPane().add(label_2);

        textfield_1 = new JTextField("");
        getContentPane().add(textfield_1);

        textfield_2 = new JTextField("");
        getContentPane().add(textfield_2);

        combobox_1 = new JComboBox();
        combobox_1.addItem("item1");
        combobox_1.addItem("item2");
        getContentPane().add(combobox_1);

        label_3 = new JLabel("Sucursal");
        getContentPane().add(label_3);

        label_4 = new JLabel("Fecha");
        getContentPane().add(label_4);

        label_5 = new JLabel("Lote");
        getContentPane().add(label_5);

        textfield_3 = new JTextField("");
        getContentPane().add(textfield_3);

        label_6 = new JLabel("No. Linea");
        getContentPane().add(label_6);

        textfield_4 = new JTextField("");
        getContentPane().add(textfield_4);

        label_7 = new JLabel("Modelo");
        getContentPane().add(label_7);

        textfield_5 = new JTextField("");
        getContentPane().add(textfield_5);

        combobox_2 = new JComboBox();
        combobox_2.addItem("item1");
        combobox_2.addItem("item2");
        getContentPane().add(combobox_2);

        checkbox_1 = new JCheckBox("checkbox_1");
        getContentPane().add(checkbox_1);

        button_1 = new JButton("Aceptar");
        getContentPane().add(button_1);

        button_2 = new JButton("Cancelar");
        getContentPane().add(button_2);

        label_8 = new JLabel("Cantidad");
        getContentPane().add(label_8);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        Captura window = new Captura();

        window.setTitle("Captura");
        window.pack();
        window.show();
    }
}

class CapturaLayout implements LayoutManager {

    public CapturaLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 527 + insets.left + insets.right;
        dim.height = 303 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+8,104,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+32,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+80,184,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+80,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+168,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+192,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+168,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+192,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+168,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+192,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+168,72,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+440,insets.top+168,72,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+256,88,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+256,88,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+168,72,24);}
    }
}
