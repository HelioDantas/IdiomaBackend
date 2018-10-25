package br.com.matrix.idioma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.matrix.idioma.config.ResourceNotFoundException;
import br.com.matrix.idioma.config.ResourceObjectRegisteredException;
import br.com.matrix.idioma.model.UserOld;
import br.com.matrix.idioma.repository.UserOldRepository;

@Service
public class UserService {
	
	@Autowired
	UserOldRepository userRepository;
	
	public UserOld create(UserOld user) {
		existsUser(user);
		return userRepository.save(user);
	}
	
	public UserOld findById(Long id) {
		notFoundId(id);
		return userRepository.findById(id).orElse(null);
	}
	
	public UserOld update(UserOld user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		notFoundId(id);
		userRepository.deleteById(id);
	
	}
	
	public void notFoundId(Long id) {
		if (!userRepository.existsById(id))
			throw new ResourceNotFoundException("Usuário não existe");
	}
	
	public void existsUser(UserOld user) {
		if (userRepository.findByLogin(user.getLogin()).isPresent())
			throw new ResourceObjectRegisteredException("Esse login já está cadastrado");
		if(userRepository.findByEmail(user.getEmail()).isPresent())
			throw new ResourceObjectRegisteredException("Esse email já está cadastrado");
	}
	
}
