package ui;



import context.ContextService;
import model.FileUserService;
import model.UserService;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Main extends javax.swing.JFrame {
    private JTable table1;
    private JPanel panel1;

    private UserService userservice;

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Main(UserService us) {
        userservice = us;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrador de Usuarios");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);

        var modelo = new DefaultTableModel();
        modelo.addColumn("Correo");
        modelo.addColumn("Pais");
        modelo.addColumn("Plataforma");
        table1.setModel(modelo);

        //crear metodo
        loadDataTable();

        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table1.getSelectionModel().addListSelectionListener( (e)->{
                    if(!e.getValueIsAdjusting() && table1.getSelectedRow()>=0 ){
                        System.out.println("seleccionado: "+table1.getSelectedRow());
                        Usuario usuario = usuarios.get(table1.getSelectedRow());

                        // AppContext.juegoSeleccionado = juego;
                        ContextService.getInstance().addItem("usuarioSeleccionado", usuario);

                        (new Detalles(this)).setVisible(true);
                    }
                }
        );
    }
}
