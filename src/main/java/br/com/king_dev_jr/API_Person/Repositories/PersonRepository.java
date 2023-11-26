package br.com.king_dev_jr.API_Person.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.king_dev_jr.API_Person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
