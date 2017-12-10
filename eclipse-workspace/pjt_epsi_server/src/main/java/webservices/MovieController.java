package webservices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cours
 *
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
	/**
	 * Initialisation des variables index et isbn et d'une liste.
	 *
	 * @param Movie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	private static Map<String,Movie> list = new HashMap<>();
	int index = 1;
	int isbn = 100;

	public MovieController() {
		Movie movie1 = new Movie();
		movie1.setTitle("Batman");
		movie1.setId(index++);
		movie1.setIsbn(isbn++);
		list.put("Batman", movie1);

		Movie movie2 = new Movie();
		movie2.setTitle("Superman");
		movie2.setId(index++);
		movie2.setIsbn(isbn++);
		list.put("Superman", movie2);
	}

	/**
	 * Ajout d'un film dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/movie/admin/addmovie/titreFilm
	 * @param title
	 *     possible object is
	 *     {@link Boolean }
	 *  
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/admin/addmovie/{title}")
	public Boolean postMovie(@PathVariable String title) {
		Movie myMovie = new Movie();
		myMovie.setTitle(title);
		myMovie.setId(index++);
		myMovie.setIsbn(isbn++);
		if(title.equals("")) {	  
			return false;
		}
		list.put(myMovie.getTitle(),myMovie);
		return true;
	}

	/**
	 * Recherche d'un film dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/movie/"titreFilm"
	 * @param myMovie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{movie}")
	public  Movie getMovie(@PathVariable ("movie") String myMovie) {
		return list.get(myMovie);
	}

	/**
	 * Suppression d'un film dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/movie/admin/"titreFilm"
	 * @param myMovie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/{movie}")
	public Movie removeMovie(@PathVariable ("movie") String myMovie) {
		return list.remove(myMovie);
	}

	/**
	 * Emprunt d'un film dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/movie/take/"titreFilm"
	 * @param myMovie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/take/{movie}")
	public Movie takeMovie(@PathVariable ("movie") String myMovie) {
		Movie m = list.get(myMovie);
		if (m.isAvailable()==true) {
			m.setAvailable(false);
			return m;
		}else
		System.out.println(myMovie+" est indisponible");
		return null;
	}

	/**
	 * Rendre un film emprunté dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/movie/give/"titreFilm"
	 * @param myMovie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/give/{movie}")
	public Movie giveMovie(@PathVariable ("movie") String myMovie) {
		Movie m = list.get(myMovie);
		if (m.isAvailable()==false) {
			m.setAvailable(true);
			return m;
		}
		System.out.println(myMovie+" est disponible");
		return null;
	}

	/**
	 * Afficher la liste des films via l'url:
	 * http://localhost:8080/movie/listing"
	 * @return collection
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/listing")
	public List<Movie> listingMovies() {
		List<Movie> collection = new ArrayList<Movie>();
		for(String key : list.keySet()) {
			collection.add(list.get(key));
		}
		return collection;
	}
}
