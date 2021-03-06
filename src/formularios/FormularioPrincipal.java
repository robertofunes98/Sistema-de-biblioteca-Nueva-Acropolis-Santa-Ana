/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import core.Variables;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author funes
 */
public class FormularioPrincipal extends javax.swing.JFrame {

    public static JFrame contex;
    
    /**
     * Creates new form frmFormularioPrincipal
     */
    public FormularioPrincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        contex=this;
        if(Variables.user.tipoUsuario==0)
        {
            opcAdministracion.setVisible(false);
            opcAgregarAutoresCategorias.setVisible(false);
            opcListadoAutoresCategorias.setVisible(false);
            opcAgregarAutoresCategorias.setVisible(false);
            opcAgregarLibros.setVisible(false);
        }
            
        
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        dpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opcListadoLibros = new javax.swing.JMenuItem();
        opcAgregarLibros = new javax.swing.JMenuItem();
        opcListadoAutoresCategorias = new javax.swing.JMenuItem();
        opcAgregarAutoresCategorias = new javax.swing.JMenuItem();
        opcSalir = new javax.swing.JMenuItem();
        opcAdministracion = new javax.swing.JMenu();
        opcAgregarusuario = new javax.swing.JMenuItem();
        opcConfiguracionAvanzada = new javax.swing.JMenuItem();
        opcAcercaDe = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        javax.swing.GroupLayout dpPrincipalLayout = new javax.swing.GroupLayout(dpPrincipal);
        dpPrincipal.setLayout(dpPrincipalLayout);
        dpPrincipalLayout.setHorizontalGroup(
            dpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        dpPrincipalLayout.setVerticalGroup(
            dpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        opcListadoLibros.setText("Listado de libros");
        opcListadoLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcListadoLibrosActionPerformed(evt);
            }
        });
        jMenu1.add(opcListadoLibros);

        opcAgregarLibros.setText("Agregar Libros");
        opcAgregarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAgregarLibrosActionPerformed(evt);
            }
        });
        jMenu1.add(opcAgregarLibros);

        opcListadoAutoresCategorias.setText("Listado de Autores/Categorías");
        opcListadoAutoresCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcListadoAutoresCategoriasActionPerformed(evt);
            }
        });
        jMenu1.add(opcListadoAutoresCategorias);

        opcAgregarAutoresCategorias.setText("Agregar Autores/Categorías");
        opcAgregarAutoresCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAgregarAutoresCategoriasActionPerformed(evt);
            }
        });
        jMenu1.add(opcAgregarAutoresCategorias);

        opcSalir.setText("Salir");
        opcSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcSalirActionPerformed(evt);
            }
        });
        jMenu1.add(opcSalir);

        jMenuBar1.add(jMenu1);

        opcAdministracion.setText("Administración");

        opcAgregarusuario.setText("Usuarios");
        opcAgregarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAgregarusuarioActionPerformed(evt);
            }
        });
        opcAdministracion.add(opcAgregarusuario);

        opcConfiguracionAvanzada.setText("Configuración avanzada (Precaución)");
        opcConfiguracionAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcConfiguracionAvanzadaActionPerformed(evt);
            }
        });
        opcAdministracion.add(opcConfiguracionAvanzada);

        jMenuBar1.add(opcAdministracion);

        opcAcercaDe.setText("Acerca de");
        opcAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcAcercaDeMouseClicked(evt);
            }
        });
        jMenuBar1.add(opcAcercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcListadoLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcListadoLibrosActionPerformed
        // TODO add your handling code here:
        ListadoLibros frmListadoLibros = new ListadoLibros();
        frmListadoLibros.setClosable(true);
        frmListadoLibros.setResizable(false);
        dpPrincipal.add(frmListadoLibros);
        frmListadoLibros.setVisible(true);
    }//GEN-LAST:event_opcListadoLibrosActionPerformed

    private void opcSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcSalirActionPerformed
        // TODO add your handling code here:
        int opcion=JOptionPane.showConfirmDialog(rootPane, "Realmente quiere salir?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(opcion==JOptionPane.YES_OPTION)
            this.dispose();
    }//GEN-LAST:event_opcSalirActionPerformed

    private void opcAgregarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAgregarLibrosActionPerformed
        // TODO add your handling code here:
        AgregarLibros frmAgregarLibros = new AgregarLibros();
        frmAgregarLibros.setClosable(true);
        frmAgregarLibros.setResizable(false);
        dpPrincipal.add(frmAgregarLibros);
        frmAgregarLibros.setVisible(true);
    }//GEN-LAST:event_opcAgregarLibrosActionPerformed

    private void opcAgregarAutoresCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAgregarAutoresCategoriasActionPerformed
        // TODO add your handling code here:
        AgregarAutoresCategorias frmAgregar = new AgregarAutoresCategorias();
        frmAgregar.setClosable(true);
        frmAgregar.setResizable(false);
        dpPrincipal.add(frmAgregar);
        frmAgregar.setVisible(true);
    }//GEN-LAST:event_opcAgregarAutoresCategoriasActionPerformed

    private void opcListadoAutoresCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcListadoAutoresCategoriasActionPerformed
        // TODO add your handling code here:
        ListadoAutoresCategorias frmAgregar = new ListadoAutoresCategorias();
        frmAgregar.setClosable(true);
        frmAgregar.setResizable(false);
        dpPrincipal.add(frmAgregar);
        frmAgregar.setVisible(true);
    }//GEN-LAST:event_opcListadoAutoresCategoriasActionPerformed

    private void opcAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcAcercaDeMouseClicked
        // TODO add your handling code here:
        AcercaDe frmAcercaDe = new AcercaDe();
        frmAcercaDe.setClosable(true);
        frmAcercaDe.setResizable(false);
        dpPrincipal.add(frmAcercaDe);
        frmAcercaDe.setVisible(true);
    }//GEN-LAST:event_opcAcercaDeMouseClicked

    private void opcAgregarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAgregarusuarioActionPerformed
        // TODO add your handling code here:
        FormularioAgregarusuarios frm = new FormularioAgregarusuarios();
        frm.setClosable(true);
        frm.setResizable(false);
        dpPrincipal.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_opcAgregarusuarioActionPerformed

    private void opcConfiguracionAvanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcConfiguracionAvanzadaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "<html>Cuidado. Esta funcion contiene opciones de configuración avanzadas que podrían dejar disfuncional el sistema. <br>"
                + "Es solo para usuarios con conocimientos en bases de datos y redes. Por favor pida asistencia a su administrador para <br>"
                + "manipular esta opción.","Advertencia",JOptionPane.WARNING_MESSAGE);
        FormularioConfiguracionAvanzada frm = new FormularioConfiguracionAvanzada();
        frm.setClosable(true);
        frm.setResizable(false);
        dpPrincipal.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_opcConfiguracionAvanzadaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu opcAcercaDe;
    private javax.swing.JMenu opcAdministracion;
    private javax.swing.JMenuItem opcAgregarAutoresCategorias;
    private javax.swing.JMenuItem opcAgregarLibros;
    private javax.swing.JMenuItem opcAgregarusuario;
    private javax.swing.JMenuItem opcConfiguracionAvanzada;
    private javax.swing.JMenuItem opcListadoAutoresCategorias;
    private javax.swing.JMenuItem opcListadoLibros;
    private javax.swing.JMenuItem opcSalir;
    // End of variables declaration//GEN-END:variables
}
