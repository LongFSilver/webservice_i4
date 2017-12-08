package webservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import io.spring.guides.gs_producing_web_service.GetMusicRequest;
import io.spring.guides.gs_producing_web_service.GetMusicResponse;
import io.spring.guides.gs_producing_web_service.Music;

@Endpoint
@EnableWs
public class MusicEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	Map<String,Music> list = new HashMap<>();

	//BIBLIOTHEQUE DE MUSIC	
	public MusicEndpoint(){
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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart="getMusicRequest")
	@ResponsePayload
	public GetMusicResponse getMusic(@RequestPayload GetMusicRequest request) {
		GetMusicResponse response=new GetMusicResponse();
		response.setMusic(list.get(request.getName()));
		return response;

	}

}



