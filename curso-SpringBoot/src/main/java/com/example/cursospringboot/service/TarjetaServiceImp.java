package com.example.cursospringboot.service;

import com.example.cursospringboot.entity.TarjetaCredito;
import com.example.cursospringboot.repository.PeliculaRepository;
import com.example.cursospringboot.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TarjetaServiceImp  implements TarjetaService{


    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public List<TarjetaCredito> getAllTarjetas() {
        return tarjetaRepository.findAll();
    }

    @Override
    public Optional<TarjetaCredito> getTarjetaById(Long id) {
        return tarjetaRepository.findById(id);
    }

    @Override
    public TarjetaCredito createTarjeta(TarjetaCredito tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public TarjetaCredito updateTarjeta(Long id, TarjetaCredito tarjetaDetails) {
        TarjetaCredito tarjeta = tarjetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta not found"));

        tarjeta.setNumeroT(tarjetaDetails.getNumeroT());
        tarjeta.setFechaCaducidad(tarjetaDetails.getFechaCaducidad());
        tarjeta.setCodigoSeguridad(tarjetaDetails.getCodigoSeguridad());
        tarjeta.setTitular(tarjetaDetails.getTitular());
        // Actualiza otros campos según sea necesario

        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public void deleteTarjeta(Long id) {
        tarjetaRepository.deleteById(id);
    }



}
