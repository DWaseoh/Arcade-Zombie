package supervivencia;

public class Objeto {
	private String nombre, descripcion, tipo;
	private int probabilidad, vida, infecc, ataque, bala;
	private float hambre, sed;
    
	public Objeto(String tipo, String nombre, String descripcion, int prob, int a, int b) {
    	this.tipo=tipo;
    	this.nombre=nombre;
    	this.descripcion=descripcion;
    	this.probabilidad=prob;
   	 
    	switch(tipo) {
    	case "curativo":
        	this.vida=a;
        	this.infecc=b;
        	break;
    	case "comida":
    	case "bebida":
   		 this.hambre=(float)a;
        	this.sed=(float)b;
        	break;
    	case "armaB":
    	case "armaF":
    	case "bala":
   		 this.ataque=a;
        	this.bala=b;
        	break;
    	}
	}
    
	public void consultar(String nombre) {
    	System.out.printf("Nombre: %s\nDescripcion: %s", nombre, descripcion);
	}
    
	public String getTipo() {
    	return this.tipo;
	}
    
	public String getNombre() {
    	return this.nombre;
	}
    
	public int getProb() {
    	return this.probabilidad;
	}
    
	public int getVida() {
    	return this.vida;
	}
	public int getInfecc() {
    	return this.infecc;
	}
    
	public float getHambre() {
    	return this.hambre;
	}
    
	public float getSed() {
    	return this.sed;
	}
    
	public int getAtaque() {
    	return this.ataque;
	}
    
	public int getBalas() {
    	return this.bala;
	}
}


