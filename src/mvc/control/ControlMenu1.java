/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.control;
import java.awt.event.ActionEvent;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import configReader.ValidarLectura;
import mvc.ActionsFromConfiguration;
import mvc.Transaction;
import mvc.model.Fraccion;
import mvc.view.VistaMenu;
/**
 *
 * 
 */
public class ControlMenu1 extends Control{
    private Fraccion modeloF1;
    
    private Fraccion resultado;
    private ActionsFromConfiguration actionsMVC;   
    private VistaMenu vistaMenu;
    private JSONArray jsonTransactions;


    public ControlMenu1(Fraccion modeloF1, Fraccion modeloF2, VistaMenu vistaMenu){
        this.modeloF1 = modeloF1;
        this.vistaMenu = vistaMenu;
        
        vistaMenu.getBotonSuma().addActionListener(this);
        vistaMenu.getBotonResta().addActionListener(this);
        vistaMenu.getBotonMultiplicacion().addActionListener(this);
        vistaMenu.getBotonDivision().addActionListener(this);
        vistaMenu.getBotonSimplificacion().addActionListener(this);
        vistaMenu.getBotonLimpiar().addActionListener(this);
        vistaMenu.getBotonSalir().addActionListener(this);
    }

    public ControlMenu1(VistaMenu vistaMenu){
        this.vistaMenu = vistaMenu;
        this.modeloF1 = new Fraccion();
        this.vistaMenu.getNumFrac1().setText(Integer.toString(modeloF1.getNum()));
        this.vistaMenu.getDenomFrac1().setText(Integer.toString(modeloF1.getDenom()));
        vistaMenu.getBotonSuma().addActionListener(this);
        vistaMenu.getBotonResta().addActionListener(this);
        vistaMenu.getBotonMultiplicacion().addActionListener(this);
        vistaMenu.getBotonDivision().addActionListener(this);
        vistaMenu.getBotonSimplificacion().addActionListener(this);
        vistaMenu.getBotonLimpiar().addActionListener(this);
        vistaMenu.getBotonSalir().addActionListener(this);
        Class<?>[] paramTypes = {int.class, int.class};
        this.setParamTypes(paramTypes);
        readConfiguration();
        loadConfiguration();
    }
    @Override
    public void readConfiguration(){
        try{
            String configPath = "src/Settings.txt";
            ValidarLectura validacionJSON = new ValidarLectura();
            JSONObject configObject = validacionJSON.extractJSONObject(validacionJSON.readJSON(configPath));
            this.jsonTransactions = validacionJSON.extractJSONArray(configObject, "mvc");
        }catch(Exception e){

        }
    }

    @Override
    public void loadConfiguration(){
        try{
            this.actionsMVC = new ActionsFromConfiguration(jsonTransactions);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ControlMenu1(Object model){

    }

    public ControlMenu1(Fraccion modeloF1){
        this.modeloF1 = modeloF1;
    }

    public void displayResult(Fraccion f){
        vistaMenu.getLabelNumResultado().setText(Integer.toString(f.getNum()));
        vistaMenu.getLabelDenomResultado().setText(Integer.toString(f.getDenom()));
    }
    
    public void actionPerformed(ActionEvent e){
        if(vistaMenu.getBotonSuma() == e.getSource()){
            Object[] params = {Integer.parseInt(vistaMenu.getNumFrac1().getText()), Integer.parseInt(vistaMenu.getDenomFrac1().getText())};
            Transaction t = new Transaction(actionsMVC.getAction("sumarFraccion").getModelName(), actionsMVC.getAction("sumarFraccion").getControlName(), paramTypes, params);
            params[0] = Integer.parseInt(vistaMenu.getNumFrac2().getText());
            params[1] = Integer.parseInt(vistaMenu.getDenomFrac2().getText());
            resultado = (Fraccion) t.execute(actionsMVC.getAction("sumarFraccion").getFunctionName(),this.getParamTypes(),params);
            displayResult(resultado);
            
        }
        
        if(vistaMenu.getBotonResta() == e.getSource()){
            Object[] params = {Integer.parseInt(vistaMenu.getNumFrac1().getText()), Integer.parseInt(vistaMenu.getDenomFrac1().getText())};
            Transaction t = new Transaction(actionsMVC.getAction("restarFraccion").getModelName(), actionsMVC.getAction("restarFraccion").getControlName(), paramTypes, params);
            params[0] = Integer.parseInt(vistaMenu.getNumFrac2().getText());
            params[1] = Integer.parseInt(vistaMenu.getDenomFrac2().getText());
            resultado = (Fraccion) t.execute(actionsMVC.getAction("restarFraccion").getFunctionName(),paramTypes,params);
            displayResult(resultado);
        }
        
        if(vistaMenu.getBotonMultiplicacion() == e.getSource()){
            Object[] params = {Integer.parseInt(vistaMenu.getNumFrac1().getText()), Integer.parseInt(vistaMenu.getDenomFrac1().getText())};
            Transaction t = new Transaction(actionsMVC.getAction("multiplicarFraccion").getModelName(), actionsMVC.getAction("multiplicarFraccion").getControlName(), paramTypes, params);
            params[0] = Integer.parseInt(vistaMenu.getNumFrac2().getText());
            params[1] = Integer.parseInt(vistaMenu.getDenomFrac2().getText());
            resultado = (Fraccion) t.execute(actionsMVC.getAction("multiplicarFraccion").getFunctionName(),paramTypes,params);
            displayResult(resultado);
        }
        
        if(vistaMenu.getBotonDivision() == e.getSource()){
            Object[] params = {Integer.parseInt(vistaMenu.getNumFrac1().getText()), Integer.parseInt(vistaMenu.getDenomFrac1().getText())};
            Transaction t = new Transaction(actionsMVC.getAction("dividirFraccion").getModelName(), actionsMVC.getAction("dividirFraccion").getControlName(), paramTypes, params);
            params[0] = Integer.parseInt(vistaMenu.getNumFrac2().getText());
            params[1] = Integer.parseInt(vistaMenu.getDenomFrac2().getText());
            resultado = (Fraccion) t.execute(actionsMVC.getAction("dividirFraccion").getFunctionName(),paramTypes,params);
            displayResult(resultado);
        }
        
        if(vistaMenu.getBotonSimplificacion() == e.getSource()){
           
        }
        
        if(vistaMenu.getBotonLimpiar() == e.getSource()){
            vistaMenu.getNumFrac1().setText(null);
            vistaMenu.getDenomFrac1().setText(null);
            vistaMenu.getNumFrac2().setText(null);
            vistaMenu.getDenomFrac2().setText(null);
            vistaMenu.getLabelNumResultado().setText(null);
            vistaMenu.getLabelDenomResultado().setText(null);
        }
        
        if(vistaMenu.getBotonSalir() == e.getSource()){
            System.exit(0);
        }
    }   
}

