package com.example.digimonapi.service;

import com.example.digimonapi.tamer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;

@Service
public class TamerService {
    @Autowired
    private TamerRepository repository;

    public TamerNewResponseDTO updateTamer(Long id, TamerRequestDTO tamerRequest){
        List<Tamer> tamerList = repository.findTamerById(id);
        if (tamerList.size() ==1) {
            Tamer existingtTamer = tamerList.get(0);
            existingtTamer.setTamer(tamerRequest.tamer());
            existingtTamer.setAge(tamerRequest.age());
            existingtTamer.setDigimonPartner(tamerRequest.digimonPartner());
            existingtTamer.setDigimonSeries(tamerRequest.digimonSeries());

            repository.save(existingtTamer);
            return new TamerNewResponseDTO("sucess",existingtTamer);
        }
        else{
            throw new IllegalArgumentException("Tamer not found with id: " + id);
        }
    }

    public TamerNewResponseDTO insertTamer(String tamer, TamerRequestDTO tamerRequest){
        List<Tamer> tamerList = repository.findTamerByName(tamer);
        if (tamerList.size() == 1){
            Tamer existingTamer = tamerList.get(0);
        throw new IllegalArgumentException("This Tamer already exists on database!! " + existingTamer.getTamer());
        }
        else{
            Tamer newTamer = new Tamer(null, tamerRequest.tamer(), tamerRequest.age(),tamerRequest.digimonPartner(), tamerRequest.digimonSeries());
            if(tamerRequest.tamer().isEmpty()){
                throw new IllegalArgumentException("The field 'Tamer' Cannot be blank!!!");
            }
            else {
                repository.save(newTamer);
                return new TamerNewResponseDTO("sucess",newTamer);
            }
        }

    }
    
}
