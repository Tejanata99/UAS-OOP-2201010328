package e.serviceee;

import static e.serviceee.koneksii.getKoneksi;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tejanata-2201010328
 */
public class Jform extends javax.swing.JFrame {

   
    DefaultTableModel TM = new DefaultTableModel();

    public Jform() throws SQLException  {
        initComponents();
        eservice_tbl.setModel(TM);
        TM.addColumn("id_cust");
        TM.addColumn("customer");
        TM.addColumn("motor");
        TM.addColumn("dk");
        TM.addColumn("keluhan");
        TM.addColumn("tgl");
        TM.addColumn("status");
        
        this.setTitle("SISTEM INPUT SERVICE KENDARAAN ONLINE");
        ImageIcon ii = new ImageIcon("img/");
        this.setIconImage(ii.getImage());
        
        List_all();
        kosongkanform();
        loadphoto("");
    }
    
    private void loadphoto(String idx){
        String nopic = "src/img/nopic.jpg";
        String img = "src/img/"+idx+".jpg";

        BufferedImage phototeman = loadimg.loadImage(img);
        if (phototeman == null) {
            phototeman = loadimg.loadImage(nopic);
        }
        ImageIcon iconphoto = new ImageIcon(phototeman);
        photo.setIcon(iconphoto);
    }
    
