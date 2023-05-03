package services;

import java.security.KeyStore.Entry;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ApiDetails.Apiresponse;
import dto.Entrydetails;
import dto.Entryresponse;
import exceptions.DataNotFoundException;
import repository.entryRepository;

public class EntryServiceImpl  implements EntryService{

	@Autowired
    private entryRepository entryRepo;

    @Autowired
    private ModelMapper modelmap;

    @Override
    public Apiresponse saveEntry(Entry entry) throws DataNotFoundException {

        Entry findApi = this.entryRepo.findByApi(entry.getApi())
                .orElseThrow(() -> new ResourceNotFoundException("Entry", "API", entry.getApi()));

        Entrydetails entryDetailsResponseDto = this.toEntryDetails(entry);

        return new Apiresponse(LocalDateTime.now(), "data Saved", true, entryDetailsDto);
    }

    
    @Override
    public List<Entrydetails> getAllEntries() {

        List<Entry> list = this.entryRepo.findAll();

        return list.stream().map(e -> this.toEntryresponse(e)).collect(Collectors.toList());

    }
    
    

    private Entrydetails toEntryDetailsResponseDto(Entry entry) {

        return this.modelmap.map(entry, Entrydetails.class);

    }
    
    

    private Entryresponse toEntryresponse(Entry entry) {

        return this.modelmap.map(entry, Entryresponse.class);
    }


}
