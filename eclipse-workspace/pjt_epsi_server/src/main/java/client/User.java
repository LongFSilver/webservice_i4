package client;

import java.util.ArrayList;
import java.util.List;
import webservices.Movie;
import webservices.Serie;
//import webservices.Serie;
import io.spring.guides.gs_producing_web_service.Music;


/**
 * @author cours
 *
 */
public class User {

	protected List<Movie> collectionMovie = new ArrayList<Movie>();
	protected List<Serie> collectionSerie = new ArrayList<Serie>();
	protected List<Music> collectionMusic = new ArrayList<Music>();

	protected String username;

	protected int id ;

	public User (String username, int id) {
		this.username=username;
		this.id=id;
	}
	/**
	 * Obtient la valeur de la propriété username.
	 * 
	 * @return username
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Obtient la valeur de la propriété id.
	 * 
	 * @return id
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public int getId() {
		return id;
	}
	/**
	 * Obtient la valeur de la propriété m.
	 * 
	 * @return m
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public void addMovie(Movie m) {
		collectionMovie.add(m);
	}
	/**
	 * Obtient la valeur de la propriété s.
	 * 
	 * @return s
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public void addSerie(Serie s) {
		collectionSerie.add(s);
	}
	/**
	 * Obtient la valeur de la propriété c.
	 * 
	 * @return c
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public void addMusic(Music c) {
		collectionMusic.add(c);
	}
	/**
	 * Obtient la valeur de la propriété collectionMovie.
	 * 
	 * @return collectionMovie
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public List<Movie> getCollectionMovie(){
		return collectionMovie;
	}
	/**
	 * Obtient la valeur de la propriété CollectionSerie.
	 * 
	 * @return CollectionSerie
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public List<Serie> getCollectionSerie(){
		return collectionSerie;
	}
	/**
	 * Obtient la valeur de la propriété CollectionMusic.
	 * 
	 * @return CollectionMusic
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public List<Music> getCollectionMusic(){
		return collectionMusic;
	}
	/**
	 * Obtient la valeur de la propriété m.
	 * 
	 * @return m
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public void removeMovie(Movie m) {
		collectionMovie.remove(m);
	}
	/**
	 * Obtient la valeur de la propriété s.
	 * 
	 * @return s
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public void removeSerie(Serie s) {
		collectionSerie.remove(s);
	}
	/**
	 * Obtient la valeur de la propriété c.
	 * 
	 * @return c
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public void removeMusic(Music c) {
		collectionMusic.remove(c);
	}
}
