package com.example.kursachUD.repo;

import com.example.kursachUD.model.Harakteristiki;
import com.example.kursachUD.model.Sotrudnik;
import org.springframework.data.repository.CrudRepository;

public interface HaraktRepo extends CrudRepository<Harakteristiki, Integer> {
}