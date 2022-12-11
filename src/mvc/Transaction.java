package mvc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transaction {
    private String transactionName;
    private Object control;
    private String modelIdentifier;
    private Object model;
    private Object outObjectFunction;

    public Transaction(String modelIdentifier, String controlIdentifier , Class[] modelparameterTypes, Object[] modelparams){
        loadModel(modelIdentifier, modelparameterTypes, modelparams);
        loadControl(controlIdentifier);
        this.modelIdentifier = modelIdentifier;
    }


    private void loadModel(String model, Class[] parameterTypes, Object[] params){
        try{
            Constructor constructorForModel = Class.forName(model).getConstructor(parameterTypes);
            System.out.println("Execute se cra modelo");
            this.model = constructorForModel.newInstance(params);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    public void loadControl(String control){
        try{
           
            Class controlClass = Class.forName(control);
            Class params[] = new Class[1];
            params[0] = Object.class;
            Constructor constructorForControl = controlClass.getConstructor(params);
            this.control = constructorForControl.newInstance(model);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Object execute(String methodName, Class[] parameterTypes, Object[] params){
        try {
             Method method = model.getClass().getDeclaredMethod(methodName, parameterTypes);
            outObjectFunction = method.invoke(model, params);
            System.out.println(outObjectFunction.toString());
            return outObjectFunction;
          } catch (Exception e) { e.printStackTrace(); }
        return null;
            
            
    }

    public Object getOutObjectFunction() {
        return outObjectFunction;
    }
}
