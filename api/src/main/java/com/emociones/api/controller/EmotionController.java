package com.emociones.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emociones.api.service.EmotionService;

@RestController
@RequestMapping("/api")
public class EmotionController {
	private final EmotionService emotionService;
	
	
	public EmotionController(EmotionService emotionService) {
		this.emotionService=emotionService;	
	}

	@PostMapping("/analizar")
	public String analizar(@RequestBody String comentario) {
		return emotionService.analizar(comentario);
		
	}
}
