package dev.rudzzz.concessionaria.repositories;

import dev.rudzzz.concessionaria.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
