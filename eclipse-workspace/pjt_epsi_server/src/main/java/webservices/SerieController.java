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
@RequestMapping("/serie")
public class SerieController {
	/**
	 * Initialisation des variables index et isbn et d'une liste.
	 *
	 * @param Serie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	private static Map<String,Serie> list = new HashMap<>();
	int index = 1;
	int isbn = 100;

	public SerieController() {
		Serie serie1 = new Serie();
		serie1.setTitle("Vikings");
		serie1.setId(index++);
		serie1.setIsbn(isbn++);
		list.put("Vikings", serie1);

		Serie serie2 = new Serie();
		serie2.setTitle("Punisher");
		serie2.setId(index++);
		serie2.setIsbn(isbn++);
		list.put("Punisher", serie2);
	}

	/**
	 * Ajout d'une serie dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/serie/admin/addserie/titreSerie
	 * @param title
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.POST, value = "admin/addserie/{title}")
	public Boolean postSerie(@PathVariable String title) {
		Serie mySerie = new Serie();
		mySerie.setTitle(title);
		mySerie.setId(index++);
		mySerie.setIsbn(isbn++);
		if(title.equals("")) {	  
			return false;
		}
		list.put(mySerie.getTitle(),mySerie);
		return true;
	}

	/**
	 * Recherche d'une serie dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/serie/"titreSerie"
	 * @param mySerie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{serie}")
	public Serie getSerie(@PathVariable ("serie") String mySerie) {
		return list.get(mySerie);
	}

	/**
	 * Suppression d'une serie dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/serie/admin/"titreSerie"
	 * @param mySerie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "admin/{serie}")
	public Serie removeSerie(@PathVariable ("serie") String mySerie) {
		return list.remove(mySerie);
	}

	/**
	 * Emprunt d'une serie dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/serie/take/"titreSerie"
	 * @param mySerie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/take/{serie}")
	public Serie takeSerie(@PathVariable ("serie") String mySerie) {
		Serie m = list.get(mySerie);
		if (m.isAvailable()==true) {
			m.setAvailable(false);
			return m;
		}
		System.out.println(mySerie+" est indisponible");
		return null;
	}

	/**
	 * Rendre une serie empruntée dans une liste en ajoutant le titre dans l'url:
	 * http://localhost:8080/serie/give/"titreSerie"
	 * @param mySerie
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/give/{serie}")
	public Serie giveSerie(@PathVariable ("serie") String mySerie) {
		Serie m = list.get(mySerie);
		if (m.isAvailable()==false) {
			m.setAvailable(true);
			return m;
		}
		System.out.println(mySerie+" est disponible");
		return null;
	}

	/**
	 * Afficher la liste des series via l'url:
	 * http://localhost:8080/serie/listing"
	 * @return collection
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/listing")
	public List<Serie> listingSeries() {
		List<Serie> collection = new ArrayList<Serie>();
		for(String key : list.keySet()) {
			collection.add(list.get(key));
		}
		return collection;
	}
}
