package com.evertcode.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertcode.phonebook.model.Phonebook;
import com.evertcode.phonebook.repository.PhonebookRepository;

/**
 * 
 * @author evertcode
 *
 */

@RestController
@RequestMapping("/v1/phonebook")
public class PhonebookController {

	/**
	 * 
	 */
	private PhonebookRepository phonebookRepository;
	
	/**
	 * 
	 * @param phonebookRepository
	 */
	@Autowired
	public PhonebookController(final PhonebookRepository phonebookRepository) {
		this.phonebookRepository = phonebookRepository;
	}
	
	/**
	 * 
	 * @param phonebook
	 * @return
	 */
	@PostMapping
	public Phonebook save(@RequestBody final Phonebook phonebook) {
		return this.phonebookRepository.save(phonebook);
	}
	
	/**
	 * 
	 * @param id
	 * @param phonebook
	 * @return
	 */
	@PatchMapping("/{id}")
	public Phonebook update(@PathVariable(name = "id") final Long id, @RequestBody(required = true) final Phonebook phonebook) {
		return this.save(phonebook);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<Phonebook> getAll() {
		return this.phonebookRepository.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Phonebook getById(@PathVariable(name = "id") final Long id) {
		return this.phonebookRepository.findById(id).get();
	}
	
	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(name = "id") final Long id) {
		this.phonebookRepository.deleteById(id);
	}
}
