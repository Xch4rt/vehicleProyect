/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.views.panels;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import rsbuttom.RSButtonMetro;

/**
 *
 * @author Pablo
 */
public class PnlVehicleShowInfo extends javax.swing.JPanel {

    /**
     * Creates new form PnlVehicleShowInfo
     */
    public PnlVehicleShowInfo() {
        initComponents();
    }

    public JComboBox<String> getCmbSearch() {
        return CmbSearch;
    }

    public void setCmbSearch(JComboBox<String> CmbSearch) {
        this.CmbSearch = CmbSearch;
    }

    public JTable getTableInfo() {
        return TableInfo;
    }

    public void setTableInfo(JTable TableInfo) {
        this.TableInfo = TableInfo;
    }

    public RSButtonMetro getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(RSButtonMetro btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JTextField getjTextFieldSearch() {
        return jTextFieldSearch;
    }

    public void setjTextFieldSearch(JTextField jTextFieldSearch) {
        this.jTextFieldSearch = jTextFieldSearch;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        CmbSearch = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        btnSearch = new rsbuttom.RSButtonMetro();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        TableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Year", "Make", "Model", "Style", "VIN", "Exterior color", "Interior color", "MIles", "Price", "Transmission", "Engine"
            }
        ));
        TableInfo.setRowHeight(30);
        jScrollPane1.setViewportView(TableInfo);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        CmbSearch.setBackground(new java.awt.Color(204, 204, 204));
        CmbSearch.setForeground(new java.awt.Color(204, 204, 204));

        jTextFieldSearch.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldSearch.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldSearch.setText("¿Qué desea buscar?");
        jTextFieldSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.setColorHover(new java.awt.Color(153, 153, 153));
        btnSearch.setColorNormal(new java.awt.Color(204, 204, 204));
        btnSearch.setColorPressed(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(CmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbSearch;
    private javax.swing.JTable TableInfo;
    private rsbuttom.RSButtonMetro btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
