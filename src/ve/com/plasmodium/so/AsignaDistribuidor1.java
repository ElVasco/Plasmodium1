package ve.com.plasmodium.so;

public class AsignaDistribuidor1 {

    	// Campos para poder visualizar la posible proxima asignacion en GUI
	private short theDistribuidor;
	private short thePacking;
	//private String monto;
	private int theNumeroTarjetas;
	
	public AsignaDistribuidor1(String theDistribuidor, String theNumeroTarjetas, String thePacking) {
	    super();
	    setTheDistribuidor(theDistribuidor);
	    setTheNumeroTarjetas(theNumeroTarjetas);
	    setThePacking(thePacking);
	    
	    System.out.println("CREARA OBJETO AsignaDistribuidor1 con: Distribuidor"+theDistribuidor+" theNumeroTarjetas "+theNumeroTarjetas+" thePacking "+thePacking);
	    
	}



	public short getTheDistribuidor() {
	    return theDistribuidor;
	}



	public void setTheDistribuidor(String theDistribuidor) {
	    this.theDistribuidor = Short.parseShort(theDistribuidor) ;
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
