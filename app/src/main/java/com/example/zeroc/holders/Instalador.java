import java.io.IOException;

public class Instalador {
	
	public static void main(String[] args) throws IOException {
		
		/*
		Historia h1 = new Historia("The Holder of the End");
		h1.setInicio("ciudad", "pais", true);
		
		
		Bloque b1 = new Bloque("decision");
		Bloque b2 = new Bloque("simple");
		Bloque b3 = new Bloque("random");
		
		b1.setTexto("bloque eleccion");
		b1.addOpcion("b2", b2, "vivo");
		b1.addOpcion("b3", b3, "vivo");
		
		b2.setTexto("bloque simple, mueres");
		b2.addOpcion("mueres", null, "muerto");
		
		b3.setTexto("bloque aleatorio, vives o huyes");
		b3.addOpcion("huyes", null, "huye");
		b3.addOpcion("vives", null, "vivo");
		
		h1.addBloque(b1);
		h1.addBloque(b2);
		h1.addBloque(b3);
		
		h1.ejecutar();
		*/
		
		Historia h2 = new Historia("The Holder of the Ambition");
		h2.setInicio("EEUU", "New York", true);
		
		
		Bloque b21 = new Bloque("decision");
		Bloque b22 = new Bloque("simple");
		Bloque b23 = new Bloque("decision");
		Bloque b24 = new Bloque("simple");
		Bloque b25 = new Bloque("simple");
		
		b21.setTexto("El sonido que saldrá de la boca del trabajador será como un suspiro, y quiza una reacción, quizá no estés seguro de si fue alguna reacción del todo. \nEllos te llevaran adelante a una escalera que sólo va hacia arriba, y estará iluminada por muchas ventanas. \nEn la cima de esas escaleras, el trabajador te dejará viajar por el pasillo solo, y la calma del pasillo iluminado por las ventanas se verá convertido en un lugar asustadizo y desajustado. Ves una sombra viajar por la pared");
		b21.addOpcion("no la sigas", b23, "vivo");
		b21.addOpcion("síguela", b22, "vivo");
		
		b22.setTexto("La sombra te lleva  a un lugar donde no tienes esperanza de volver, a un lugar donde tu propio silencio te asusta y falla.");
		b22.addOpcion("Has muerto", null, "muerto");
		
		b23.setTexto("Si llegas al final del pasillo, sin perder de vista tu meta, verás una puerta sin cerradura, manilla ni frenamientos, esperando por ti con una suave luz.");
		b23.addOpcion("Eliges no entrar en ella y mirar otras puertas", b24, "vivo");
		b23.addOpcion("Entras en la sala", b25, "vivo");
		
		b24.setTexto("Abres otra de las puertas y te encuentras con la sombra que cierra la puerta a tu espalda.");
		b24.addOpcion("mueres", null, "muerto");	
		
		b25.setTexto("encontrarás un cuarto iluminado por ventanas que cubren toda la amplitud de las paredes, muy altas para llegar, y brillan con una luz que parece estar lejos de ser natural como la del sol y la luna. \nEn el centro del cuarto habrá un alto y aparentemente saludable hombre, parado desnudo y mirando afuera en la luz.\n Su cuerpo está cubierto en incontables tatuajes y cicatrices, donde nada de piel es reconocible en lo que una vez fue su rostro. \nSi miras donde él mira, no verás nada, y no aprenderás nada. Él no reaccionará a ninguna acción o palabras más que la pregunta: ¿Que los une juntos? \nEl hombre se dará vuelta a mirarte a los ojos y comenzará a hablar en bajo tono. \nCuando termine de hablar, se agarrará del pecho y se arrancará las suturas restantes de una de sus más notorias cicatrices y comenzará a sangrar profusamente. \nMientras él lentamente sangra hasta morir, llegará a ti con sus sangrientas suturas. \nSus últimas palabras pueden ser oídas a través de su propia sangre brotante, \n“… Escoger el buscarlos, lleva a un destino inevitable”.");
		b25.addOpcion("Este grupo de suturas es el Objeto 10 de 538. El cómo los uses depende de lo que oigas.", null, "vivo");
		
		h2.addBloque(b21);
		h2.addBloque(b22);
		h2.addBloque(b23);		
		h2.addBloque(b24);
		h2.addBloque(b25);
		
		h2.save();
		
		
		Historia h3 = new Historia("The Holder of the End");
		h3.setInicio("España", "Viana", true);
		
		
		Bloque b31 = new Bloque("random");
		Bloque b32 = new Bloque("decision");
		Bloque b33 = new Bloque("decision");
		Bloque b34 = new Bloque("random");
		Bloque b3x = new Bloque("random");
		Bloque b35 = new Bloque("simple");
		Bloque b36 = new Bloque("decision");
		Bloque b37 = new Bloque("decision");
		Bloque b38 = new Bloque("simple");
		Bloque b39 = new Bloque("decision");
		Bloque b310 = new Bloque("simple");
		Bloque b311 = new Bloque("simple");
		
		b31.setTexto(" El rostro del trabajador se pondrá blanco como si hubiera visto un fantasma. \nEntonces te llevará a una puerta de madera y te dejará allí. Tendrás que golpear tres veces.");
		b31.addOpcion("", b32, "vivo");
		b31.addOpcion("", b33, "vivo");
		
		b32.setTexto("Oyes la voz de un viejo decir “Entra”:");
		b32.addOpcion("Entra en la sala", b34, "vivo");
		b32.addOpcion("Da la vuelta y vete", null, "huye");
		
		b33.setTexto("Oyes la voz de un joven decir “No gracias”");
		b33.addOpcion("Corre!", null, "huye");
		b33.addOpcion("Golpea otra vez", b35, "vivo");
		
		b34.setTexto("Te encuentras en un bosque de día, sigues al sol. \nSigues por el camino sin importar qué tipo de bellezas u horrores puedas ver. \nEl camino se bifurca...");
		b34.addOpcion("", b36, "vivo");
		b34.addOpcion("", b37, "vivo");
		
		b3x.setTexto("Sigues adelante por el camino, el cual parece no variar un ápice. Éste vuelve a bifurcarse.");
		b3x.addOpcion("", b36, "vivo");
		b3x.addOpcion("", b37, "vivo");
		
		b35.setTexto("Sientes que algo se mueve a tu espalda. Todo es oscuridad ahora.");
		b35.addOpcion("Has muerto", null, "muerto");
		
		b36.setTexto("Uno lleva a una mansión el otro camino sigue.");
		b36.addOpcion("Sigue el camino", b3x, "vivo");
		b36.addOpcion("Ve hacia la mansión", b38, "vivo");
		
		b37.setTexto("Uno lleva a una cabaña el otro camino sigue.");
		b37.addOpcion("Entra en la cabaña", b39, "vivo");
		b37.addOpcion("Sigue el camino", b3x, "vivo");
		
		b38.setTexto("Caminas hacia la casa, pero osta parece estar siempre a la misma distacia. \nDas la vuelta y deshaces tu camino. Mas, al girarte, descubres que la mansion sigue en el mismo sitio y la bifurcación ha desaparecido. \nSigues caminando hasta que tu cuerpo se consume.");
		b38.addOpcion("Has muerto", null, "muerto");
		
		b39.setTexto("Un hombre a tu espalda comenzará a hablar con una voz gentil y agradable y a la vez brutal y asesina. \nEscucha cuidadosamente lo que dice, podrías ser pronto el único que conoce el destino de ellos. \nTan pronto el hombre acabe de contar su pequeña historia, te pedirá que te des vuelta, porque quiere darte un regalo.");
		b39.addOpcion("No te muevas", b310, "vivo");
		b39.addOpcion("Gírate", b311, "vivo");
		
		b310.setTexto("Caminas hacia atrás hasta llegar a algo solido, un escritorio. \nCierras tus ojos y giras tu cuerpo parcialmente para poder llegar al hombre y recibir el regalo. \nCuando toque tu mano, ciérrala y camina de vuelta a la puerta de donde viniste. \nCuando la abras, di las palabras “Nos encontraremos otro día” y camina afuera. Estarás de vuelta en la institución mental.\nAhora, abre tu mano y mira el regalo. El hueso de un dedo es el Objeto 12 de 538. No todo muere realmente.");
		b310.addOpcion("", null, "vivo");
		
		b311.setTexto("El hombre rodea tu garganta con sus manos, y aprieta...");
		b311.addOpcion("", null, "muerto");
		
		
		
		h3.addBloque(b31);
		h3.addBloque(b32);
		h3.addBloque(b33);
		
		h3.save();
		
		Historia h4 = new Historia("The Holder of the Present");
		h4.setInicio("Rusia", "Minsk", true);
		
		
		Bloque b41 = new Bloque("random");
		Bloque b42 = new Bloque("decision");
		Bloque b43 = new Bloque("simple");
		Bloque b44 = new Bloque("simple");
		Bloque b45 = new Bloque("decision");
		Bloque b46 = new Bloque("simple");
		
		b41.setTexto("El trabajador te mirará vagamente; tendrás que preguntar de nuevo. \nUna vez el trabajador comprenda tu pedido, te llevará por una puerta a un pasillo que parece una extensión del infierno mismo. \nEn este pasillo no encontrarás nada más que la oscuridad y el sentimiento de inimaginable horror.");
		b41.addOpcion("", b42, "vivo");
		b41.addOpcion("", b43, "vivo");
		
		b42.setTexto("Llegas a oír un chillido venir de tu derecha...");
		b42.addOpcion("Da la vuelta y escapa", null, "huye");
		b42.addOpcion("Cierra los ojos y espera", b44, "vivo");
		
		b43.setTexto("Sigues al trabajador hasta que abra la puerta en el otro final del pasillo. Ahora te dirá que entres, y se irá. \n En este cuarto sólo encontrarás dos cosas: una niña desnuda cuya mano izquierda es un muñón planchado, aparentemente rasgado por una mordida de otro mundo, y la cerradura que ella cuida. \nDebes mirar la cerradura y no quitar tus ojos de ella. No puedes decir nada, excepto hacerle una pregunta a la niña: ¿Por qué Ellos están unidos?");
		b43.addOpcion("", b45, "vivo");
		
		b44.setTexto("Demonios gritando hablas incomprensibles de bocas llenas con venenos mortales te rodean...");
		b44.addOpcion("", null, "muerto");
		
		b45.setTexto("Ahora, mueve tu mirada hacia la cara de la niña. \nElla te mirará y te dirá la más repugnante historia del presente, de cómo ha llegado a ser, como es ahora y como será eventualmente. \nEsta niña lentamente se moverá hacia ti...");
		b45.addOpcion("No te muevas", b46, "vivo");
		b45.addOpcion("Huye!", null,"huye");
		
		b46.setTexto("Pondrá la pieza desgarrada en pudrición, que una vez fue su mano, en tu hombro. \nTe susurrará en el oído: “La hora ha llegado, y ahora debes morir”. No reacciones a esta declaración. \nSólo sigue mirándola a los ojos y eventualmente sentirás algo siendo empujado hacia tu mano. \nEl llavero es el Objeto 17 de 538. Sólo las llaves que fueron hechas para él pueden ser puestas ahí, las demás serán repelidas.");
		b46.addOpcion("", null, "vivo");
		
		
		
		h4.addBloque(b41);
		h4.addBloque(b42);
		h4.addBloque(b43);
		h4.addBloque(b44);
		h4.addBloque(b45);
		h4.addBloque(b46);
		
		h4.save();
		
		
		Historia h5 = new Historia("The Holder of the Rage");
		h5.setInicio("Turquia", "Ankara", true);
		
		
		Bloque b51 = new Bloque("simple");
		Bloque b52 = new Bloque("decision");
		Bloque b53 = new Bloque("simple");
		Bloque b54 = new Bloque("simple");
		Bloque b55 = new Bloque("random");
		Bloque b56 = new Bloque("simple");
		Bloque b57 = new Bloque("simple");
		
		b51.setTexto("La persona aparecerá silenciosa y te mostrará una puerta, entonces se irá caminando. \nCuando entres a la puerta, estarás mirando hacia abajo por una escalera que desciende a la oscuridad. \nCuando bajes la escalera, comenzarás a oír gritos. Provendrán de una garganta de origen indeterminado.");
		b51.addOpcion("", b52, "vivo");
		
		b52.setTexto("A mitad de camino, el grito se detiene");
		b52.addOpcion("“¡Reanuda tu negocio! \n¡No deseo entrometerme!”", b53, "vivo");
		b52.addOpcion("Quédate quieto. \nContén la respiración", b54, "vivo");
		
		b53.setTexto("El grito continua. Eventualmente, verás una luz venir de las rendijas en una puerta. \nVe por esta puerta y estarás en lo que parece un calabozo medieval. \nCráneos ahuecados llenados con velas que sirven como linternas, y líneas de esqueletos en las paredes. \nAhí habrá una mesa de madera enfrente de las llamas de una fogata. \nEn esta mesa estará la cabeza cercenada de una niña de 4 años, mirando hacia delante con ojos vidriosos.");
		b53.addOpcion("", b55, "vivo");
		
		b54.setTexto("El grito no se ha detenido, sino que has dejado de oirlo. \n El resto de tus sentidos se van apagando poco a poco. \n Hasta que es tu cordura lo que se apaga.");
		b54.addOpcion("", null, "muerto");
		
		b55.setTexto("Ve a la mesa y mira a la cabeza a los ojos. Con voz limpia y comandante pregunta: ¿Quién los detendrá de estar juntos? \nLa cabeza te mirará a los ojos y te contará la historia de un hombre. \nTe dirá toda su historia, desde su violento nacimiento, hasta lo que esté haciendo en todo momento. \nSus hechos serán recontados en horrible detalle. Él es un asesino de lo que no gusta ser visto, y es sólo un demente.");
		b55.addOpcion("", b56, "vivo");
		b55.addOpcion("", b57, "vivo");
		
		b56.setTexto("Al final de la historia, la cabeza te dice: “Él está escuchando nuestra conversación”. \nEres arrastrado fuera del cuarto y nunca serás oído de nuevo. \nExperimentarás las cosas más horribles jamás concebidas, y seguirás vivo hasta que las hayas experimentado todas.");
		b56.addOpcion("", null, "muerto");
		
		b57.setTexto("Al final de la historia, la cabeza te dice: “Él está en otra parte”, es porque Él ahora te busca. Él no se detendrá hasta que estés muerto o los Objetos se hayan reunido. \nLa cabeza dirá que la levantes. Levántala por el cabello y mira la mesa donde estaba. \nAhí habrá una aguja, cubierta en sangre coagulada, semen, pus, e incontables sustancias inidentificables. \nEsa aguja es el Objeto 21 de 538. La caza ha comenzado, y el reloj hace tic tac.");
		b57.addOpcion("", null, "vivo");
		
		h5.addBloque(b51);
		h5.addBloque(b52);
		h5.addBloque(b53);
		h5.addBloque(b54);
		h5.addBloque(b55);
		h5.addBloque(b56);
		h5.addBloque(b57);
		
		h5.ejecutar();
	}
}




