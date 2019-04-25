

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
		lista.put(p.getCodigo(), p);
		return true;
	}

	@Override
	boolean borrarProducto(int codigo) {
		// TODO Auto-generated method stub
		lista.remove(codigo);
		return true;
	}

	@Override
	public Producto buscarProducto(int codigo) {
		// TODO Auto-generated method stub
		Producto p=null;
		
		p =lista.get(codigo);
		
		return p;
	}

	@Override
	void listarProductos() {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer,Producto> codigo: lista.entrySet()) {
			System.out.println(codigo+" : "+codigo.getValue());
		}
	}

	@Override
	boolean modificarProducto(Producto nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void listarPocoStock() {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer,Producto> codigo: lista.entrySet()) {
			if (codigo.getValue().getStock()<codigo.getValue().getStock_min()) {
				System.out.println(codigo+" : "+codigo.getValue());
			}
			
		}
	}

    
    
}

