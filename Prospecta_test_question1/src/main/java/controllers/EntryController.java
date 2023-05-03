package controllers;

import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ApiDetails.Apiresponse;
import dto.Entrydetails;
import dto.Entryresponse;
import dto.apidata;
import exceptions.DataNotFoundException;
import services.EntryService;

public class EntryController {
	

    @Autowired
    private EntryService eServices;

    @Autowired
    private RestTemplate rTemplate;

    @Autowired
    private ModelMapper modelMap;

    // This API will list all the Entries
    
    
    // http:localhost:8087/entries
    

    @GetMapping("/entries")
    public ResponseEntity<List<KeyStore.Entry>> getEntriesHandler() {

        apidata data = rTemplate.getForObject("https://api.publicapis.org/entries", apidata.class);

        List<KeyStore.Entry> apiEntries = data.getEntries();



        List<Entrydetails> collect = apiEntries.stream()
                .map(e -> this.modelMap.map(e, Entrydetails.class)).collect(Collectors.toList());

        return new ResponseEntity<List<KeyStore.Entry>>(apiEntries, HttpStatus.OK);
    }

    // Enter a category as a Request Parameter to get Entries based on Category
    
    // For Example : List All Entries With title and Descriptions For Animal
    
    // Category
    
    // https://api.publicapis.org/entries?category=Animals
    
    // Note : Category is Case Sensitive
    
    @PostMapping("/entries")
    public ResponseEntity<Apiresponse> saveEntryHandler(@RequestBody Entry entry) throws DataNotFoundException){
    	
        Apiresponse apiResponse = this.saveEntryHandler(entry).saveEntry((KeyStore.Entry) entry);

        return new ResponseEntity<Apiresponse>(apiResponse, HttpStatus.CREATED);
    }


    @GetMapping("/entries/Categories")
    public ResponseEntity<List<Entryresponse>> getEntriesHandler(@RequestParam String category) {

        String url = "https://api.publicapis.org/entries?category=" + category;

        apidata data = rTemplate.getForObject(url, apidata.class);

        List<KeyStore.Entry> apiEntries = data.getEntries();

        List<Entryresponse> collect = apiEntries.stream().map(e -> this.modelMap.map(e, Entryresponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<Entryresponse>>(collect, HttpStatus.OK);
    }

   


}
