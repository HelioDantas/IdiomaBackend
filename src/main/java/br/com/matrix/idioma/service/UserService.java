package br.com.matrix.idioma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.matrix.idioma.config.ResourceNotFoundException;
import br.com.matrix.idioma.config.ResourceObjectRegisteredException;
import br.com.matrix.idioma.model.User;
import br.com.matrix.idioma.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User create(User user) {
		existsUser(user);
		return userRepository.save(user);
	}
	
	public User findById(Long id) {
		notFoundId(id);
		return userRepository.findById(id).get();
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		notFoundId(id);
		userRepository.deleteById(id);
	}
	
	public void notFoundId(Long id) {
		if (userRepository.existsById(id) == false)
			throw new ResourceNotFoundException("Usuário não existe");
	}
	
	public void existsUser(User user) {
		if (userRepository.findByLogin(user.getLogin()).isPresent())
			throw new ResourceObjectRegisteredException("Esse usuário já está cadastrado");
	}
	
}
