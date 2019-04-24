
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class ModeloArrayList extends ModeloAbs
{
    private ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
    	lista.add(p);
      return true;    
    }
 
    public boolean borrarProducto ( int codigo ){
    	Producto aux;
    	boolean borrado=false;
      for (int i = 0; i < lista.size(); i++) {
    	aux = lista.get(i);
    	if (aux.codigo==codigo) {
    		lista.remove(lista.get(i));
    		borrado=true;
    		break;
    	}
	}
      return borrado;
    }
    
    public Producto buscarProducto ( int codigo) {
    	Producto aux=null;
    	
    	for (int i = 0; i < lista.size(); i++) {
    	aux = lista.get(i);
    	if (aux.codigo==codigo) {
    		break;
    	}
    	}
        return aux;
    }
    
    public void listarProductos (){
    	System.out.println("========= MIS PRODUCTOS =======");
    	for (int i = 0; i < lista.size(); i++) {
        	System.out.println(lista.get(i));
        	}
    }
    
    public boolean modificarProducto (Producto nuevo){
       return false;
    }
    
    
}    
