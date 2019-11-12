/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import core.ConexionDB;
import core.Variables;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author funes
 */
public class ListadoLibros extends javax.swing.JInternalFrame {
    
    ConexionDB conexion;
    DefaultTableModel modeloLibros;
    int tipoBusqueda = 0;//0=no buscar, 1=por id, 2=por nombre, 3=por autor, 4=por categoria
    LinkedList<LinkedList<String>> alAutores, alCategorias, alLibros;


    /**
     * Creates new form ListadoLibros
     */
    public ListadoLibros() {
        initComponents();
        
        try{
            conexion=new ConexionDB(Variables.rutaDB, Variables.userDB, Variables.claveDB);
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            JOptionPane.showInternalMessageDialog(rootPane, "Error en la conexion a la base de datos. Contacte a su administrador", "Error",JOptionPane.ERROR_MESSAGE);
        }
        
        if(Variables.user.tipoUsuario==1)
        {
            modeloLibros=(DefaultTableModel) tblLibros.getModel();
            
            modeloLibros.addColumn("Precio");
        
            tblLibros.getColumnModel().getColumn(0).setPreferredWidth(65);
            tblLibros.getColumnModel().getColumn(1).setPreferredWidth(360);
            tblLibros.getColumnModel().getColumn(2).setPreferredWidth(163);
            tblLibros.getColumnModel().getColumn(3).setPreferredWidth(75);
            tblLibros.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblLibros.getColumnModel().getColumn(5).setPreferredWidth(55);
        }
        else
        {
            modeloLibros=(DefaultTableModel) tblLibros.getModel();
        
            tblLibros.getColumnModel().getColumn(0).setPreferredWidth(65);
            tblLibros.getColumnModel().getColumn(1).setPreferredWidth(415);
            tblLibros.getColumnModel().getColumn(2).setPreferredWidth(163);
            tblLibros.getColumnModel().getColumn(3).setPreferredWidth(75);
            tblLibros.getColumnModel().getColumn(4).setPreferredWidth(60);
        }
        
        
        
        cargarTabla();
        
        ocultarBuscadores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminarLibro = new javax.swing.JButton();
        btnModificarLibro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfBuscador = new javax.swing.JTextField();
        cbBuscarPor = new javax.swing.JComboBox<>();
        cbBuscador = new javax.swing.JComboBox<>();
        btnModificarLibro1 = new javax.swing.JButton();

        btnEliminarLibro.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basura_32x32.png"))); // NOI18N
        btnEliminarLibro.setText("Eliminar libro");
        btnEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibroActionPerformed(evt);
            }
        });

        btnModificarLibro.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modificar_32x32.png"))); // NOI18N
        btnModificarLibro.setText("Modificar libro");
        btnModificarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLibroActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(75, 108, 141));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Libros");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/libros_32x32.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/libros_32x32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(100, 133, 166));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblLibros.setBorder(new javax.swing.border.MatteBorder(null));
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID libro", "Nombre", "Autor", "Categoria", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLibros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblLibros.setRowHeight(32);
        tblLibros.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblLibros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblLibrosFocusLost(evt);
            }
        });
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibros);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar_16x16.png"))); // NOI18N
        jLabel2.setText("Buscar por:");

        tfBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscadorKeyTyped(evt);
            }
        });

        cbBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No buscar", "id libro", "nombre", "autor", "categoria" }));
        cbBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscarPorItemStateChanged(evt);
            }
        });

        cbBuscador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscadorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfBuscador)
                    .addComponent(cbBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btnModificarLibro1.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarLibro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print_32_32.png"))); // NOI18N
        btnModificarLibro1.setText("Imprimir reporte");
        btnModificarLibro1.setName("btnImprimirReporte"); // NOI18N
        btnModificarLibro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLibro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminarLibro)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarLibro1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarLibro)
                    .addComponent(btnEliminarLibro)
                    .addComponent(btnModificarLibro1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscarPorItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            switch(cbBuscarPor.getSelectedIndex())
            {
                case 0:
                    cargarTabla();
                    ocultarBuscadores();
                    tipoBusqueda=0;
                    break;
                case 1:
                    ocultarBuscadores();
                    tfBuscador.setVisible(true);
                    tipoBusqueda=1;
                    break;
                case 2:
                    ocultarBuscadores();
                    tfBuscador.setVisible(true);
                    tipoBusqueda=2;
                    break;
                case 3:
                    ocultarBuscadores();
                    cbBuscador.setVisible(true);
                    cargarAutores();
                    tipoBusqueda=3;
                    break;
                case 4:
                    ocultarBuscadores();
                    cbBuscador.setVisible(true);
                    cargarCategorias();
                    tipoBusqueda=4;
                    break;
            }
            SwingUtilities.updateComponentTreeUI(this);
        }
    }//GEN-LAST:event_cbBuscarPorItemStateChanged

    private void tfBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscadorKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfBuscadorKeyTyped

    private void tfBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscadorKeyReleased
        // TODO add your handling code here:
        switch(tipoBusqueda)
        {
            case 1:
                buscarPorId(tfBuscador.getText());
                break;
            case 2:
                buscarPorNombre(tfBuscador.getText());
                break;
        }
    }//GEN-LAST:event_tfBuscadorKeyReleased

    private void cbBuscadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscadorItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            switch(tipoBusqueda)
            {
                case 3:
                    buscarPorAutor(Integer.parseInt(alAutores.get(cbBuscador.getSelectedIndex()).get(0)));
                    break;
                case 4:
                    buscarPorCategoria(Integer.parseInt(alCategorias.get(cbBuscador.getSelectedIndex()).get(0)));
            }
            
        }
    }//GEN-LAST:event_cbBuscadorItemStateChanged

    private void tblLibrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblLibrosFocusLost
        // TODO add your handling code he
    }//GEN-LAST:event_tblLibrosFocusLost

    private void tblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblLibrosMouseClicked

    private void btnEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroActionPerformed
        // TODO add your handling code here:
        
        if (tblLibros.getSelectedRows().length > 0) {
            JPanel pnlAdvertencia = new JPanel();

            JLabel lblAdvertencia = new JLabel();

            lblAdvertencia.setText("¿Esta seguro que desea eliminar el libro?\n Esta accion no se puede deshacer");

            lblAdvertencia.setForeground(Color.red);

            pnlAdvertencia.add(lblAdvertencia);

            int dialogResult = JOptionPane.showConfirmDialog(rootPane, pnlAdvertencia, "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    conexion.ejecutarComando("delete from libro where id_libro = '" + modeloLibros.getValueAt(tblLibros.getSelectedRow(), 0) + "'");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "error: " + e);
                }
                cargarTabla();
            }

        }else{
            JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningún registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarLibroActionPerformed

    private void btnModificarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLibroActionPerformed
        // TODO add your handling code here:
        if (tblLibros.getSelectedRows().length > 0) {
            ModificarLibroDialog jDialog = new ModificarLibroDialog(FormularioPrincipal.contex, true, modeloLibros.getValueAt(tblLibros.getSelectedRow(), 0).toString(),
                    modeloLibros.getValueAt(tblLibros.getSelectedRow(), 1).toString(),
                    Integer.parseInt(modeloLibros.getValueAt(tblLibros.getSelectedRow(), 4).toString()),
                    alLibros.get(tblLibros.getSelectedRow()).get(5), alLibros.get(tblLibros.getSelectedRow()).get(6));
            jDialog.setLocationRelativeTo(this);
            jDialog.setVisible(true);

            jDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarTabla();
                }
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningún registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarLibroActionPerformed

    private void btnModificarLibro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLibro1ActionPerformed
        // TODO add your handling code here:
        final String URL = "src\\reportes\\reporte_libros.jrxml";
        /*try{
            JasperPrint jasperPrint = JasperFillManager.fillReport(URL, null,conexion.conexion);
           

            //JRPdfExporter exp = new JRPdfExporter();

            //JRXlsExporter exp = new JRXlsExporter();
            
            JRXlsxExporter exp= new JRXlsxExporter();

            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            
            
            File archivoElegido=new File("");
            JFileChooser fc = new JFileChooser();
            //Mostrar la ventana para abrir archivo y recoger la respuesta
            //En el parámetro del showOpenDialog se indica la ventana
            //  al que estará asociado. Con el valor this se asocia a la
            //  ventana que la abre.
            int respuesta = fc.showOpenDialog(this);
            //Comprobar si se ha pulsado Aceptar
            if (respuesta == JFileChooser.APPROVE_OPTION) {
                //Crear un objeto File con el archivo elegido
                archivoElegido = fc.getSelectedFile();
            }

            exp.setExporterOutput(new SimpleOutputStreamExporterOutput(archivoElegido.getAbsolutePath()+".xlsx"));


            SimpleXlsxExporterConfiguration conf = new SimpleXlsxExporterConfiguration();

            //SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();

            exp.setConfiguration(conf);
        
            exp.exportReport();
            
            JOptionPane.showConfirmDialog(rootPane, "El reporte fue impreso en "+archivoElegido.getAbsolutePath()+".xlsx");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, "Error: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }*/
        
        
        try {
            //Crear el mapa de parametros
            Map<String,Object> parameters = new HashMap<String,Object>();

            parameters.put("logo_na","src\\reportes\\");
            InputStream reportStream = new FileInputStream(URL);//new FileInputStream("reporte.jrxml");

            //Iniciar reporte
            JasperReport report = JasperCompileManager.compileReport(reportStream);
            JasperPrint jasperPrint = new JasperPrint();

            //Llenar el reporte donde se le pasa en el tercer argumento el mapa ya creado
            JasperFillManager.fillReportToFile(report, "src/reportes/reporte.jrprint", (Map<String,Object>)parameters,conexion.conexion);
            
            reportStream.close();

            jasperPrint=(JasperPrint)JRLoader.loadObjectFromFile("src/reportes/reporte.jrprint");
            

            //Generar PDF
            /*List listJasper = new ArrayList();
            listJasper.add(JRLoader.loadObjectFromFile("src/reportes/reporte.jrprint"));
            JRPdfExporter exp = new JRPdfExporter();
            exp.setParameter(JRExporterParameter.JASPER_PRINT_LIST, listJasper);
            exp.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
            exp.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "src/reportes/reporte.pdf");
            exp.exportReport();
            */
            
            //generar xlsx
            JRXlsxExporter exp= new JRXlsxExporter();

            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            
            
            File archivoElegido=new File("");
            JFileChooser fc = new JFileChooser();
            //Mostrar la ventana para abrir archivo y recoger la respuesta
            //En el parámetro del showOpenDialog se indica la ventana
            //  al que estará asociado. Con el valor this se asocia a la
            //  ventana que la abre.
            int respuesta = fc.showOpenDialog(this);
            //Comprobar si se ha pulsado Aceptar
            if (respuesta == JFileChooser.APPROVE_OPTION) {
                //Crear un objeto File con el archivo elegido
                archivoElegido = fc.getSelectedFile();
            }

            exp.setExporterOutput(new SimpleOutputStreamExporterOutput(archivoElegido.getAbsolutePath()+".xlsx"));


            SimpleXlsxExporterConfiguration conf = new SimpleXlsxExporterConfiguration();

            //SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();

            exp.setConfiguration(conf);
        
            exp.exportReport();
            
            JOptionPane.showMessageDialog(rootPane, "El reporte fue impreso en "+archivoElegido.getAbsolutePath()+".xlsx");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnModificarLibro1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarLibro;
    private javax.swing.JButton btnModificarLibro;
    private javax.swing.JButton btnModificarLibro1;
    private javax.swing.JComboBox<String> cbBuscador;
    private javax.swing.JComboBox<String> cbBuscarPor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField tfBuscador;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        limpiarTabla();
        try{
            ResultSet rsResultado=conexion.ejecutar("select libro.id_libro, libro.nombre, autor.nombre, categoria.nombre, libro.cantidad, autor.id_autor, categoria.id_categoria, libro.precio from libro inner join autor on autor.id_autor = libro.id_autor INNER JOIN categoria on categoria.id_categoria = libro.id_categoria");

            alLibros=conexion.convertirRsToArrayList(rsResultado);

            for(LinkedList<String> aux : alLibros)
            {
                if(Variables.user.tipoUsuario==1)
                    modeloLibros.addRow(new String[] {aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(4),"$"+aux.get(7)});
                else
                    modeloLibros.addRow(new String[] {aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(4)});
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }

    private void ocultarBuscadores() {
        tfBuscador.setVisible(false);
        cbBuscador.setVisible(false);
    }
    
    

    private void buscarPorNombre(String nombre) {
        try{
            ResultSet rsResultado=conexion.ejecutar("select libro.id_libro, libro.nombre, autor.nombre, categoria.nombre, libro.cantidad "
                    + "from libro inner join autor on autor.id_autor = libro.id_autor INNER JOIN categoria on "
                    + "categoria.id_categoria = libro.id_categoria where libro.nombre LIKE '"+nombre+"%'");

            LinkedList<LinkedList<String>> alResultados=conexion.convertirRsToArrayList(rsResultado);
            
            limpiarTabla();

            for(LinkedList<String> aux : alResultados)
            {
                modeloLibros.addRow(aux.toArray());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }

    private void limpiarTabla() {
        modeloLibros.setRowCount(0);
    }

    private void buscarPorId(String idLibro) {
        try{
            ResultSet rsResultado=conexion.ejecutar("select libro.id_libro, libro.nombre, autor.nombre, categoria.nombre, libro.cantidad "
                    + "from libro inner join autor on autor.id_autor = libro.id_autor INNER JOIN categoria on "
                    + "categoria.id_categoria = libro.id_categoria where libro.id_libro LIKE '"+idLibro+"%'");

            LinkedList<LinkedList<String>> alResultados=conexion.convertirRsToArrayList(rsResultado);
            
            limpiarTabla();

            for(LinkedList<String> aux : alResultados)
            {
                modeloLibros.addRow(aux.toArray());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }

    private void cargarAutores() {
        try{
            ResultSet rsResultado=conexion.ejecutar("select * from autor ORDER BY nombre ASC");

            alAutores=conexion.convertirRsToArrayList(rsResultado);
            
            cbBuscador.removeAllItems();

            for(LinkedList<String> aux : alAutores)
            {
                cbBuscador.addItem(aux.get(1));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }

    private void buscarPorAutor(int idAutor) {
        try{
            ResultSet rsResultado=conexion.ejecutar("select libro.id_libro, libro.nombre, autor.nombre, categoria.nombre, libro.cantidad "
                    + "from libro inner join autor on autor.id_autor = libro.id_autor INNER JOIN categoria on "
                    + "categoria.id_categoria = libro.id_categoria where libro.id_autor ="+idAutor);

            LinkedList<LinkedList<String>> alResultados=conexion.convertirRsToArrayList(rsResultado);
            
            limpiarTabla();

            for(LinkedList<String> aux : alResultados)
            {
                modeloLibros.addRow(aux.toArray());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }

    private void cargarCategorias() {
        try{
            ResultSet rsResultado=conexion.ejecutar("select * from categoria ORDER BY nombre ASC");

            alCategorias=conexion.convertirRsToArrayList(rsResultado);
            
            cbBuscador.removeAllItems();

            for(LinkedList<String> aux : alCategorias)
            {
                cbBuscador.addItem(aux.get(1));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }

    private void buscarPorCategoria(int idcategoria) {
        try{
            ResultSet rsResultado=conexion.ejecutar("select libro.id_libro, libro.nombre, autor.nombre, categoria.nombre, libro.cantidad "
                    + "from libro inner join autor on autor.id_autor = libro.id_autor INNER JOIN categoria on "
                    + "categoria.id_categoria = libro.id_categoria where libro.id_categoria ="+idcategoria);

            LinkedList<LinkedList<String>> alResultados=conexion.convertirRsToArrayList(rsResultado);
            
            limpiarTabla();

            for(LinkedList<String> aux : alResultados)
            {
                modeloLibros.addRow(aux.toArray());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "error: "+e);
        }
    }
}
