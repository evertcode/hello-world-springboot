package com.evertcode.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evertcode.phonebook.model.Phonebook;

/**
 * 
 * @author evertcode
 *
 */

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {

}
