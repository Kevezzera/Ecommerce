package com.amil.e_comerce_backend.servics;

import com.amil.e_comerce_backend.dto.VendasDTO;
import com.amil.e_comerce_backend.entity.VendasEntity;
import com.amil.e_comerce_backend.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VendasService {

    @Autowired
    private VendasRepository vendasRepository;


    public void insert(VendasDTO vendasDTO){

        if (vendasDTO.getData() == null) {
            vendasDTO.setData(LocalDate.now());
        }
        if (vendasDTO.getHora() == null) {
            vendasDTO.setHora(LocalTime.now());
        }

        VendasEntity vendasEntity = new VendasEntity(vendasDTO);
        vendasRepository.save(vendasEntity);
    }

    public List<VendasDTO> findByregistros(Long id){
        List<VendasEntity> vendas = vendasRepository.findByClient_Id(id);
        return  vendas.stream()
                .map(VendasDTO::new) // supondo construtor AgendaDto(AgendaEntity e)
                .toList();
    }

}
