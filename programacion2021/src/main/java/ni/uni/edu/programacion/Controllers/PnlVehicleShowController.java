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
import javax.swing.DefaultComboBoxModel;
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
    private final String PROPIERTIES[] = new String[]{"STOCK","YEAR", "MAKE", "MODEL", "STYLE", "VIN", "EXTERIOR COLOR", "INTERIOR COLOR", "MILES", "PRICE", "TRANSMISSION", "ENGINE"};
    private DefaultComboBoxModel<String> cmbFmodel;
    private List<Vehicle> list;
    private Gson gson;
    private JsonVehicleDaoImpl jvdao;
    private List<VehicleSubModel> vehicleSubModels;
    
    
    public PnlVehicleShowController(PnlVehicleShowInfo pnlVShowInfo) throws FileNotFoundException {
        this.pnlVShowInfo = pnlVShowInfo;
        initComponent();
    }
    
    private void initComponent() throws FileNotFoundException 
    {
        jvdao = new JsonVehicleDaoImpl();
        gson = new Gson();
        cmbFmodel = new DefaultComboBoxModel<>(PROPIERTIES);
        
        pnlVShowInfo.getCmbSearch().setModel(cmbFmodel);
        
        pnlVShowInfo.getBtnShowAll().addActionListener((e) ->{
            try
            {
                btnShowAllActionListener(e);
            }
            catch (IOException ex)
            {
                
            }
        });
    }
    private void btnShowAllActionListener(ActionEvent e) throws IOException
    {
        // Creamos una lista con los objetos json casteandolos a lista tipo vehicle
        list = (List<Vehicle>) jvdao.getAll();
        

        for (int i = 0; i < list.size(); i++) 
        {
            pnlVShowInfo.getTableInfo().setValueAt((i + 1), i, 0);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getStockNumber(), i, 1);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getYear(), i, 2);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getMake(), i, 3);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getModel(), i, 4);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getStyle(), i, 5);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getVin(), i, 6);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getExteriorColor(), i, 7);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getInteriorColor(), i, 8);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getMiles(), i, 9);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getPrice(), i, 10);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getTransmission().toString(), i, 11);
            pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getEngine(), i, 12);
            //pnlVShowInfo.getTableInfo().setValueAt(list.get(i).getMake(), i, 13);
            pnlVShowInfo.getTableInfo().setValueAt(null, i, 13);
        }
    }
}