    private void List_all () throws SQLException {
        
        TM.getDataVector().removeAllElements();       
        TM.fireTableDataChanged();
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
            
            String sql = "SELECT * FROM customer";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
                
                String id_cust = rs.getString("id_cust");
                String customer = rs.getString("customer");
                String motor = rs.getString("motor");
                String dk = rs.getString("dk");
                String keluhan = rs.getString("keluhan");
                String tanggal = rs.getString("tgl");
                String status = rs.getString("status");
        
                Object[] dta = new Object[7];
                dta [0] = id_cust;
                dta [1] = customer;
                dta [2] = motor;
                dta [3] = dk;
                dta [4] = keluhan;
                dta [5] = tanggal;
                dta [6] = status;
                TM.addRow(dta);
                
                txid.setText(id_cust);
                
            }
           
        }
        
    }
    
    private  void storeData() throws SQLException{
        Connection cnn = getKoneksi();
        String customer = txcustomer.getText();
        String motor = txmotor.getText();
        String dk = txdk.getText();
        String keluhan = txkeluhan.getText();
        String tanggal = txtanggal.getText();
        String status = txstatus.getText();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "INSERT INTO customer(customer,motor,dk,keluhan,tgl,status) VALUES (?,?,?,?,?,?);");
            PS.setString(1, customer);
            PS.setString(2 ,motor);
            PS.setString(3, dk);
            PS.setString(4, keluhan);
            PS.setString(5, tanggal);
            PS.setString(6, status);
            PS.executeUpdate();
        }

    }
    
    private void updateData() throws SQLException {
        Connection cnn = getKoneksi();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "UPDATE customer SET customer=?,motor=?,dk=?,keluhan=?,tgl=?,status=? WHERE id_cust =?;");
            PS.setString(1, txcustomer.getText());
            PS.setString(2, txmotor.getText());
            PS.setString(3 ,txdk.getText());
            PS.setString(4 ,txkeluhan.getText());
            PS.setString(5 ,txtanggal.getText());
            PS.setString(6 ,txstatus.getText());
            PS.setString(7 ,txid.getText());
            PS.executeUpdate();
            cnn.close();
        }
        
    }
    
    private void destroyData() throws SQLException {
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
        
            PreparedStatement PS = cnn.prepareStatement(
            "DELETE FROM customer WHERE id_cust =?;");
            PS.setString(1, txid.getText());
            PS.executeUpdate();
            cnn.close();
        }

    }
    
    private void kosongkanform(){
        
        txcustomer.setText("");
        txmotor.setText("");
        txdk.setText("");
        txtanggal.setText("");
        txkeluhan.setText("");
        txstatus.setText("");
    }
    
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnhapus = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btninput = new javax.swing.JButton();
        btntutup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eservice_tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txcustomer = new javax.swing.JTextField();
        txmotor = new javax.swing.JTextField();
        txdk = new javax.swing.JTextField();
        txstatus = new javax.swing.JTextField();
        txkeluhan = new javax.swing.JTextField();
        txtanggal = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btninput.setText("INPUT");
        btninput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninputActionPerformed(evt);
            }
        });

        btntutup.setText("TUTUP");
        btntutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntutupActionPerformed(evt);
            }
        });

        jLabel1.setText("SISTEM INPUT SERVICE MOTOR");

        eservice_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_cust", "customer", "motor", "dk", "keluhan", "tanggal", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        eservice_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eservice_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eservice_tbl);

        jLabel2.setText("id_cust");

        txid.setText("jTextField1");

        jLabel3.setText("customer");

        jLabel4.setText("motor");

        jLabel5.setText("dk");

        jLabel6.setText("keluhan");

        jLabel7.setText("tanggal");

        jLabel8.setText("status");

        txcustomer.setText("jTextField1");

        txmotor.setText("jTextField1");

        txdk.setText("jTextField1");

        txstatus.setText("jTextField1");

        txkeluhan.setText("jTextField1");

        txtanggal.setText("jTextField1");

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txkeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txdk, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnhapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txmotor, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(184, 184, 184)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btntutup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btninput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btninput))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txdk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txkeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntutup))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninputActionPerformed
        if(btninput.getText().equals("Input")){
        btninput.setText("Simpan");
        btntutup.setText("Batal");
        kosongkanform();
        eservice_tbl.setEnabled(false);
        }else{
            btninput.setText("Input");
            btntutup.setText("Tutup Form");
            eservice_tbl.setEnabled(true);
            try {
                storeData(); 
                List_all();
            } catch (SQLException ex) {
                Logger.getLogger(Jform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btninputActionPerformed

    private void eservice_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eservice_tblMouseClicked
        txid.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),0).toString());
        txcustomer.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),1).toString());
        txmotor.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),2).toString());
        txdk.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),3).toString());
        txkeluhan.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),4).toString());
        txtanggal.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),1).toString());
        txstatus.setText(eservice_tbl.getValueAt( eservice_tbl.getSelectedRow(),2).toString());
        loadphoto(txid.getText());
    }//GEN-LAST:event_eservice_tblMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if(btnupdate.getText().equals("update")){
        btnupdate.setText("Simpan");
        btntutup.setText("Batal");
        }else{
            btnupdate.setText("update");
            btntutup.setText("Tutup Form");
        try {
                updateData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah diupdate");
            } catch (SQLException ex) {
                Logger.getLogger(Jform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        int jwb = JOptionPane.showOptionDialog(
                this, 
                "Apakah anda yakin akan menghapus data dengan nim : "+ txid.getText() + "?" , 
                "Hapus data", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null, 
                null, 
                null);
        if(jwb == JOptionPane.YES_OPTION){
           try {
            destroyData();
            List_all();
            JOptionPane.showMessageDialog(this, "Data telah dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(Jform.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntutupActionPerformed
        if(btntutup.getText().equals("Tutup Form")){
            dispose();
        }else{
            btntutup.setText("Tutup Form");
            btninput.setText("Input");
        }
    }//GEN-LAST:event_btntutupActionPerformed

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
            java.util.logging.Logger.getLogger(Jform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Jform().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Jform.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btninput;
    private javax.swing.JButton btntutup;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTable eservice_tbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField txcustomer;
    private javax.swing.JTextField txdk;
    private javax.swing.JTextField txid;
    private javax.swing.JTextField txkeluhan;
    private javax.swing.JTextField txmotor;
    private javax.swing.JTextField txstatus;
    private javax.swing.JTextField txtanggal;
    // End of variables declaration//GEN-END:variables



}