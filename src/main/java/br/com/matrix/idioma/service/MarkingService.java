package br.com.matrix.idioma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matrix.idioma.config.ResourceIllegalArgumentException;
import br.com.matrix.idioma.config.ResourceNotFoundException;
import br.com.matrix.idioma.model.Marking;
import br.com.matrix.idioma.model.MarkingDTO;
import br.com.matrix.idioma.model.User;
import br.com.matrix.idioma.repository.MarkingRepository;

@Service 
public class MarkingService {
	
	@Autowired
	private MarkingRepository markingRepository;
	
	@Autowired
	private AudioService audioService;
	@Autowired
	private UserService userService;
	
	public Marking create(MarkingDTO markingDTO) {
		if(existsMarking(markingDTO))
			return null;
		Marking marking = new Marking();
		BeanUtils.copyProperties(markingDTO, marking);
		marking.setAudio(audioService.findById(markingDTO.getAudioId()));
		marking.setUser(userService.findById(markingDTO.getUserId()));
		return markingRepository.save(marking);
	}
	
	public Optional<Marking> findById(Long id) {
		notFoundId(id);
		return markingRepository.findById(id);
	}
	
	public List<Marking> findAll(){
		return markingRepository.findAll();
	}
	
	public Optional<List<Marking>> findByUserIdAndAudioId(Long userId, Long audioId){
		notFoundId(userId);
		audioService.notFoundId(audioId);
		return markingRepository.findByUserIdAndAudioId(userId, audioId);
	}
	
	public Marking update(Marking marking) {
		return markingRepository.save(marking);
	}
	
	public void deleteById(Long id) {
		notFoundId(id);
		markingRepository.deleteById(id);
	}
	private void notFoundId(Long id) {
		if (markingRepository.existsById(id) == false)
			throw new ResourceNotFoundException("A marcação não existe.");
	}	
	
	private boolean existsMarking(MarkingDTO marking) {
		if (markingRepository.findByUserIdAndAudioIdAndBegin(marking.getUserId(), marking.getAudioId(), marking.getBegin()).isPresent())
			return true;
		return false;
	}

}
