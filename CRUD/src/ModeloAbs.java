/**
 * Abstract class ModeloAbs - Clase de acceso a Modelo de DATOS
 * 
 * @author: Alberto Lopez
 * Date: 24/04/2018
 */
public abstract class ModeloAbs
{
    public ModeloAbs() {
    }
    
    abstract public boolean insertarProducto ( Producto p);
    
    abstract boolean borrarProducto ( int codigo );
    
    abstract public Producto buscarProducto ( int codigo);
    
    abstract void listarProductos ();
    
    abstract boolean modificarProducto (Producto nuevo);
    
    
}
