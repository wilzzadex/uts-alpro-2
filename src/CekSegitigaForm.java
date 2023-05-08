import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CekSegitigaForm extends  JFrame{
        private JLabel labelSisi1, labelSisi2, labelSisi3, labelHasil;
        private JTextField sisi1Field, sisi2Field, sisi3Field;
        private JButton cekButton;

    private JPanel panel1;


    public  CekSegitigaForm() {

            labelSisi1 = new JLabel("Sisi 1");
            labelSisi2 = new JLabel("Sisi 2");
            labelSisi3 = new JLabel("Sisi 3");
            labelHasil = new JLabel("Hasil");
            sisi1Field = new JTextField(20);
            sisi2Field = new JTextField(20);
            sisi3Field = new JTextField(20);
            cekButton = new JButton("Cek");

            JPanel panel = new JPanel();
            panel.add(labelSisi1);
            panel.add(sisi1Field);
            panel.add(labelSisi2);
            panel.add(sisi2Field);
            panel.add(labelSisi3);
            panel.add(sisi3Field);
            panel.add(labelHasil);
            panel.add(cekButton);


            add(panel);
            setTitle("Jenis Segitiga");
            setSize(400, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            cekButton.addActionListener(e -> {
                int sisi1 = Integer.parseInt(sisi1Field.getText());
                int sisi2 = Integer.parseInt(sisi2Field.getText());
                int sisi3 = Integer.parseInt(sisi3Field.getText());

                Segitiga segitiga = new Segitiga(sisi1, sisi2, sisi3);
                labelHasil.setText(segitiga.getJenisSegigita());
            });

        }
    }

class Segitiga extends SegitigaAbstrak {
    public Segitiga(int sisi1, int sisi2, int sisi3) {
        super(sisi1, sisi2, sisi3);
    }

    @Override
    boolean isSegitigaSamaSisi() {
        return (getSisi1() == getSisi2() && getSisi2() == getSisi3());
    }

    @Override
    boolean isSegitiaSamaKaki() {
        return (getSisi1() == getSisi2() || getSisi2() == getSisi3() || getSisi1() == getSisi3());
    }

    @Override
    boolean isSegitiaSikuSiku() {
        int sisiTerpanjang = Math.max(Math.max(getSisi1(), getSisi2()), getSisi3());
        return (Math.pow(sisiTerpanjang, 2) == Math.pow(getSisi1(), 2) + Math.pow(getSisi2(), 2) + Math.pow(getSisi3(), 2) - Math.pow(sisiTerpanjang, 2));
    }
}
