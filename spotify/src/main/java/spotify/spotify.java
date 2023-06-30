package spotify;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pojos.Artista;

public class spotify {
	
	/*Nos contrataron de la empresa Spotify para desarrollarles un programa nuevo 
	 * que conecte con una base de datos.
		En lo referido al programa, debe poder almacenar la siguiente información
		 por consola:
		 
		- Nombre del artista
		- Genero
		- Cantidad de canciones
		- Cantidad de reproducciones
		- Cantidad de suscriptores
		
		Se debe generar 1 función que calcule la ganancia total del artista, la misma se calcula de la siguiente manera: Ganancia total = cantidad de reproducciones * 0.02 
		(!)  Generarlo para al menos 3 artistas (!)
		
		
		La información se debe imprimir en un TXT de salida. */

	static ArrayList<Artista> artistas = new ArrayList<>();// esto actua como base de datos
	
	
	public static void main(String[] args) {
		
		artistas.add(new Artista("Melendi", "Pop", 44, 20989389, 12343));
		artistas.add(new Artista("Fito y fitipaldis", "Rock", 65, 3449389, 14433));
		artistas.add(new Artista("Estopa", "Pop-rock", 72, 820989, 10343));
		
		init();
		
	}

	private static void init() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("############## Gestion de Artistas ###############");
		System.out.println("                 - Bienvenido -                    ");
		System.out.println("");
		System.out.println("");
		System.out.println("Leyendo base de datos...");

		while(true) {
			
			
			int select;
			System.out.println("Registros obtenidos de la base de datos:");
			System.out.println("   ---------------------------------------------------  ");
			imprimeArtistas();
			System.out.println("   ---------------------------------------------------  ");
			System.out.println("¿Desea editar algun registro? ");
			System.out.println("1	 - Editar artista");
			System.out.println("2	 - Añadir artista");
			System.out.println("3	 - Borrar artista");
			System.out.println("4	 - Guardar progreso");
			System.out.println("Otro - Cancelar");
			try {				
				select = sc.nextInt();
			}catch (Exception e){

		 		break;
		 	}
			
			switch (select) {
			
			case 1:
				
				
				

				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("               --------- Editar ---------");
				System.out.println("   ---------------------------------------------------  ");
				imprimeArtistas();
				System.out.println("   ---------------------------------------------------  ");
				
				
				System.out.println("Ingrese numero de artista: ");
				
				int a = sc.nextInt() - 1;
				
				
				System.out.print("   Inserte nombre:  ");
				String nombre =  sc.next();
				artistas.get(a).setNombre(nombre);
				System.out.println("");
				
				System.out.print("   Inserte genero:  ");
				String genero =  sc.next();
				artistas.get(a).setGenero(genero);
				System.out.println("");
				
				
				System.out.print("   Inserte canciones:  ");
				int canciones =  sc.nextInt();
				artistas.get(a).setCanciones(canciones);
				System.out.println("");
				
				System.out.print("   Inserte reproducciones:  ");
				int repro =  sc.nextInt();
				artistas.get(a).setReproducciones(repro);
				System.out.println("");
				
				
				System.out.print("   Inserte suscripciones:  ");
				int sus =  sc.nextInt();
				artistas.get(a).setSuscripciones(sus);
				System.out.println("");
				break;
			
			case 2:
				
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("               --------- Añadir ---------");
				System.out.println("   ---------------------------------------------------  ");
				
				System.out.print("   Inserte nombre:  ");
				String nombre2 =  sc.next();
				System.out.println("");
				
				System.out.print("   Inserte genero:  ");
				String genero2 =  sc.next();
				System.out.println("");
				
				
				System.out.print("   Inserte canciones:  ");
				int canciones2 =  sc.nextInt();
				System.out.println("");
				
				System.out.print("   Inserte reproducciones:  ");
				int repro2 =  sc.nextInt();
				System.out.println("");
				
				
				System.out.print("   Inserte suscripciones:  ");
				int sus2 =  sc.nextInt();
				System.out.println("");

				artistas.add(new Artista(nombre2,genero2,canciones2,repro2,sus2));
				
				
				break;
			case 3:
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("               --------- Borrar ---------");
				System.out.println("   ---------------------------------------------------  ");
				imprimeArtistas();
				System.out.println("   ---------------------------------------------------  ");
				
				System.out.println("Ingrese numero de artista: ");
				
				int w = sc.nextInt() - 1;
				
				artistas.remove(w);
				System.out.println("Borrado artista " + w);
				
				break;
				
			case 4:
				
				
				guardar();
				
				
				
				break;
			}
			
		
		}
		
		System.out.println("Adios!!");

			
			
			
		}
		
	private static void guardar() {
		
		try {
			//Declarar la ruta y el nombre de archivo con la extension del mismo
		String ruta = ".\\artistas.txt";
		//Inicializo la clase File que me permite crear el archivo.
		File archivo = new File(ruta);
		if(! archivo.exists())
		{
		archivo.createNewFile(); //utilizo el metodo createNewFile() para crear el archivo.
		System.out.println("Se ha generado el archivo.");	
		}
		FileWriter fw = new FileWriter(archivo); //El FileWriter es el encargado de habilitar la opción de escritura
		BufferedWriter bw = new BufferedWriter(fw); //BufferedWritter es el encargado de realizar la acción de escritura.
		
		for(Artista artista : artistas) {
			bw.write(artista.toString());
		}
		
		
		bw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	private static void imprimeArtistas() {
		System.out.println("Nº\t Nombre\t Genero\t Canciones\t Reproducciones\t Suscripciones\t Ganancia($) ");
		int i = 1;
		for(Artista artista : artistas) {
			System.out.println(i + "\t" + artista.toString());
			i++;
		}
	}

}
