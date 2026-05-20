package com.emociones.api.service;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emociones.api.dto.EmotionRequest;
import com.emociones.api.dto.EmotionResponse;

@Service
public class EmotionService {
	public String analizar (String comentario) {
		RestTemplate restTemplate= new RestTemplate();
		
		String url="http://127.0.0.1:8000/predict";
		
		EmotionRequest request= new EmotionRequest();
		request.setComentario(comentario);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	
		HttpEntity<EmotionRequest> entity=
				new HttpEntity<>(request, headers);
		
		ResponseEntity<EmotionResponse> response=restTemplate.postForEntity(
				url, entity, EmotionResponse.class);
		return response.getBody().getEmocion();
	}
}
