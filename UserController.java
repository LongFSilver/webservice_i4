package client;


import java.util.List;
import java.util.Scanner;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import webservices.Movie;
import webservices.Serie;

public class UserController {

	public static void main(String[] args) {
		int tmp;
		do {

			//CHOIX MEDIA UTILISATEUR
			System.out.println("Location Multimédia\nChoisir un média:\n1-Film\n2-Series\n3-Music\n4-Annuler");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String entry="";
			do {
				
				entry=sc.nextLine();
				tmp = Integer.parseInt(entry);
			}while(tmp < 1 || tmp > 4);

			//CHOIX OPIONS FILMS
			if(tmp==1) {
				int tmpMovie;
				do {
					System.out.println("1-Afficher la bibliothèque\n2-Rechercher un film par son titre\n3-Rechercher un film par son ID\n4-Emprunter\n5-Rendre\n6-Ajout\n7-Suppression\n8-Annuler");
					Scanner scMovie = new Scanner(System.in);
					String entryMovie="";
					do {
						entryMovie=scMovie.nextLine();
						tmpMovie = Integer.parseInt(entryMovie);
					}while(tmpMovie < 1 || tmpMovie > 8);

					//AFFICHAGE BIBLIOTHEQUE
					if(tmpMovie==1) {
						RestTemplate restTemplate= new RestTemplate();
						List<Movie> listMovie=restTemplate.getForObject("http://localhost:8080/movie/listing",List.class);
						System.out.println(listMovie);
					}

					//RECHERCHE FILM PAR TITRE
					if(tmpMovie==2) {
						System.out.print("Titre du film : ");
						Scanner scTitle = new Scanner(System.in);
						String entryTitle="";
						Movie titleMovie;
						entryTitle = scTitle.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						titleMovie=restTemplate.getForObject("http://localhost:8080/movie/"+entryTitle,Movie.class);
						if(titleMovie != null)
							System.out.println("\nLe film est : " + titleMovie.toString()+ "\n");
						else
							System.out.println("\nFilm introuvable.\n");
						System.out.println(titleMovie);
						scTitle.close();
					}

					//RECHERCHE FILM PAR ID
					if(tmpMovie==3) {
						System.out.print("ID du film ");
						Scanner scId = new Scanner(System.in);
						String entryId="";
						Movie id;
						entryId = scId.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						id=restTemplate.getForObject("http://localhost:8080/movie/"+entryId,Movie.class);
						if(id != null)
							System.out.println("\nLe film est : " + id.toString()+ "\n");
						else
							System.out.println("\nFilm introuvable.\n");
						System.out.println(id);
						scId.close();
					}

					//EMPRUNT FILM
					if(tmpMovie==4) {
						System.out.print("Tapez le titre du film que vous souhaitez emprunter: ");
						Scanner scBr = new Scanner(System.in);
						String entryBr="";
						entryBr = scBr.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						restTemplate.put("http://localhost:8080/movie/take/" + entryBr,Movie.class);
						//if(m.isAvailable()==false)
						//System.out.println("\nLe film est : " + m.toString()+ " est indisponible\n");
						scBr.close();
					}

					//RENDRE FILM
					if(tmpMovie==5) {
						System.out.print("Tapez le titre du film que vous souhaitez rendre: ");
						Scanner scGv = new Scanner(System.in);
						String entryGv="";
						entryGv = scGv.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						restTemplate.put("http://localhost:8080/movie/give/" + entryGv,Movie.class);
						scGv.close();
					}

					//AJOUT FILM
					if(tmpMovie==6) {
						System.out.print("Tapez le titre du film que vous souhaitez ajouter: ");
						Scanner scM = new Scanner(System.in);
						String entryM="";
						RestTemplate restTemplate= new RestTemplate();
						HttpEntity<Movie> request = new HttpEntity<>(new Movie());
						@SuppressWarnings("unused")
						String m=restTemplate.postForObject("http://localhost:8080/movie/addmovie" + entryM, request,String.class);
						scM.close();
						//Recherche de films existant dans liste si existant, afficher erreur deja existant
					}

					//SUPPRESSION FILM
					if(tmpMovie==7) {
						System.out.print("Tapez le titre du film que vous souhaitez supprimer: ");
						Scanner scM = new Scanner(System.in);
						String entryM="";
						RestTemplate restTemplate= new RestTemplate();
						HttpEntity<Movie> request = new HttpEntity<>(new Movie());
						restTemplate.delete("http://localhost:8080/movie/"+entryM,request,Movie.class);
						scM.close();
					}
					scMovie.close();
				}while(tmpMovie==8);
			}

			if(tmp==2) {
				//CHOIX OPIONS SERIES
				int tmpSerie;
				do {
					System.out.println("1-Afficher la bibliothèque\n2-Rechercher un serie par son titre\n3-Rechercher un serie par son ID\n4-Emprunter\n5-Rendre\n6-Ajout\n7-Suppression\n8-Annuler");
					Scanner scSerie = new Scanner(System.in);
					String entrySerie="";
					do {
						entrySerie=scSerie.nextLine();
						tmpSerie = Integer.parseInt(entrySerie);
					}while(tmpSerie < 1 || tmpSerie > 8);

					//AFFICHAGE BIBLIOTHEQUE
					if(tmpSerie==1) {
						RestTemplate restTemplate= new RestTemplate();
						Serie listSerie=restTemplate.getForObject("http://localhost:8080/serie/listing",Serie.class);
						System.out.println(listSerie);
					}

					//RECHERCHE SERIE PAR TITRE
					if(tmpSerie==2) {
						System.out.print("Titre du serie : ");
						Scanner scTitle = new Scanner(System.in);
						String entryTitle="";
						Serie titleSerie;
						entryTitle = scTitle.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						titleSerie=restTemplate.getForObject("http://localhost:8080/serie/"+entryTitle,Serie.class);
						if(titleSerie != null)
							System.out.println("\nLe serie est : " + titleSerie.toString()+ "\n");
						else
							System.out.println("\nFilm introuvable.\n");
						System.out.println(titleSerie);
						scTitle.close();
					}

					//RECHERCHE SERIE PAR ID
					if(tmpSerie==3) {
						System.out.print("ID du serie ");
						Scanner scId = new Scanner(System.in);
						String entryId="";
						Serie id;
						entryId = scId.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						id=restTemplate.getForObject("http://localhost:8080/serie/"+entryId,Serie.class);
						if(id != null)
							System.out.println("\nLe serie est : " + id.toString()+ "\n");
						else
							System.out.println("\nSerie introuvable.\n");
						System.out.println(id);
						scId.close();
					}

					//EMPRUNT SERIE
					if(tmpSerie==4) {
						System.out.print("Tapez le titre du serie que vous souhaitez emprunter: ");
						Scanner scBr = new Scanner(System.in);
						String entryBr="";
						entryBr = scBr.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						//						HttpEntity<Serie> request = new HttpEntity<>(new Serie());
						restTemplate.put("http://localhost:8080/serie/take/" + entryBr, String.class);
						//if(m.isAvailable()==false)
						//System.out.println("\nLe film est : " + m.toString()+ " est indisponible\n");
						scBr.close();
					}

					//RENDRE SERIE
					if(tmpSerie==5) {
						System.out.print("Tapez le titre du serie que vous souhaitez rendre: ");
						Scanner scGv = new Scanner(System.in);
						String entryGv="";
						entryGv = scGv.nextLine();
						RestTemplate restTemplate= new RestTemplate();
						restTemplate.put("http://localhost:8080/serie/give/" + entryGv,Serie.class);
						scGv.close();
					}

					//AJOUT SERIE
					if(tmpSerie==6) {
						System.out.print("Tapez le titre du serie que vous souhaitez ajouter: ");
						Scanner scS = new Scanner(System.in);
						String entryS="";
						RestTemplate restTemplate= new RestTemplate();
						HttpEntity<Serie> request = new HttpEntity<>(new Serie());
						@SuppressWarnings("unused")
						String s=restTemplate.postForObject("http://localhost:8080/serie/addserie" + entryS, request,String.class);
						//Recherche de serie existante dans liste si existant, afficher erreur deja existant
						scS.close();

					}
					//SUPPRESSION SERIE
					if(tmpSerie==7) {
						System.out.print("Tapez le titre du serie que vous souhaitez supprimer: ");
						Scanner scM = new Scanner(System.in);
						String entryM="";
						RestTemplate restTemplate= new RestTemplate();
						HttpEntity<Serie> request = new HttpEntity<>(new Serie());
						restTemplate.delete("http://localhost:8080/movie/"+entryM,request,Serie.class);
						scM.close();
					}
					scSerie.close();
				}while(tmpSerie==8);
			}
			if(tmp==3) {
				//CHOIX OPIONS MUSIC	
			}
			//ANNULATION DES OPERATIONS		
		}while(tmp!=4);
	}
}
