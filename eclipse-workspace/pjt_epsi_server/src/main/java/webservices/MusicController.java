package webservices;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import io.spring.guides.gs_producing_web_service.Music;

@Component
public class MusicController extends WebServiceGatewaySupport{
	private static final Map<String,Music> list = new HashMap<>();
	
	public MusicController (){
		Music album1 = new Music();
		album1.setAlbum("Nevermind");
		album1.setArtiste("Nirvana");
		album1.setId("1A25");
		album1.setIsbn("I4587");
		list.put("Nevermind", album1);

		Music album2 = new Music();
		album2.setAlbum("Encore");
		album2.setArtiste("Eminem");
		album2.setId("1A26");
		album2.setIsbn("I4557");
		list.put("Encore", album2);
	}
	
	/**
	 * Recherche d'un album dans une liste
	 * @param music
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	public Music getMusic(@PathVariable String music) {
		return list.get(music);
	}

	/**
	 * Recherche d'unalbum
	 * @param music
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	public Music getMusic(@PathVariable String id,String music) {
		return list.get(music);
	}

	/**
	 * Suppression d'un album
	 * @param id, @param music
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	public Music removeMusic(@PathVariable String music) {
		return list.remove(music);
	}

	/**
	 * Emprunt d'un album
	 * @param music
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	public Music takeMusic(@PathVariable String music) {
		Music m = list.get(music);
		if (m.isAvailable()==true) {
			m.setAvailable(false);
			return m;
		}
		System.out.println(music+" est indisponible");
		return null;
	}

	/**
	 * Rendre un album
	 * @param music
	 *     possible object is
	 *     {@link String }
	 *  
	 */
	public Music giveMusic(@PathVariable String music) {
		Music m = list.get(music);
		if (m.isAvailable()==false) {
			m.setAvailable(true);
			return m;
		}
		System.out.println(music+" est disponible");
		return null;
	}

}
