package supervivencia;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
   	 Jugador uno = new Jugador();
   	 String accion;
   	 boolean salir = false, subido = false;
   	 Scanner sc = new Scanner(System.in);
   	 int temp = 0, nivel = 1;

   	 do {
   		 int probabilidad = (int) (Math.random() * 100) + 1;
   		 System.out.printf("\nACCIONES\n---------------\n" + "e - Explorar\n" + "d - Descansar\n" + "p - Personaje\n"
   				 + "i - Inventario\n" + "t - Terminar\n" + "---------------\n");
   		 accion = sc.nextLine();
   		 switch (accion.toLowerCase()) {
   		 case "e":
   			 uno.tiempo(60);
   			 // Objeto
   			 if (probabilidad <= 65)
   				 uno.explorar();
   			 // Enemigo
   			 else
   				 uno.pelea(new Enemigo(nivel));
   			 break;
   		 case "d":
   			 uno.des();
   			 break;
   		 case "p":
   			 uno.muestra();
   			 break;
   		 case "i":
   			 uno.inv();
   			 break;
   		 case "t":
   			 salir = true;
   			 System.out.println("Fin de la partida");
   			 break;
   		 default:
   			 System.out.println("Introduce una accion valida.");
   			 break;
   		 }
   		 if (uno.getDias() % 2 == 0 && uno.getDias() != 0 && !subido) {
   			 nivel++;
   			 subido=true;
   				 
   		 }
   		 else if(uno.getDias() % 2 == 1) {
   			 subido=false;
   		 }
   	 } while (uno.getVida() > 0 && uno.getHambre() > 0f && uno.getSed() > 0f && uno.getInfecc() < 100 && !salir);

   	 uno.sumarScore(uno.getDias() * 1000);

   	 if (salir)
   		 System.out.printf("Puntuación final de %s: %d\nDías sobrevividos: %d", uno.getNombre(), uno.getScore(),
   				 uno.getDias());
   	 else {
   		 uno.getMuerte();
   		 System.out.printf("Puntuación final de %s: %d\nDías sobrevividos: %d", uno.getNombre(), uno.getScore(),
   				 uno.getDias());
   	 }
    }

}


