package com.example.kursachUD.repo;


import com.example.kursachUD.model.Zakaz;
import org.springframework.data.repository.CrudRepository;

public interface ZakazRepo extends CrudRepository<Zakaz, Integer> {
}
