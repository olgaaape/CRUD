
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;

public class ModeloHashMap extends ModeloAbs
{
    private HashMap <Integer,Producto> lista;
    
    public ModeloHashMap()
    {
       lista=new HashMap  <Integer,Producto>();
    }

	@Override
	public boolean insertarProducto(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean borrarProducto(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto buscarProducto(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void listarProductos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean modificarProducto(Producto nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

    
    
}
