package webservices;

/**
 * @author cours
 *
 */
public class Movie {
	protected String title ;
	protected int id ;
	protected int isbn ;
	protected boolean available = true ;
	/**
	 * Obtient la valeur de la propriété titre.
	 * 
	 * @return title
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Définit la valeur de la propriété titre.
	 * 
	 * @param title
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Obtient la valeur de la propriété id.
	 * 
	 * @return id
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public int getId() {
		return id;
	}
	/**
	 * Définit la valeur de la propriété id.
	 * 
	 * @param id
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtient la valeur de la propriété isbn.
	 * 
	 * @return isbn
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public int getIsbn() {
		return isbn;
	}
	/**
	 * Définit la valeur de la propriété isbn.
	 * 
	 * @param isbn
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	/**
	 * Obtient la valeur de la propriété available.
	 * 
	 * @return available
	 *     possible object is
	 *     {@link Boolean}
	 *     
	 */
	public boolean isAvailable() {
		return available;
	}
	/**
	 * Définit la valeur de la propriété available.
	 * 
	 * @param available
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
}