package EjercicioPractico1.service;

import EjercicioPractico1.domain.Farmacia;
import java.util.List;

public interface FarmaciaService {
    List<Farmacia> getFarmacia(boolean activos); // Método para obtener farmacias activas o inactivas
    void save(Farmacia farmacia); // Guardar farmacia
    void delete(Farmacia farmacia); // Eliminar farmacia
    Farmacia getFarmacia(Farmacia farmacia); // Obtener una farmacia específica
}