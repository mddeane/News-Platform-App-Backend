package com.nolarity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.model.Rundown;
import com.nolarity.repository.RundownRepository;

@Service
public class RundownService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RundownRepository rundownRepository;
	
	@Transactional(readOnly = true)
	public Set<Rundown> getAllRundowns() {
		Set<Rundown> allRundowns = rundownRepository.findAll().stream().collect(Collectors.toSet());
		log.info("Getting all rundowns: " + allRundowns.size() + " total rundowns.");
		return allRundowns;
	}
}
