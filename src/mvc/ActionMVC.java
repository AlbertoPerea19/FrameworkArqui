package mvc;

public class ActionMVC {
    private String modelName;
    private String controlName;
    private String functionName;

    public ActionMVC(String modelName, String controlName, String functionName){
        this.controlName = controlName;
        this.modelName = modelName;
        this.functionName = functionName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getControlName() {
        return controlName;
    }
    public String getFunctionName() {
        return functionName;
    }
    public String getModelName() {
        return modelName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ("CONTROL: " + controlName + ", MODEL: " + modelName + ", FUNCTION : "+ functionName);
    }
}
