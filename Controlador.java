import java.util.*;

public class Controlador {
    private ArrayList<BaseTrabajador> trabajadores = new ArrayList<>();

    public void mostrarTrabajadores(){
        for (Object elem : trabajadores) {
            BaseTrabajador p = (BaseTrabajador) elem;
            System.out.println(p.datos(String.valueOf(p.getID())));
        }
    }
}