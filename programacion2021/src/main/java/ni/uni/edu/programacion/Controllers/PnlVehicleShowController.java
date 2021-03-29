/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.uni.edu.programacion.views.panels.PnlVehicleShowInfo;

/**
 *
 * @author Pablo
 */
public class PnlVehicleShowController {
    private PnlVehicleShowInfo pnlVShowInfo;
    // para el cmbList
    private final String PROPIERTIES[] = new String[]{"RECORDS","STOCK","YEAR", "MAKE", "MODEL", "STYLE", "VIN", "EXTERIOR COLOR", "INTERIOR COLOR", "MILES", "PRICE", "TRANSMISSION", "ENGINE",
    "IMAGE","STATUS"};
    private DefaultComboBoxModel<String> cmbFmodel;
    private DefaultTableModel model;
    
    private Gson gson;
    private JsonVehicleDaoImpl jvdao;
    private List<VehicleSubModel> vehicleSubModels;
    
    
    public PnlVehicleShowController(PnlVehicleShowInfo pnlVShowInfo) {
        this.pnlVShowInfo = pnlVShowInfo;
        try {
            initComponent();
        } catch (IOException ex) {
            Logger.getLogger(PnlVehicleShowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initComponent() throws FileNotFoundException, IOException 
    {
       
        jvdao = new JsonVehicleDaoImpl();
        if(jvdao.getAll().isEmpty()){
            return;
        }
        
        String matriz[][]= new String[jvdao.getAll().size()][15];
        
        for(int i=0;i<jvdao.getAll().size();i++){
            matriz[i][0]= Integer.toString(jvdao.getAll().get(i).getRecords());
            matriz[i][1]= Integer.toString(jvdao.getAll().get(i).getStockNumber());
            matriz[i][2]= Integer.toString(jvdao.getAll().get(i).getYear());
            matriz[i][3]= jvdao.getAll().get(i).getMake();
            matriz[i][4]=jvdao.getAll().get(i).getModel();
            matriz[i][5]=jvdao.getAll().get(i).getStyle();
            matriz[i][6]=jvdao.getAll().get(i).getVin();
            matriz[i][7]=jvdao.getAll().get(i).getExteriorColor();
            matriz[i][8]=jvdao.getAll().get(i).getInteriorColor();
            matriz[i][9]=jvdao.getAll().get(i).getMiles();
            matriz[i][10]=Float.toString(jvdao.getAll().get(i).getPrice());
            matriz[i][11]=jvdao.getAll().get(i).getTransmission().toString();
            matriz[i][12]=jvdao.getAll().get(i).getEngine();
            matriz[i][13]=jvdao.getAll().get(i).getImage();
            matriz[i][14]=jvdao.getAll().get(i).getStatus();
            
            
        }
        
        model= new DefaultTableModel(matriz, PROPIERTIES);
        pnlVShowInfo.getTableInfo().setModel(model);
        gson = new Gson();
        cmbFmodel = new DefaultComboBoxModel<>(PROPIERTIES);
        
        pnlVShowInfo.getCmbSearch().setModel(cmbFmodel);
        
//        pnlVShowInfo.getBtnShowAll().addActionListener((e) ->{
//            try
//            {
//                btnShowAllActionListener(e);
//            }
//            catch (IOException ex)
//            {
//                
//            }
//        });
    }
//    private void btnShowAllActionListener(ActionEvent e) throws IOException
//    {
//        // Creamos una lista con los objetos json casteandolos a lista tipo vehicle
//        List<Vehicle> list = (List<Vehicle>) jvdao.getAll();
//        
//        for (Vehicle vehicle : list)
//        {
//            System.out.println(e);
//        }
//        for (int i = 0; i < list.size(); i++) 
//        {
//            pnlVShowInfo.getTableInfo().setValueAt((i + 1), i, 0);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getStockNumber(), i, 1);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getYear(), i, 2);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getMake(), i, 3);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getModel(), i, 4);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getStyle(), i, 5);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getVin(), i, 6);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getExteriorColor(), i, 7);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getInteriorColor(), i, 8);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getMiles(), i, 9);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getPrice(), i, 10);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getTransmission().toString(), i, 11);
//            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getEngine(), i, 12);
//            //pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getMake(), i, 13);
//            pnlVShowInfo.getTableInfo().setValueAt(null, i, 14);
//        }
//    }
}
