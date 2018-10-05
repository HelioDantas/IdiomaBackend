package br.com.matrix.idioma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matrix.idioma.config.ResourceNotFoundException;
import br.com.matrix.idioma.model.Audio;
import br.com.matrix.idioma.repository.AudioRepository;

@Service
public class AudioService {

	@Autowired
	private AudioRepository audioRepository;

	public Audio create(Audio audio) {
		return audioRepository.save(audio);
	}

	public Audio update(Audio audio) {
		return audioRepository.save(audio);
	}

	public List<Audio> findAll() {
		return audioRepository.findAll();
	}

	public Audio findById(Long id) {
		return audioRepository.findById(id).get();

	}
	public void delete(Long id) {
		notFoundId(id);
		audioRepository.deleteById(id);
	}
	
	private void notFoundId(Long id) {
		if (audioRepository.existsById(id) == false)
			throw new ResourceNotFoundException("O audio não existe.");
	}
	

}
