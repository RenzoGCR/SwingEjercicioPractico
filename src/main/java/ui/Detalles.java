package ui;

import context.ContextService;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Detalles extends JDialog{
    private JLabel lblCorreo;
    private JLabel lblPais;
    private JLabel lblPlataforma;
    private JButton btnVolver;
    private JPanel contentPane;

    public Detalles(JFrame parent) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnVolver);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        Usuario usuario = (Usuario) ContextService.getInstance().getItem("usuarioSeleccionado").get();

        setTitle(usuario.getCorreo());
        lblCorreo.setText(usuario.getCorreo());
        lblPais.setText(usuario.getPais());
        lblPlataforma.setText(usuario.getPlataforma());

        btnVolver.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {onOK();}
        });


    }
    private void onOK() {
        dispose();
    }
}
