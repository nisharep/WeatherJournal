package org.example.weatherjournal.services;

import org.example.weatherjournal.models.entities.Observation;
import org.example.weatherjournal.repositories.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;

    public Observation save(Observation observation) {
        return observationRepository.save(observation);
    }

    public List<Observation> findAll() {
        return observationRepository.findAllByOrderByDateAsc();
    }
}
