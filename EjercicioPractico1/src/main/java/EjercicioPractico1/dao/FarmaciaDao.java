package EjercicioPractico1.dao;

import EjercicioPractico1.domain.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmaciaDao extends JpaRepository<Farmacia, Long> {
    // JpaRepository ya maneja los métodos básicos de CRUD
}