package dev.rudzzz.concessionaria.repositories;

import dev.rudzzz.concessionaria.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Marca findByNomeMarca(String nomeMarca);
}
