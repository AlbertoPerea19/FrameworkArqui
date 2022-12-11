package mvc;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ActionsFromConfiguration {
    private HashMap<String, ActionMVC> actions = new HashMap<String,ActionMVC>();
    
    public ActionsFromConfiguration(JSONArray configArray){
        for(int i = 0 ; i < configArray.size(); i++){
            JSONObject configObject = (JSONObject) configArray.get(i);
            actions.put(configObject.get("name").toString(), new ActionMVC( configObject.get("model").toString(), configObject.get("control").toString(), configObject.get("function").toString()));
            actions.toString();
        }
    }

    public ActionMVC getAction(String acString){
        return actions.get(acString);
    }

    public HashMap<String, ActionMVC> getActions() {
        return actions;
    }
}
