package mvc.control;
import java.awt.event.ActionListener;

import org.json.simple.JSONArray;

import java.awt.event.ActionEvent;

import InterfaceReader.setConfigJSON;
import mvc.ActionsFromConfiguration;

public class Control implements ActionListener, setConfigJSON{
    private ActionsFromConfiguration actionsMVC;
    private JSONArray jsonTransactions;
    Class<?>[] paramTypes;
    Object[] params;

    @Override
    public void readConfiguration() {
        
    }

    @Override
    public void loadConfiguration() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

    public void setActionsMVC(ActionsFromConfiguration actionsMVC) {
        this.actionsMVC = actionsMVC;
    }

    public ActionsFromConfiguration getActionsMVC() {
        return actionsMVC;
    }

    public void setJsonTransactions(JSONArray jsonTransactions) {
        this.jsonTransactions = jsonTransactions;
    }

    public JSONArray getJsonTransactions() {
        return jsonTransactions;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object[] getParams() {
        return params;
    }
    
}
