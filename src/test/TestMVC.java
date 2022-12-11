package test;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

import mvc.control.ControlMenu1;
import mvc.model.Fraccion;
import mvc.view.VistaMenu;

public class TestMVC {
    public void testMVC(){

        Field[] campos = ControlMenu1.class.getDeclaredFields();
        for (Field field : campos) {
            System.out.println(field);
        }

        Method[] metodos = Fraccion.class.getMethods();
        for (Method method : metodos) {
            System.out.println(method);
        }
        /* 
        Transaction t = new Transaction("mvc.model.Fraccion", "mvc.control.ControlMenu", "sumar");
        Class<?>[] paramTypes = {int.class, int.class};
        Object[] params = {3, 6};
        t.execute("sumar",paramTypes,params);*/

        ///VistaMenu view = new VistaMenu();
        //Fraccion modeloF1 = new Fraccion();
        //Fraccion modeloF2 = new Fraccion();
        VistaMenu vistaMenu = new VistaMenu();
        ControlMenu1 controlMenu = new ControlMenu1(vistaMenu);
        vistaMenu.setVisible(true);
    }
}
