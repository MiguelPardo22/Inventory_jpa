
package com.app.inventory.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Utiles {
    
    static String obtenerFechaYHoraActual() {
        String formato = "yyyy-MM-dd";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }
}
