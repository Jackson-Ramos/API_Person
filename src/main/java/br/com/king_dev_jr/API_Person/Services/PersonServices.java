package br.com.king_dev_jr.API_Person.Services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.king_dev_jr.API_Person.Repositories.PersonRepository;
import br.com.king_dev_jr.API_Person.dto.PersonDto;
import br.com.king_dev_jr.API_Person.exceptions.ResourceNotFoundException;
import br.com.king_dev_jr.API_Person.model.Person;

@Service
public class PersonServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;

    public PersonDto findById(Long id) {
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        var personDto = modelMapper.map(entity, PersonDto.class);
        return personDto;
    }

    public ResponseEntity<PersonDto> save(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(personRepository.save(person), PersonDto.class));
    }

    public List<PersonDto> findAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();

        for (Person person : persons) {
            personDtos.add(modelMapper.map(person, PersonDto.class));
        }
        return personDtos;
    }

}
