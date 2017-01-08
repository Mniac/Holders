package com.example.zeroc.holders;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Instalador extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indica el layout para esta actividad.
        // El archivo de layout se guarda en res/layout/layout_actividad2.xml
        this.setContentView(R.layout.install);
        try {
            install();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.finish();
    }

	public void install() throws IOException {

		Historia h2 = new Historia("The Holder of the Ambition");
		h2.setInicio("EEUU", "New York", true);
		
		
		Bloque b21 = new Bloque("decision");
		Bloque b22 = new Bloque("simple");
		Bloque b23 = new Bloque("decision");
		Bloque b24 = new Bloque("simple");
		Bloque b25 = new Bloque("simple");
		Bloque b26 = new Bloque("simple");
		
		b21.setTexto("El sonido que saldrá de la boca del trabajador será como un suspiro, y quiza una reacción, quizá no estás seguro de si fue alguna reacción del todo. Ellos te llevaran adelante a una escalera que sólo va hacia arriba, y estará iluminada por muchas ventanas. En la cima de esas escaleras, el trabajador te dejará viajar por el pasillo solo, y la calma del pasillo iluminado por las ventanas se verá convertido en un lugar asustadizo y desajustado. Ves una sombra viajar por la pared");
		b21.addOpcion("no la sigas", b23, "vivo");
		b21.addOpcion("síguela", b22, "vivo");
		
		b22.setTexto("La sombra te lleva  a un lugar donde no tienes esperanza de volver, a un lugar donde tu propio silencio te asusta y falla.");
		b22.addOpcion("Has muerto", null, "muerto");
		
		b23.setTexto("Si llegas al final del pasillo, sin perder de vista tu meta, verás una puerta sin cerradura, manilla ni frenamientos, esperando por ti con una suave luz.");
		b23.addOpcion("Eliges no entrar en ella y mirar otras puertas", b24, "vivo");
		b23.addOpcion("Entras en la sala", b25, "vivo");
		
		b24.setTexto("Abres otra de las puertas y te encuentras con la sombra que cierra la puerta a tu espalda.");
		b24.addOpcion("mueres", null, "muerto");	
		
		b25.setTexto("Encontrarás un cuarto iluminado por ventanas que cubren toda la amplitud de las paredes, muy altas para llegar, y brillan con una luz que parece estar lejos de ser natural como la del sol y la luna. En el centro del cuarto habrá un alto y aparentemente saludable hombre, parado desnudo y mirando afuera en la luz. Su cuerpo está cubierto en incontables tatuajes y cicatrices, donde nada de piel es reconocible en lo que una vez fue su rostro. Si miras donde él mira, no verás nada, y no aprenderás nada. Él no reaccionará a ninguna acción o palabras más que la pregunta: ¿Que los une juntos?");
		b25.addOpcion("",b26,"vivo");

		b26.setTexto("El hombre se dará vuelta a mirarte a los ojos y comenzará a hablar en bajo tono. Cuando termine de hablar, se agarrará del pecho y se arrancará las suturas restantes de una de sus más notorias cicatrices y comenzará a sangrar profusamente. Mientras él lentamente sangra hasta morir, llegará a ti con sus sangrientas suturas. Sus últimas palabras pueden ser oídas a través de su propia sangre brotante, 'Escoger el buscarlos, lleva a un destino inevitable'.");
		b26.addOpcion("Este grupo de suturas es el Objeto 10 de 538. El cómo los uses depende de lo que oigas.", null, "vivo");

		h2.addBloque(b21);
		h2.addBloque(b22);
		h2.addBloque(b23);		
		h2.addBloque(b24);
		h2.addBloque(b25);
		h2.addBloque(b26);
		

		writeHistoria(h2);
		
		
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
		
		b31.setTexto(" El rostro del trabajador se pondrá blanco como si hubiera visto un fantasma. Entonces te llevará a una puerta de madera y te dejará allí. Tendrás que golpear tres veces.");
		b31.addOpcion("", b32, "vivo");
		b31.addOpcion("", b33, "vivo");
		
		b32.setTexto("Oyes la voz de un viejo decir 'Entra':");
		b32.addOpcion("Entra en la sala", b34, "vivo");
		b32.addOpcion("Da la vuelta y vete", null, "huye");
		
		b33.setTexto("Oyes la voz de un joven decir 'No gracias'");
		b33.addOpcion("Corre!", null, "huye");
		b33.addOpcion("Golpea otra vez", b35, "vivo");
		
		b34.setTexto("Te encuentras en un bosque de día, sigues al sol. Sigues por el camino sin importar qué tipo de bellezas u horrores puedas ver. El camino se bifurca...");
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
		
		b38.setTexto("Caminas hacia la casa, pero osta parece estar siempre a la misma distacia. Das la vuelta y deshaces tu camino. Mas, al girarte, descubres que la mansion sigue en el mismo sitio y la bifurcación ha desaparecido. Sigues caminando hasta que tu cuerpo se consume.");
		b38.addOpcion("Has muerto", null, "muerto");
		
		b39.setTexto("Un hombre a tu espalda comenzará a hablar con una voz gentil y agradable y a la vez brutal y asesina. Escucha cuidadosamente lo que dice, podrías ser pronto el único que conoce el destino de ellos. Tan pronto el hombre acabe de contar su pequeña historia, te pedirá que te des vuelta, porque quiere darte un regalo.");
		b39.addOpcion("No te muevas", b310, "vivo");
		b39.addOpcion("Gírate", b311, "vivo");
		
		b310.setTexto("Caminas hacia atrás hasta llegar a algo solido, un escritorio. Cierras tus ojos y giras tu cuerpo parcialmente para poder llegar al hombre y recibir el regalo. Cuando toque tu mano, ciérrala y camina de vuelta a la puerta de donde viniste. Cuando la abras, di las palabras ¿Nos encontraremos otro día? y camina afuera. Estarás de vuelta en la institución mental. Ahora, abre tu mano y mira el regalo. El hueso de un dedo es el Objeto 12 de 538. No todo muere realmente.");
		b310.addOpcion("", null, "vivo");
		
		b311.setTexto("El hombre rodea tu garganta con sus manos, y aprieta...");
		b311.addOpcion("", null, "muerto");
		
		
		
		h3.addBloque(b31);
		h3.addBloque(b32);
		h3.addBloque(b33);

		writeHistoria(h3);
		
		Historia h4 = new Historia("The Holder of the Present");
		h4.setInicio("Rusia", "Minsk", true);
		
		
		Bloque b41 = new Bloque("random");
		Bloque b42 = new Bloque("decision");
		Bloque b43 = new Bloque("simple");
		Bloque b44 = new Bloque("simple");
		Bloque b45 = new Bloque("decision");
		Bloque b46 = new Bloque("simple");
		
		b41.setTexto("El trabajador te mirará vagamente; tendrás que preguntar de nuevo. Una vez el trabajador comprenda tu pedido, te llevará por una puerta a un pasillo que parece una extensión del infierno mismo. En este pasillo no encontrarás nada más que la oscuridad y el sentimiento de inimaginable horror.");
		b41.addOpcion("", b42, "vivo");
		b41.addOpcion("", b43, "vivo");
		
		b42.setTexto("Llegas a oír un chillido venir de tu derecha...");
		b42.addOpcion("Da la vuelta y escapa", null, "huye");
		b42.addOpcion("Cierra los ojos y espera", b44, "vivo");
		
		b43.setTexto("Sigues al trabajador hasta que abra la puerta en el otro final del pasillo. Ahora te dirá que entres, y se irá. En este cuarto sólo encontrarás dos cosas: una niña desnuda cuya mano izquierda es un muñón planchado, aparentemente rasgado por una mordida de otro mundo, y la cerradura que ella cuida. Debes mirar la cerradura y no quitar tus ojos de ella. No puedes decir nada, excepto hacerle una pregunta a la niña: ¿Por qué Ellos están unidos?");
		b43.addOpcion("", b45, "vivo");
		
		b44.setTexto("Demonios gritando hablas incomprensibles de bocas llenas con venenos mortales te rodean...");
		b44.addOpcion("", null, "muerto");
		
		b45.setTexto("Ahora, mueve tu mirada hacia la cara de la niña. Ella te mirará y te dirá la más repugnante historia del presente, de cómo ha llegado a ser, como es ahora y como será eventualmente. Esta niña lentamente se moverá hacia ti...");
		b45.addOpcion("No te muevas", b46, "vivo");
		b45.addOpcion("Huye!", null,"huye");
		
		b46.setTexto("Pondrá la pieza desgarrada en pudrición, que una vez fue su mano, en tu hombro. Te susurrará en el oído: 'La hora ha llegado, y ahora debes morir'. No reacciones a esta declaración. Sólo sigue mirándola a los ojos y eventualmente sentirás algo siendo empujado hacia tu mano. El llavero es el Objeto 17 de 538. Sólo las llaves que fueron hechas para él pueden ser puestas ahí, las demás serán repelidas.");
		b46.addOpcion("", null, "vivo");
		
		
		
		h4.addBloque(b41);
		h4.addBloque(b42);
		h4.addBloque(b43);
		h4.addBloque(b44);
		h4.addBloque(b45);
		h4.addBloque(b46);

		writeHistoria(h4);
		
		
		Historia h5 = new Historia("The Holder of the Rage");
		h5.setInicio("Turquia", "Ankara", true);
		
		
		Bloque b51 = new Bloque("simple");
		Bloque b52 = new Bloque("decision");
		Bloque b53 = new Bloque("simple");
		Bloque b54 = new Bloque("simple");
		Bloque b55 = new Bloque("random");
		Bloque b56 = new Bloque("simple");
		Bloque b57 = new Bloque("simple");
		
		b51.setTexto("La persona aparecerá silenciosa y te mostrará una puerta, entonces se irá caminando. Cuando entres a la puerta, estarás mirando hacia abajo por una escalera que desciende a la oscuridad. Cuando bajes la escalera, comenzarás a oír gritos. Provendrán de una garganta de origen indeterminado.");
		b51.addOpcion("", b52, "vivo");
		
		b52.setTexto("A mitad de camino, el grito se detiene");
		b52.addOpcion("'!Reanuda tu negocio! !No deseo entrometerme!'", b53, "vivo");
		b52.addOpcion("Quédate quieto. Contén la respiración", b54, "vivo");
		
		b53.setTexto("El grito continua. Eventualmente, verás una luz venir de las rendijas en una puerta. Ve por esta puerta y estarás en lo que parece un calabozo medieval. Cráneos ahuecados llenados con velas que sirven como linternas, y líneas de esqueletos en las paredes. Ahí habrá una mesa de madera enfrente de las llamas de una fogata. En esta mesa estará la cabeza cercenada de una niña de 4 años, mirando hacia delante con ojos vidriosos.");
		b53.addOpcion("", b55, "vivo");
		
		b54.setTexto("El grito no se ha detenido, sino que has dejado de oirlo. El resto de tus sentidos se van apagando poco a poco. Hasta que es tu cordura lo que se apaga.");
		b54.addOpcion("", null, "muerto");
		
		b55.setTexto("Ve a la mesa y mira a la cabeza a los ojos. Con voz limpia y comandante pregunta: ¿Quién los detendrá de estar juntos? La cabeza te mirará a los ojos y te contará la historia de un hombre. Te dirá toda su historia, desde su violento nacimiento, hasta lo que está haciendo en todo momento. Sus hechos serán recontados en horrible detalle. Él es un asesino de lo que no gusta ser visto, y es sólo un demente.");
		b55.addOpcion("", b56, "vivo");
		b55.addOpcion("", b57, "vivo");
		
		b56.setTexto("Al final de la historia, la cabeza te dice: 'Él está escuchando nuestra conversación'. Eres arrastrado fuera del cuarto y nunca serás oído de nuevo. Experimentarás las cosas más horribles jamás concebidas, y seguirás vivo hasta que las hayas experimentado todas.");
		b56.addOpcion("", null, "muerto");
		
		b57.setTexto("Al final de la historia, la cabeza te dice: 'Él está en otra parte', es porque él ahora te busca. Él no se detendrá hasta que estás muerto o los Objetos se hayan reunido. La cabeza dirá que la levantes. Levántala por el cabello y mira la mesa donde estaba. Ahí habrá una aguja, cubierta en sangre coagulada, semen, pus, e incontables sustancias inidentificables. Esa aguja es el Objeto 21 de 538. La caza ha comenzado, y el reloj hace tic tac.");
		b57.addOpcion("", null, "vivo");
		
		h5.addBloque(b51);
		h5.addBloque(b52);
		h5.addBloque(b53);
		h5.addBloque(b54);
		h5.addBloque(b55);
		h5.addBloque(b56);
		h5.addBloque(b57);

		writeHistoria(h5);
	}
	private void writeHistoria(Historia h) throws IOException {
		//Creamos un fujo de salida a disco, pasándole el nombre del archivo en disco o un objeto de la clase File.
		FileOutputStream fileOut= this.openFileOutput(h.getTitulo()+".holder", Context.MODE_PRIVATE);

		//El fujo de salida ObjectOutputStream es el que procesa los datos y se ha de vincular a un objeto fileOut de la clase FileOutputStream .
		ObjectOutputStream salida=new ObjectOutputStream(fileOut);

		//El método writeObject escribe los objetos al flujo de salida y los guarda en un archivo en disco. Por ejemplo, un string y un objeto de la clase Lista.
		salida.writeObject(h);

		//Finalmente, se cierran los flujos
		//System.out.println("GUARDADO");
		salida.close();

	}
}




