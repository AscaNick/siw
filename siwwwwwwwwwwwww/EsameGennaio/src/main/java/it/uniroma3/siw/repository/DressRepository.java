package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Dress;

public interface DressRepository extends CrudRepository<Dress,Long>{

	boolean existsByNomeAndPrezzo(String nome, int prezzo);

	Dress[] findByPrezzo(int prezzo);

}
