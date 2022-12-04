package org.example.weatherjournal.repositories;

import org.example.weatherjournal.models.entities.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends CrudRepository<Observation, Long> {
    List<Observation> findAllByOrderByDateAsc();
}
