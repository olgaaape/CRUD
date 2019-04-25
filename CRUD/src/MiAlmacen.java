import java.util.Scanner;


import java.util.InputMismatchException;
import java.util.ArrayList;

// Crear la clase Producto y completar los métodos

public class MiAlmacen
{
    static private ModeloAbs almacen;
    static Scanner sc;
    
    public static void main(String[] args){
        almacen=new ModeloArrayList ();
	almacen=new ModeloHashMap ();
        sc = new Scanner(System.in);
        int opcion=0;
        do{
		mostrarMenu();
                opcion=leerOpcion(1,9);
                switch(opcion){
                    case 1: crear();break;
                    case 2: consultar();break;
                    case 3: borrar();break;
                    case 4: modificarPrecio();break;
                    case 5: comprar();break;
                    case 6: vender();break;
                    case 7: listar();break;
                    case 8: listarPocoStock();break;
                }
                System.out.println("\n---------------------------- ");
                System.out.print("Pulse enter para continuar");
                sc.nextLine();
        }while(opcion!=9);
        sc.close();
        
    }
    
    
    private static void mostrarMenu(){
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al mínimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opción (1-9)");        
    }
    
    // Lee un entero del System.in que este comprendido entre primero y ultimo
    private static int leerOpcion(int primero, int ultimo){
        int valor = leerEntero();
        while ( valor <primero || valor > ultimo){
            valor = leerEntero();
        }
        return valor;
    }
      
    
    // Metodos Auxiliares leerFloat y LeerEntero, 
    // Lee de la System.in con el scanner sc y controlan la excepcion de NumberFormatException
    static private float leerFloat(){
        
        boolean error = false;
        float valor =0;
        String cadena;
        do {
        error = false;  
          try {
             // Intento leer directamente un entero  
             cadena = sc.nextLine();
             valor = Float.parseFloat(cadena);
             
            } catch(NumberFormatException e){
              System.out.println("Error en formato.");
              error = true;
            }
        }
       while ( error);
       return valor;
    }
    
 static private int leerEntero(){
    	
    	boolean error = false;
    	int numero = 0;
    	do {
    		error = false;
    		numero = sc.nextInt();
    			try {
    				if (numero - Math.floor(numero)!=0) {
    					throw new NumberFormatException();
    				}
    			}catch (NumberFormatException e) {
    				System.out.println("Error en formato.");
    				error = true;
    			}
    	}while (error);
      return numero;
    }

    // Muestra los datos de un producto a partir de su codigo
    
    private static void consultar(){        
       System.out.println("<CONSULTA>");
       System.out.print("Introduzca codigo:");
       int codigo = leerEntero();
       Producto p = almacen.buscarProducto(codigo);
       if ( p == null){
           System.out.println("El producto no se encuentra en almacen");
        }
       else {
           System.out.println("PRODUCTO "+p);
        }
       
    }
    
   
    // Borrar un producto a partir de su codigo
    
    private static void borrar(){       
      System.out.println("<ELIMINAR>");
      System.out.println("Introduzca el código: ");
      int codigo= leerEntero();
      if (almacen.borrarProducto(codigo)) {
    	  System.out.println("El producto ha sido borrado");
      }else {
          System.out.println("No se puede eliminar");    	  
      }
    }
    
    // Cambia el precio de un producto a partir de su codigo
    private static void modificarPrecio (){
       System.out.println("<MODIFICAR PRECIO>");
       System.out.println("Introduzca el código: ");
       int codigo= leerEntero();
       Producto p= almacen.buscarProducto(codigo);
       System.out.println("Introduzca el nuevo precio: ");
       float precio = leerFloat();
       p.setPrecio(precio);
    
    }
    
    
    
    // Incrementa el stock
    private static void comprar(){     
       System.out.println("<COMPRAR>");
       System.out.println("Introduce el codigo del producto:");
       int codigo= leerEntero();
       System.out.println("Introduzca cantidad que quiera comprar:");
       int cantidad = leerEntero();
       Producto p = almacen.buscarProducto(codigo);
       if  (p !=null) {
    	   p.setStock(p.getStock()+cantidad);
       }else System.out.println("No existe este producto.");
    }
    
    // Decrementa el stock
    private static void vender(){
        System.out.println("<VENDER>");
        System.out.println("Introduce el codigo del producto:");
        int codigo= leerEntero();
        System.out.println("Introduzca cantidad que quiera vender:");
        int cantidad = leerEntero();
        Producto p = almacen.buscarProducto(codigo);
        if  (p !=null) {
     	   p.setStock(p.getStock()-cantidad);
        }else System.out.println("No existe este producto.");
       
    }
    
    // Listado de todos los productos
    private static void listar(){        
         System.out.println("<LISTAR>");
        almacen.listarProductos();
    }
    
    // Listado de todos los productos con stock inferior a stock minimo
    private static void listarPocoStock(){
        System.out.println("<LISTAR STOCK BAJO MINIMOS>");
      
        almacen.listarPocoStock();
       
    }
    
    // Solicita datos al usuario para dar de alta un nuevo producto 
    // El codigo no se puede repetir
    private static void crear(){
       System.out.println("<NUEVO PRODUCTO>");
       System.out.println("Introduzca un codigo:");
       int codigo = leerEntero();
       sc.nextLine();
       System.out.println("Introduzca el nombre: ");
       String nombre = sc.next();
       Producto p = new Producto (codigo,nombre);
       almacen.insertarProducto(p);
       System.out.println("Introduzca Stock_min:");
       int stock_min = leerEntero();
       p.setStock_min(stock_min);
    }
       
  
}

