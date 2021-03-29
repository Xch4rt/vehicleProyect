/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.uni.edu.programacion.views.panels.PnlVehicle;
import ni.uni.edu.programacion.views.panels.PnlVehicleShowInfo;

/**
 *
 * @author Sistemas-05
 */
public class PnlVehicleController {
    private PnlVehicle pnlVehicle;
    private PnlVehicleShowInfo pnlVShowInfo;
    private Gson gson;
    private JsonVehicleDaoImpl jvdao;
    private List<VehicleSubModel> vehicleSubModels;
    private DefaultComboBoxModel cmbModelMake;
    private DefaultComboBoxModel cmbModelModel;
    private DefaultComboBoxModel cmbModelYear;
    private DefaultComboBoxModel cmbModelEColor;
    private DefaultComboBoxModel cmbModelIColor;
    private DefaultComboBoxModel cmbStatus;
    private JFileChooser fileChooser;
    
    public PnlVehicleController(PnlVehicle pnlVehicle) throws FileNotFoundException {
        this.pnlVehicle = pnlVehicle;
        initComponent();
    }
    /*public PnlVehicleController(PnlVehicleShowInfo pnlVShowInfo) throws FileNotFoundException {
        this.pnlVShowInfo = pnlVShowInfo;
        initComponent();
    }*/
    
    private void initComponent() throws FileNotFoundException{
        jvdao = new JsonVehicleDaoImpl();
        gson = new Gson();
        
        JsonReader jreader = new JsonReader(
               new BufferedReader(new InputStreamReader(
                       getClass().getResourceAsStream("/jsons/vehicleData.json")))
        );
        
        Type listType = new TypeToken<ArrayList<VehicleSubModel>>(){}.getType();
        
        vehicleSubModels = gson.fromJson(jreader,listType);
        
        Set<String> makes = vehicleSubModels.stream().map(x -> x.getMake()).collect(Collectors.toSet());
        List<String> models = vehicleSubModels.stream().map(x -> x.getModel()).collect(Collectors.toList());
        Set<String> years = vehicleSubModels.stream().map(x -> x.getYear()).collect(Collectors.toSet());
        Set<String> colors = vehicleSubModels.stream().map(x -> x.getColor()).collect(Collectors.toSet());
        Set<String> status = vehicleSubModels.stream().map(x -> x.getStatus()).collect(Collectors.toSet());
        
        cmbModelMake = new DefaultComboBoxModel(makes.toArray());
        cmbModelModel = new DefaultComboBoxModel(models.toArray());
        cmbModelYear = new DefaultComboBoxModel(years.toArray());
        cmbModelEColor = new DefaultComboBoxModel(colors.toArray());
        cmbModelIColor = new DefaultComboBoxModel(colors.toArray());
        cmbStatus = new DefaultComboBoxModel(status.toArray());
        
        pnlVehicle.getCmbMake().setModel(cmbModelMake);
        pnlVehicle.getCmbModel().setModel(cmbModelModel);
        pnlVehicle.getCmbYear().setModel(cmbModelYear);
        pnlVehicle.getCmbEColor().setModel(cmbModelEColor);
        pnlVehicle.getCmbIColor().setModel(cmbModelIColor);
        pnlVehicle.getCmbStatus().setModel(cmbStatus);
        
        pnlVehicle.getTxtStock().requestFocus();
        
        pnlVehicle.getBtnBrowse().addActionListener((e)->{
            btnBrowseActionListener(e);
        });
        
        pnlVehicle.getBtnSave().addActionListener((e)->{
            btnSaveActionListener(e);
        });
    }
    
    private void btnSaveActionListener(ActionEvent e){
        int stock, year;
        String make, model, style, vin, eColor, iColor, miles, engine, image, status;
        float price;
        Vehicle.Transmission transmission = Vehicle.Transmission.AUTOMATIC;
        
        if(pnlVehicle.getTxtStock().getText().isEmpty()){
            return;
        }
        stock = Integer.parseInt(pnlVehicle.getTxtStock().getText());
        year = Integer.parseInt(pnlVehicle.getCmbYear().getSelectedItem().toString());
        make = pnlVehicle.getCmbMake().getSelectedItem().toString();
        model = pnlVehicle.getCmbModel().getSelectedItem().toString();
        style = pnlVehicle.getTxtStyle().getText();
        vin = pnlVehicle.getFmtVin().getText();
        eColor = pnlVehicle.getCmbEColor().getSelectedItem().toString();
        iColor = pnlVehicle.getCmbIColor().getSelectedItem().toString();
        miles = pnlVehicle.getSpnMiles().getModel().getValue().toString();
        price = Float.parseFloat(pnlVehicle.getSpnPrice().getModel().getValue().toString());
        engine = pnlVehicle.getTxtEngine().getText();
        image = pnlVehicle.getTxtImage().getText();
        status = pnlVehicle.getCmbStatus().getSelectedItem().toString();
        transmission = pnlVehicle.getRbtnAut().isSelected() ?
                transmission : Vehicle.Transmission.MANUAL;
                
        Vehicle v = new Vehicle(stock, year, make, model, 
                style, vin, eColor, iColor, miles, price, transmission, engine, image, status);
        
        try {
            jvdao.create(v);
            JOptionPane.showMessageDialog(null, "Vehicle saved successfully.", 
                    "Information message", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PnlVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnBrowseActionListener(ActionEvent e){
        fileChooser = new JFileChooser();
        
        int option = fileChooser.showOpenDialog(null);
        if(option == JFileChooser.CANCEL_OPTION){
            return;
        }
        
        File file = fileChooser.getSelectedFile();
        if(!file.exists()){
            JOptionPane.showMessageDialog(null, "Image does not exists", 
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        pnlVehicle.getTxtImage().setText(file.getPath());        
    }
} 
