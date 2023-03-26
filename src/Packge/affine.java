package Packge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class affine extends JFrame {
    private JLabel enter_text;
    private JLabel key;
    private JLabel keys_a;
    private JLabel keys_b;
    private JTextField input_text;
    private JTextField receive_text;
    private JTextField input_keys_a;
    private JTextField input_keys_b;
    private JButton enc_button;
    private JButton dec_button;
    private JLabel ans;
    private JPanel panel;
    public affine(){
        super("Affine Cipher");
        panel = new JPanel();
        panel.setLayout(null);
        enter_text = new JLabel("Enter Plain Text / Cipher Text");
        input_text = new JTextField();
        key = new JLabel("Keys:");
        keys_a = new JLabel("A: ");
        input_keys_a = new JTextField();
        keys_b = new JLabel("B: ");
        input_keys_b = new JTextField();
        enc_button = new JButton("Encrypt");
        dec_button = new JButton("Decrypt");
        ans = new JLabel();
        receive_text = new JTextField();
        receive_text.setEditable(false);
        enter_text.setBounds(155, 80, 200, 20);
        input_text.setBounds(140,110,200,20);
        key.setBounds(155,140,200,20);
        keys_a.setBounds(200,140,200,20);
        input_keys_a.setBounds(215,140,40,20);
        keys_b.setBounds(260,140,200,20);
        input_keys_b.setBounds(275,140,40,20);
        dec_button.setBounds(30,300,80,20);
        enc_button.setBounds(380,300,80,20);
        ans.setBounds(70,250,200,20);
        receive_text.setBounds(140,250,200,20);
        //encryption
        enc_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String cipher = "";
                try {

                    int a = Integer.parseInt(input_keys_a.getText());

                    int y = 26, gcd = 1;

                    for (int i = 1; i <= a && i <= y; i++) {

                        if (a % i == 0 && y % i == 0)

                            gcd = i;
                    }
                    if (gcd != 1)
                        JOptionPane.showMessageDialog(null, "The GCD between " + a + " and " + y + " are not equal 1", "Error message", JOptionPane.ERROR_MESSAGE);
                    int b = Integer.parseInt(input_keys_b.getText());
                    String plain_text = input_text.getText().toUpperCase();
                    char[] msg = plain_text.toCharArray();
                    for (int i = 0; i < msg.length; i++) {
                        if (gcd != 1)
                            break;
                        if (msg[i] != ' ') {
                            cipher = cipher + (char) ((((a * (msg[i] - 'A')) + b) % 26) + 'A');
                        } else {
                            cipher += msg[i];
                        }
                    }
                    ans.setText("ciphertext:");
                    receive_text.setText(cipher);
                }catch (InputMismatchException | NumberFormatException i){
                    JOptionPane.showMessageDialog(null,"Enter an integer numbers for a & b","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dec_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                try{
                String cipher = input_text.getText().toUpperCase();
                String msg = "";
                int a_inv = 0;
                int a = Integer.parseInt(input_keys_a.getText());
                int b = Integer.parseInt(input_keys_b.getText());
                for(int i=0;i<26;i++)
                {
                    a_inv=i;
                    if((a*i)%26==1)
                        break;
                }
                for (int i = 0; i < cipher.length(); i++)
                {
                    if (cipher.charAt(i) != ' ')
                    {
                        msg = msg + (char) (((a_inv *
                                ((cipher.charAt(i) + 'A' - b)) % 26)) + 'A');
                    }
                    else
                    {
                        msg += cipher.charAt(i);
                    }
                }
                ans.setText("Plaintext:");
                receive_text.setText(msg);

            }catch (InputMismatchException | NumberFormatException i){
                JOptionPane.showMessageDialog(null,"Enter an integer numbers a & b","Error",JOptionPane.ERROR_MESSAGE);
            }
            }
        });

        panel.add(enter_text);
        panel.add(input_text);
        panel.add(key);
        panel.add(keys_a);
        panel.add(input_keys_a);
        panel.add(keys_b);
        panel.add(input_keys_b);
        panel.add(dec_button);
        panel.add(enc_button);
        panel.add(ans);
        panel.add(receive_text);
        add(panel);
    }
}

