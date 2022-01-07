package supervivencia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador {
	// Atributos
	private String nombre;
	private int vidaMax, hambreMax, sedMax, infeccMin, puntuacion, vida, infecc;
	private float hambre, sed;
	private int ataque, ataqueMin;
	private Objeto[] invInx;
	private int[] invVal;

	// Variables globales
	Scanner sc = new Scanner(System.in);
	boolean equipado = false;
	String armaEquipada;
	int minutosTotales;
	int diasTotales;

	// Metodo constructor del jugador.
	public Jugador() {
		System.out.println("Introduce el nombre de tu personaje:");
		this.nombre = sc.nextLine();
		this.vidaMax = 100;
		this.hambreMax = 168;
		this.sedMax = 72;
		this.infeccMin = 0;
		this.ataqueMin = 5;
		this.vida = vidaMax;
		this.hambre = hambreMax;
		this.sed = sedMax;
		this.infecc = infeccMin;
		this.ataque = ataqueMin;
		this.invInx = new Objeto[] {
				// new Curativo(tipo, nombre, descripcion, prob, vida, infecc)
				new Objeto("curativo", "Jirones de ropa",
						"Jirones de alguna prenda antigua, puede ser usado para tapar alguna herida, recuperan vida pero no mucha",
						60, 5, 0),
				new Objeto("curativo", "Gasas", "Gasas, algo mejor que los jirones, ayudan a sanar mejor", 50, 10, 0),
				new Objeto("curativo", "Vendas",
						"Vendas, mucho mejor que las gasas, es el mejor apoyo contra las heridas", 40, 15, 0),
				new Objeto("curativo", "Agua oxigenada", "Agua oxigenada, tu mejor amigo contra las heridas", 20, 25,
						5),
				new Objeto("curativo", "Antibioticos", "Antibioticos, ayudan a mitigar la infeccion", 30, 10, 30),

				// new Comestible(tipo, nombre, descripcion, prob, hambre, sed)
				new Objeto("comida", "Tiras de carne seca",
						"Tiras de carne seca, para nada un plato gourmet, pero ayudan a mitigar el hambre", 75, 5, -5),
				new Objeto("comida", "Barrita energetica",
						"Barrita energética, muy nutritiva, aunque no te llena el estomago", 50, 10, -5),
				new Objeto("comida", "Lata", "Lata de albóndigas en conserva, tu favorita", 25, 30, -10),
				new Objeto("bebida", "Botella de agua", "Simple botella de agua, tu amiga contra la sed", 70, 0, 30),
				new Objeto("bebida", "Bebida energetica", "Bebida energética, muy nutritiva, aunque prefieres el agua",
						50, 0, 10),
				new Objeto("bebida", "Garrafa", "Garrafa de agua, si la botella era tu amiga esta es tu esposa", 25, 0,
						50),
				// new ArmaB(tipo, nombre, descripcion, prob, ataque)
				new Objeto("armaB", "Cuchillo", "Un simple cuchillo que te ayuda a mantener a esos bichos a ralla", 75,
						5, 0),
				new Objeto("armaB", "Martillo", "Un martillo, algo tosco pero fuerte", 60, 7, 0),
				new Objeto("armaB", "Bate", "Bate de beisbol, largo, fuerte, el arma perfecta del hombre", 55, 9, 0),
				new Objeto("armaB", "Katana rota",
						"Esta katana fue antaño una reliquia familiar, ahora es un simple cuchillo", 1, 10, 0),
				new Objeto("armaF", "Pistola de prueba", "Pistola 9mm, la lleva cualquier policia", 40, 20, 1),
				// new Objeto("armaF", "Pistola", "Pistola 9mm, la lleva cualquier policia", 10,
				// 20, 1),
				new Objeto("bala", "Balas de pistola", "Balas sencillas, valen para cualquier pistola", 100, 0, 1), };
		this.invVal = new int[invInx.length];
	}

	public void muestra() {
		System.out.printf(
				"-------------\nNombre: %s\nVida: %d\nHambre: %.0f\nSed: %.0f\nInfeccion: %d\nAtaque: %d\nArma equipada: %s\nHora: %d:%d\nDías vivo: %d\n-------------\n\n",
				nombre, vida, hambre, sed, infecc, ataque, armaEquipada, this.getHoras(), this.getMinutos(),
				this.getDias());
	}

	public void tiempo(int minutos) {
		for (int i = 0; i < minutos; i++) {
			hambre -= 0.0166666666666667f;
			sed -= 0.0166666666666667f;
		}
		minutosTotales += minutos;
		diasTotales = minutosTotales / 60 / 24;
	}

	public int getMinutos() {
		return minutosTotales % 60;
	}

	public int getHoras() {
		return minutosTotales / 60 % 24;
	}

	public int getDias() {
		return diasTotales;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public float getHambre() {
		return hambre;
	}

	public float getSed() {
		return sed;
	}

	public int getInfecc() {
		return infecc;
	}

	public int getAtaque() {
		return ataque;
	}

	public boolean getArmaF() {
		for (int i = 0; i < invInx.length; i++) {
			if (invInx[i].getTipo().equalsIgnoreCase("armaF")) {
				if (invVal[i] > 0) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean equalPosArmaF(int i) {
		if (invInx[i - 1].getTipo().equalsIgnoreCase("armaF")) {
			if (invVal[i - 1] > 0) {
				return true;
			}
		}
		return false;
	}

	public void disparaArmaF(Enemigo z) {
		int obj = 0;
		boolean enc = false;

		for (int i = 0; i < invInx.length; i++) {
			if (invInx[i].getTipo().equalsIgnoreCase("armaF")) {
				if (invVal[i] > 0) {
					System.out.printf("%02d - %s - Daño:%d\n", i + 1, invInx[i].getNombre(), invInx[i].getAtaque());
					enc = true;
				}
			}
		}

		if (enc) {
			boolean salir = false;
			do {
				try {
					System.out.println("Introduzca el número de posición del arma.");
					obj = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Introduce el número de la posicion.");
					sc = new Scanner(System.in);
				}
				if (obj > 0 && obj < invInx.length) {
					if (this.equalPosArmaF(obj))
						salir = true;
				} else
					System.out.println("Introduce correctamente el número de la posicion.");
			} while (!salir);
			sc = new Scanner(System.in);
			boolean dispara = false;
			for (int j = 0; j < invInx.length && !dispara; j++) {
				if (invVal[j] > 0) {
					if (invInx[obj - 1].getBalas() == invInx[j].getBalas() && obj - 1 != j) {
						invVal[j]--;
						z.recibeDaño(invInx[obj - 1].getAtaque());
						dispara = true;
					}
				}
			}
			if (!dispara)
				System.out.println("No tienes balas");
		}
	}

	public void getMuerte() {
		if (vida < 0)
			System.out.println("\n\nHas muerto desangrado");
		if (hambre < 0)
			System.out.println("\n\nHas muerto de hambre");
		if (sed < 0)
			System.out.println("\n\nHas muerto de sed");
		if (infecc >= 100)
			System.out.println("\n\nTe has convertido en zombie");
	}

	public void sumarScore(int suma) {
		this.puntuacion += suma;
	}

	public int getScore() {
		return puntuacion;
	}

	// Explorar el mapa
	public void explorar() {
		boolean enc = false, salir = false;
		;
		String busq;
		int random = (int) (Math.random() * 3) + 1;
		while (!salir) {
			System.out.println("Centrar busqueda en:\n\th - Hospital\n\ts - Supermercado\n\te - Estación de policias");
			busq = sc.nextLine();
			sc = new Scanner(System.in);
			switch (busq) {
			case "h":
				busq = "curativo";
				break;
			case "s":
				if (Math.random() > 0.5f)
					busq = "comida";
				else
					busq = "bebida";
				break;
			case "e":
				if (random == 1)
					busq = "armaB";
				else if (random == 2)
					busq = "armaF";
				else if (random == 3)
					busq = "bala";
				break;
			}
			for (int i = 0; i < invInx.length && !enc; i++) {
				int prob = (int) (Math.random() * 100) + 1;
				if (invInx[i].getTipo().equalsIgnoreCase(busq)) {
					if (prob <= invInx[i].getProb()) {
						invVal[i]++;
						System.out.printf("¡Encontraste %s!\n", invInx[i].getNombre());
						enc=true;
					}
					salir = true;
				}
			}
		}
		if (!enc) {
			System.out.println("No encontraste nada...");
		}
	}

	public boolean getInv() {
		for (int i = 0; i < invInx.length; i++) {
			if (invVal[i] > 0) {
				return true;
			}
		}
		return false;
	}

	// Muestra el inventario
	public void inv() {
		System.out.println("Inventario:");
		for (int i = 0; i < invInx.length; i++) {
			if (invVal[i] > 0) {
				System.out.printf("%02d - %s (x%d)\n", i + 1, invInx[i].getNombre(), invVal[i]);
			}
		}
		if (!this.getInv())
			System.out.println("Inventario vacio.");
	}

	// Descansar
	public void des() {
		String resp;
		do {
			System.out.println("d - Descansar durante 8 horas y recuperar vida\ni - Usar objeto");
			resp = sc.nextLine();
			sc = new Scanner(System.in);
			if (resp.equalsIgnoreCase("d")) {
				this.tiempo(480);
				vida += 20;
				if (vida > vidaMax)
					vida = vidaMax;
			} else if (resp.equalsIgnoreCase("i")) {
				this.objeto();
			} else {
				System.out.println("Usa la opción correcta");
				sc = new Scanner(System.in);
			}
		} while (!resp.equalsIgnoreCase("d"));
	}

	// Usar objeto
	public void objeto() {
		int obj = 0;
		boolean salir = false;
		while (!salir) {
			this.inv();
			if (this.getInv()) {
				System.out.println("\nPARA SALIR (0)\n");
				try {
					obj = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Introduce el número de la posicion.");
					sc = new Scanner(System.in);
				}
				sc = new Scanner(System.in);
				boolean enc = false, usa = false;
				for (int i = 0; i < invInx.length && !enc && obj != 0; i++) {
					if (obj - 1 == i) {
						if (invVal[i] > 0) {
							if (invInx[i].getVida() != 0) {
								if (vida < vidaMax) {
									this.vida += invInx[i].getVida();
									usa = true;
								}
								if (vida >= vidaMax) {
									System.out.println("Tu vida está al máximo");
									this.vida = vidaMax;
								}
								System.out.printf("Vida %d/%d\n", vida, vidaMax);
							}
							if (invInx[i].getHambre() != 0) {
								if (hambre < hambreMax - 1) {
									this.hambre += invInx[i].getHambre();
									usa = true;
								}
								if (hambre >= hambreMax - 1) {
									System.out.println("Tu hambre está al máximo");
									this.hambre = hambreMax;
								}
								System.out.printf("Hambre %.0f/%d\n", hambre, hambreMax);
							}
							if (invInx[i].getSed() != 0) {
								if (sed < sedMax - 0.1) {
									this.sed += invInx[i].getSed();
									usa = true;
								}
								if (sed >= sedMax - 1) {
									System.out.println("Tu sed está al máximo");
									this.sed = sedMax;
								}
								System.out.printf("Sed %.0f/%d\n", sed, sedMax);
							}
							if (invInx[i].getInfecc() != 0) {
								if (infecc > infeccMin) {
									this.infecc -= invInx[i].getInfecc();
									usa = true;
								}
								if (infecc <= infeccMin) {
									System.out.println("Tu infección está reducida al máximo");
									this.infecc = infeccMin;
								}
								System.out.printf("Infeccion %d/%d\n", infecc, infeccMin);
							}
							if (invInx[i].getTipo().equalsIgnoreCase("armaB")) {
								this.equipar(invInx[i]);
							}
							if (usa) {
								invVal[i]--;
								this.tiempo(15);
							}
						}
						enc = true;
					}
				}
				if (!enc && obj != 0)
					System.out.println("No tienes ese objeto");
				if (obj == 0)
					salir = true;
			} else if (!this.getInv())
				salir = true;
		}
	}

	// Equipar arma
	public void equipar(Objeto o) {
		if (!equipado) {
			ataque += o.getAtaque();
			armaEquipada = o.getNombre();
			equipado = true;
			System.out.printf("¡Has equipado %s!\n", o.getNombre());
		} else if (equipado) {
			boolean salir = false;
			do {
				System.out.printf("¿Desequipar %s y equipar %s? (s/n)\n", armaEquipada, o.getNombre());
				String elegir = sc.nextLine();
				if (elegir.equalsIgnoreCase("s")) {
					System.out.printf("¡Has cambiado %s por %s!\n", armaEquipada, o.getNombre());
					ataque = ataqueMin;
					ataque += o.getAtaque();
					armaEquipada = o.getNombre();
					salir = true;
				} else if (elegir.equalsIgnoreCase("n")) {
					salir = true;
				} else
					sc = new Scanner(System.in);
			} while (!salir);
		}
	}

	// Atacar Blanca
	public void ataca(Enemigo z) {
		z.recibeDaño(this.getAtaque());
		if (z.getVida() > 0) {
			this.vida -= z.getAtaque();
			this.infecc += z.getInfecc();
		}

	}

	// Encuentro de batalla
	public void pelea(Enemigo z) {
		String accion;
		while (this.getVida() > 0 && this.getInfecc() < 100 && z.getVida() > 0) {
			do {
				System.out.printf("%s - Vida: %d - Infeccion: %d\n", this.getNombre(), this.getVida(),
						this.getInfecc());
				z.muestra();
				System.out.printf(
						"\nACCIONES" + "\n---------------\n" + "a - Atacar\n" + "d - Disparar\n" + "o - Objetos\n" + "---------------\n");
				accion = sc.nextLine();
				sc = new Scanner(System.in);
			} while (!accion.equalsIgnoreCase("a") && !accion.equalsIgnoreCase("o") && !accion.equalsIgnoreCase("d"));
			switch (accion) {
			case "a":
				this.ataca(z);
				break;
			case "d":
				this.disparaArmaF(z);
				break;
			case "o":
				this.objeto();
				if (z.getVida() > 0) {
					this.vida -= z.getAtaque();
					this.infecc += z.getInfecc();
				}
				break;
			}
		}
		if (z.getVida() <= 0)
			System.out.println("¡VICTORIA!");
		this.sumarScore(100 * z.getNivel());
	}
}