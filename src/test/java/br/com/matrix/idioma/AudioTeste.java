package br.com.matrix.idioma;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.matrix.idioma.service.AudioService;

public class AudioTeste {
	
	@Autowired
	private AudioService audioService;

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {		
		assertEquals(1, audioService.findById((long) 1).getId(),0);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
