package EjercicioPractico1.controller;


import EjercicioPractico1.domain.Farmacia;
import EjercicioPractico1.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = farmaciaService.getFarmacia(false);
        model.addAttribute("farmacias", lista);
        model.addAttribute("totalFarmacias", lista.size());
        return "examen/listado"; // Asegúrate de que la ruta sea correcta
    }

    @PostMapping("/guardar")
    public String guardar(Farmacia farmacia, @RequestParam("imagenFile") MultipartFile imagenFile) {
        farmaciaService.save(farmacia);
        return "redirect:/farmacia/listado"; // Asegúrate de redirigir correctamente
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Farmacia farmacia) {
        farmaciaService.delete(farmacia);
        return "redirect:/farmacia/listado"; // Asegúrate de redirigir correctamente
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Farmacia farmacia, Model model) {
        farmacia = farmaciaService.getFarmacia(farmacia);
        model.addAttribute("farmacia", farmacia);
        return "modifica"; // Ajustado también a la plantilla correcta
    }

    // Nueva función para mostrar el formulario de satisfacción
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        return "examen/formulario"; // Asegúrate de que el archivo HTML esté en la ruta correcta
    }
    // Nueva función para manejar el envío del formulario de satisfacción

    // Nueva función para manejar el envío del formulario de satisfacción
    @PostMapping("/enviar-satisfaccion")
    public String enviarSatisfaccion(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam int puntuacion,
            @RequestParam(required = false) String comentarios,
            Model model) {
        // Aquí puedes procesar los datos del formulario, como guardarlos en la base de datos o en un archivo
        // Ejemplo de cómo podrías usar farmaciaService o cualquier otro servicio:
        // farmaciaService.guardarSatisfaccion(nombre, email, puntuacion, comentarios);

        // Agrega un mensaje de éxito o cualquier otra información necesaria
        model.addAttribute("mensaje", "Gracias por su comentario, " + nombre + "!");

        return "redirect:/farmacia/listado"; // Redirigir a donde desees después de enviar el formulario
    }
}