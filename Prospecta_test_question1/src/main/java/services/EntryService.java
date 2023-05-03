package services;

import java.security.KeyStore;
import java.util.List;

import ApiDetails.Apiresponse;
import dto.Entryresponse;

import exceptions.DataNotFoundException;

public interface EntryService {
	
	 public Apiresponse saveEntry(KeyStore.Entry entries) throws DataNotFoundException;

	    List<Entryresponse> getAllEntries();

}
