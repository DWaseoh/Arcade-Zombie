# Arcade-Zombie
-Juego de supervivencia Zombie por terminal en Java-Fase del desarrollo: Alpha.

Algunas intrucciones improvisadas.

Para empezar a jugar nombra a tu personaje.

ACCIONES
Se utilizan escribiendo la letra correspondiente y pulsando Intro.

e - Explorar {
  Al explorar te puedes encontrar con un zombie o puedes elegir donde deseas explorar.
  Exploracion {
    h - Hospital: Para encontrar objetos que curarán tu salud.
    s - Supermercado: Para encontrar objetos que restablecerán tus puntos de hambre y sed.
    e - Estación de policias: Para encontrar armas, tanto blancas como de fuego.
  }
  Combate {
    a - Atacar: Ataque cuerpo a cuerpo con el arma que lleves equipada.
    d - Disparar: Si tienes armas de fuego con su correspondientes balas podrás disparar. (Estilo ataque mágico RPG clásico, las armas son el ataque, las balas el maná)
    o - Objetos: Podrás usar cualquier objeto durante la batalla, también equipar diferentes armas.
  }
}

d - Descansar {
  d - Descansar durante 8 horas y recuperar vida. (Tu hambre y sed disminuirán en esas 8 horas, ¡Usa el descanso con cabeza!)
  i - Usar objeto: Podrás usar todos los objetos que se te antojen, así como equipar armas cuerpo a cuerpo.
}

p - Personaje {
  Muestra las estadisticas
  Nombre: El nombre que escribiste al inicio.
  Vida: Los puntos de vida del personaje. (Al llegar a 0 muere desangrado)
  Hambre: Los puntos de hambre del personaje. (Al llegar a 0 muere de hambre)
  Sed: Idem puntos de hambre. (Al llegar a 0 muere de sed)
  Infeccion: Cada ataque de un zombie infecta al personaje (Al llegar a 100 muere convertido en zombie)
  Ataque: Ataque cuerpo a cuerpo (Aumenta con las armas blancas)
  Arma equipada: Arma cuerpo a cuerpo equipada actualmente.
  Hora: Horas y minutos transcurridos desde el inicio de la partida (Tiempo en relación a las acciones, no tiempo real. Formato 24h)
  Días vivos: Días dentro del juego.
}

i - Inventario {
  Puedes consultar tu inventario sin usar los objetos. Solo descansando puedes usarlos.
}

t - Terminar {
  Para finalizar el juego.
}
