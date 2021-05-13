/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import handlers.UsuarioHandler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelos.Usuario;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public final class AdminUsuarios extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();    
    
    public void CargaAutomatica() throws ClassNotFoundException{
        if (modelo.getRowCount() > 0) {
            for (int i = modelo.getRowCount() - 1; i > -1; i--) {
                modelo.removeRow(i);
            }
        }
        
        if(modelo.getColumnCount() <= 0){
            ArrayList<Object> columnas = new ArrayList<>();
            columnas.add("ID");
            columnas.add("Usuario");
            columnas.add("Clave");
            columnas.forEach((nombre) -> {
                modelo.addColumn(nombre);
            });
            this.tablaUsuarios.setModel(modelo);
        }
        
        ArrayList<Object[]> usuarios = UsuarioHandler.selectUsuario();
        
        usuarios.forEach((usuario) -> {
            modelo.addRow(usuario);
        });
        tablaUsuarios.setModel(modelo);
        this.txtregistros.setText(usuarios.size()+"");
        
        tablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if (!event.getValueIsAdjusting() &&tablaUsuarios.getSelectedRow() != -1){
                    txtID.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0).toString());
                    txtUsuario.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),1).toString());
                    btnActualizar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnAnadir.setEnabled(false);
                }
            }
        });
    }
    
    public void RestablecerCampos(){
        txtID.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        confirmarClave.setText("");
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAnadir.setEnabled(true);
    }
    
    
    /**
     * Creates new form AdminUsuarios
     * @throws java.lang.ClassNotFoundException
     */
    public AdminUsuarios() throws ClassNotFoundException {
        initComponents();
        CargaAutomatica();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtregistros = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        confirmarClave = new javax.swing.JPasswordField();
        btnAnadir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setTitle("Sistema de Control de Asistencia");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel1.setText("Cantidad de Registros: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COMPLEJO EDUCATIVO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("\"PROFESOR MARTÍN ROMEO MONTERROSA RODRÍGUEZ\"");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Administración de Usuarios");

        jLabel5.setText("Haga Clic en un registro para modificarlo o eliminarlo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nombre de Usuario: ");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña:");

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar Usuario");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar Usuario");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtClave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Repetir Contraseña:");

        confirmarClave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnAnadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAnadir.setText("Añadir Usuario");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ID:");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmarClave, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtUsuario)
                            .addComponent(txtClave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(confirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(txtregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(txtregistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // TODO add your handling code here:
        if(!txtUsuario.getText().trim().equals("") && !txtClave.getText().trim().equals("") && !confirmarClave.getText().trim().equals("")){
            if(txtClave.getText().trim().equals(confirmarClave.getText().trim())){
                Usuario nuevo = new Usuario();
                nuevo.setUsuario(txtUsuario.getText().trim());
                nuevo.setClave(txtClave.getText().trim());
                try {
                    boolean insercion = UsuarioHandler.insertUsuario(nuevo);
                    if(insercion){
                        JOptionPane.showMessageDialog(null,"Usuario insertado Correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
                        CargaAutomatica();
                        RestablecerCampos();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ocurrió Un error al insertar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe completar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if(!txtUsuario.getText().trim().equals("") && !txtClave.getText().trim().equals("") && !confirmarClave.getText().trim().equals("")){
            if(txtClave.getText().trim().equals(confirmarClave.getText().trim())){
                Usuario actualizar = new Usuario();
                actualizar.setIDUsuario(Integer.parseInt(txtID.getText().trim()));
                actualizar.setUsuario(txtUsuario.getText().trim());
                actualizar.setClave(txtClave.getText().trim());
                try {
                    boolean actualizacion = UsuarioHandler.updateUsuario(actualizar);
                    if(actualizacion){
                        JOptionPane.showMessageDialog(null,"Usuario actualizado Correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
                        CargaAutomatica();
                        RestablecerCampos();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ocurrió Un error al actualizar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe completar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea Borrar Este Usuario, Ya no tendrá acceso al sistema?","Advertencia",dialogButton,JOptionPane.WARNING_MESSAGE);
        if(dialogResult == JOptionPane.YES_OPTION){
          boolean eliminacion;
            try {
                eliminacion = UsuarioHandler.deleteUsuario(Integer.parseInt(txtID.getText().trim()));
                if(eliminacion){
                    JOptionPane.showMessageDialog(null,"Usuario eliminado Correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
                    CargaAutomatica();
                    RestablecerCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrió Un error al eliminar","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminUsuarios().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPasswordField confirmarClave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtregistros;
    // End of variables declaration//GEN-END:variables
}