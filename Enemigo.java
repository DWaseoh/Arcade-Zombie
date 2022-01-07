package supervivencia;

public class Enemigo {

	private String nombre;
	private int vida, ataque, infecc, nivel;
    
	public Enemigo(int nivel) {
		String[] nombres= {"Hombre zombie", "Niño zombie", "Mujer zombie", "Niña zombie", "Policia zombie", "Perro zombie", "Bombero zombie", "Funcionario zombie", "Zombie flaco", "Zombie gordo", "Zombie sin piernas", "Zombie sin brazos", "Zombie ciego", "Gato zombie"};
		int r=(int)(Math.random()*nombres.length);
		
		this.nombre=nombres[r];
    	this.nivel=nivel;
    	this.vida=this.generarVida(nivel);
    	this.ataque=this.generarAtaque(nivel);
    	this.infecc=this.generarInfecc(nivel);
	}
    
	public void muestra() {
   	 System.out.printf("%s - Nivel: %d - Vida: %d\n", this.nombre, this.nivel, this.vida);
	}
    
	public String getNombre() {
    	return nombre;
	}
    
	public int getNivel() {
    	return nivel;
	}
    
	public int getVida() {
    	return vida;
	}
    
	public int getAtaque() {
    	return ataque;
	}
    
	public int getInfecc() {
    	return infecc;
	}
    
	public void recibeDaño(int daño) {
    	this.vida-=daño;
	}
    
	public int generarVida(int nivel) {
    	int ran=(int)(Math.random()*3)+3;
    	return ran*nivel;
	}
    
	public int generarAtaque(int nivel) {
    	int ran=(int)(Math.random()*3)+3;
    	return ran*nivel;
	}
    
	public int generarInfecc(int nivel) {
    	int ran=(int)(Math.random()*5)+1;
    	return ran*nivel;
	}
}


