package com.evertcode.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	private static Logger LOG = LoggerFactory.getLogger(PhonebookController.class);

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
		LOG.info("Started service");
		this.phonebookRepository = phonebookRepository;
	}

	@GetMapping("/demoLogging")
	public String demoLogging(@RequestParam(required = true, name = "name") final String name) {

		LOG.trace("Hola " + name + " desde un logging trace");
		LOG.debug("Hola " + name + " desde un logging debug");
		LOG.info("Hola " + name + " desde un logging info");
		LOG.warn("Hola " + name + " desde un logging warn");
		LOG.error("Hola " + name + " desde un logging error");
		
		return "Prueba de uso de logging con spring boot.";
	}

	/**
	 * 
	 * @param phonebook
	 * @return
	 */
	@PostMapping
	public Phonebook save(@RequestBody final Phonebook phonebook) {
		LOG.info("Started service");
		return this.phonebookRepository.save(phonebook);
	}

	/**
	 * 
	 * @param id
	 * @param phonebook
	 * @return
	 */
	@PatchMapping("/{id}")
	public Phonebook update(@PathVariable(name = "id") final Long id,
			@RequestBody(required = true) final Phonebook phonebook) {
		LOG.info("Started service");
		return this.phonebookRepository.save(phonebook);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<Phonebook> getAll() {
		LOG.info("Started service");
		return this.phonebookRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Phonebook getById(@PathVariable(name = "id") final Long id) {
		LOG.info("Started service");
		return this.phonebookRepository.findById(id).get();
	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(name = "id") final Long id) {
		LOG.info("Started service");
		this.phonebookRepository.deleteById(id);
	}
}
