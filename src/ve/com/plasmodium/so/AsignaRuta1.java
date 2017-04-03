package ve.com.plasmodium.so;

public class AsignaRuta1 {

    	// Campos para poder visualizar la posible proxima asignacion en GUI
	private short theRuta;
	private short thePacking;
	//private String monto;
	private int theNumeroTarjetas;
	
	public AsignaRuta1(String theRuta, String theNumeroTarjetas, String thePacking) {
	    super(); 
	    setTheRuta(theRuta);
	    setTheNumeroTarjetas(theNumeroTarjetas);
	    setThePacking(thePacking);
	    
	    System.out.println("CREARA OBJETO AsignaRuta1 con: Distribuidor"+theRuta+" theNumeroTarjetas "+theNumeroTarjetas+" thePacking "+thePacking);
	    
	}



	public short getTheRuta() {
	    return theRuta;
	}



	public void setTheRuta(String theRuta) {
	    this.theRuta = Short.parseShort(theRuta) ;
	}



	public int getTheNumeroTarjetas() {
	    return theNumeroTarjetas;
	}



	public void setTheNumeroTarjetas(String theNumeroTarjetas) {
	    this.theNumeroTarjetas = Integer.parseInt(theNumeroTarjetas);
	}



	public short getThePacking() {
	    return thePacking;
	}



	public void setThePacking(String thePacking) {
	    this.thePacking = Short.parseShort(thePacking);
	}

	
    	
    
}
