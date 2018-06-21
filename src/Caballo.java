/**
 *
 * @author Ivan
 */
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Caballo extends JFrame implements ItemListener {
    private JLabel horses;
    private JCheckBox chkHorse1;
    private AudioClip horse1;
    private JCheckBox chkHorse2;
    private AudioClip horse2;
    private JCheckBox chkHorse3;
    private AudioClip horse3;
    private JCheckBox chkHorse4;
    private AudioClip horse4;
    private JPanel pnlCheckBox;

    /** Creates a new instance of Main */
    public Caballo() {
        setLayout(new BorderLayout());
        pnlCheckBox = new JPanel(new GridLayout(2,2));

        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imaHorses = tk.getImage(Caballo.class.getResource("horses.png"));

        horses = new JLabel();
        horses.setIcon(new ImageIcon(imaHorses));
        getContentPane().add(horses, BorderLayout.CENTER);


        horse1 = JApplet.newAudioClip(Caballo.class.getResource("horse1.wav"));
        horse2 = JApplet.newAudioClip(Caballo.class.getResource("horse2.wav"));
        horse3 = JApplet.newAudioClip(Caballo.class.getResource("horse3.wav"));
        horse4 = JApplet.newAudioClip(Caballo.class.getResource("horse4.wav"));

        chkHorse1 = new JCheckBox("Caballo 1");
        chkHorse1.setIcon(new ImageIcon(Caballo.class.getResource("horse1.png")));
        chkHorse1.setSelectedIcon(new ImageIcon(
                Caballo.class.getResource("horse1-selected.png")));

        chkHorse1.addItemListener(this);
        pnlCheckBox.add(chkHorse1);

        chkHorse2 = new JCheckBox("Caballo 2");
        chkHorse2.setIcon(new ImageIcon(Caballo.class.getResource("horse2.png")));
        chkHorse2.setSelectedIcon(new ImageIcon(
                Caballo.class.getResource("horse2-selected.png")));
        chkHorse2.addItemListener(this);
        pnlCheckBox.add(chkHorse2);

        chkHorse3 = new JCheckBox("Caballo 3");
        chkHorse3.setIcon(new ImageIcon(Caballo.class.getResource("horse3.png")));
        chkHorse3.setSelectedIcon(new ImageIcon(
                Caballo.class.getResource("horse3-selected.png")));
        chkHorse3.addItemListener(this);
        pnlCheckBox.add(chkHorse3);

        chkHorse4 = new JCheckBox("Caballo 4");
        chkHorse4.setIcon(new ImageIcon(Caballo.class.getResource("horse4.png")));
        chkHorse4.setSelectedIcon(new ImageIcon(
                Caballo.class.getResource("horse4-selected.png")));
        chkHorse4.addItemListener(this);
        pnlCheckBox.add(chkHorse4);

        getContentPane().add(pnlCheckBox, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Viruz Blog: Caballos Cantadores");
        setSize(800,587);
        setResizable(false);

        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        boolean isSelected;
        /**
         * Con el metodo getStateChange() del ItemEvent que recibe el metodo
         * puedo saber si el JCheckBox fue seleccionado o fue deseleccionado,
         * dependiendo de esto puedo manejar el evento de maneras diferentes.
         */
        isSelected = (e.getStateChange() == ItemEvent.SELECTED);
        /**
         * Del mismo modo que getSource() nos devuelve el componente que realizo
         * el evento en actionPerformed(), getItemSelectable() nos devuelve el
         * componente que realizo el evento en itemStateChanged()
         */
        if (e.getItemSelectable() == chkHorse1) {
            if (isSelected)
                horse1.loop();
            else
                horse1.stop();
        } else if (e.getItemSelectable() == chkHorse2) {
            if (isSelected)
                horse2.loop();
            else
                horse2.stop();
        } else if (e.getItemSelectable() == chkHorse3) {
            if (isSelected)
                horse3.loop();
            else
                horse3.stop();
        } else if (e.getItemSelectable() == chkHorse4) {
            if (isSelected) {
                horse4.loop();
            } else {
                horse4.stop();
            }
        }
    }
}