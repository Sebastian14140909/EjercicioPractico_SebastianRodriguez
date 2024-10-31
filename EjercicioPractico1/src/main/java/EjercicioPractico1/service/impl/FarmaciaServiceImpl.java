package EjercicioPractico1.service.impl;





import EjercicioPractico1.domain.Farmacia;
import EjercicioPractico1.service.FarmaciaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmaciaServiceImpl implements FarmaciaService {

    private List<Farmacia> listaMedicamentos = new ArrayList<>();

    @Override
    public List<Farmacia> getFarmacia(boolean flag) {
        return listaMedicamentos;
    }

    @Override
    public void save(Farmacia farmacia) {
        listaMedicamentos.add(farmacia);
    }

    @Override
    public void delete(Farmacia farmacia) {
        listaMedicamentos.remove(farmacia);
    }

    @Override
    public Farmacia getFarmacia(Farmacia farmacia) {
        // Puedes agregar lógica para encontrar el medicamento en la lista
        return farmacia; // Simplificado
    }
}