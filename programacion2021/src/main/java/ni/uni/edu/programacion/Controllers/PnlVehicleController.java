/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
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
    }
} 
