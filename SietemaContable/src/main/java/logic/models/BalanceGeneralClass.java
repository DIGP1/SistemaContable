/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.RegistrosContables;

/**
 *
 * @author josue
 */
public class BalanceGeneralClass {
    // Mapa para almacenar los tipos de cuentas y sus listas de registros contables
    private Map<String, List<RegistrosContables>> cuentas;
    
    public BalanceGeneralClass() {
        cuentas = new HashMap<>();
        // Inicializamos los tipos de cuentas con listas vacías
        cuentas.put("Activo Circulante", new ArrayList<>());
        cuentas.put("Activo No Circulante", new ArrayList<>());
        cuentas.put("Pasivo Circulante", new ArrayList<>());
        cuentas.put("Pasivo No Circulante", new ArrayList<>());
        cuentas.put("Patrimonio", new ArrayList<>());
    }

    // Método para agregar valores a una cuenta específica
    public void agregarValor(String tipoCuenta, List<Object> valores) {
        if (cuentas.containsKey(tipoCuenta)) {
            List<RegistrosContables> lista = cuentas.get(tipoCuenta);
            // Buscar si ya existe un registro con la misma cuenta
            boolean cuentaExistente = false;
            for (RegistrosContables registro : lista) {
                if (registro.getCuenta().equals(valores.get(3))) {
                    // Si la cuenta ya existe, sumar sus valores
                    double nuevoDebe = (registro.getDebe() != null && !registro.getDebe().isEmpty()) 
                                       ? Double.parseDouble(registro.getDebe()) 
                                       : 0;

                   double nuevoDebeValor = (valores.get(5) != null && !((String) valores.get(5)).isEmpty()) 
                                           ? Double.parseDouble((String) valores.get(5)) 
                                           : 0;

                   double nuevoHaber = (registro.getHaber() != null && !registro.getHaber().isEmpty()) 
                                       ? Double.parseDouble(registro.getHaber()) 
                                       : 0;

                   double nuevoHaberValor = (valores.get(6) != null && !((String) valores.get(6)).isEmpty()) 
                                            ? Double.parseDouble((String) valores.get(6)) 
                                            : 0;

                   nuevoDebe += nuevoDebeValor;
                   nuevoHaber += nuevoHaberValor;
                    
                    
                    registro.setDebe(String.valueOf(nuevoDebe));
                    registro.setHaber(String.valueOf(nuevoHaber));
                    cuentaExistente = true;
                    break;
                }
            }
            // Si la cuenta no existe, agregar el nuevo registro
            if (!cuentaExistente) {
                RegistrosContables nuevo = new RegistrosContables(String.valueOf(valores.get(1)),String.valueOf(valores.get(2)),String.valueOf(valores.get(3)),String.valueOf(valores.get(5)),String.valueOf(valores.get(6)),String.valueOf(valores.get(4)));
                lista.add(nuevo);
            }
        } else {
            System.out.println("Tipo de cuenta no válido." + tipoCuenta);
        }
    }

    // Método para obtener el total (debe - haber) de una cuenta específica
    public double obtenerTotal(String tipoCuenta) {
        if (cuentas.containsKey(tipoCuenta)) {
            double totalDebe = 0;
            double totalHaber = 0;
            for (RegistrosContables registro : cuentas.get(tipoCuenta)) {
                totalDebe += Double.parseDouble(registro.getDebe());
                totalHaber += Double.parseDouble(registro.getHaber());
            }
            return totalDebe - totalHaber; // Retorna el total neto
        }
        System.out.println("Tipo de cuenta no válido. kjkljljlkjkjljkljkljkljkl");
        return 0.0;
    }

    // Método para ver los totales de todas las cuentas, incluyendo sus nombres
    public String obtenerTotales() {
        StringBuilder sb = new StringBuilder();
        for (String tipoCuenta : cuentas.keySet()) {
            sb.append(tipoCuenta).append(":\n");
            double totalDebe = 0;
            double totalHaber = 0;
            for (RegistrosContables registro : cuentas.get(tipoCuenta)) {
                sb.append("  Cuenta: ").append(registro.getCuenta()).append("\n")
                  .append("    Debe: ").append(registro.getDebe()).append("\n")
                  .append("    Haber: ").append(registro.getHaber()).append("\n");
                    // Validación para registro.getDebe()
                    double debeValor = (registro.getDebe() != null && !registro.getDebe().isEmpty()) 
                                       ? Double.parseDouble(registro.getDebe()) 
                                       : 0;

                    // Validación para registro.getHaber()
                    double haberValor = (registro.getHaber() != null && !registro.getHaber().isEmpty()) 
                                        ? Double.parseDouble(registro.getHaber()) 
                                        : 0;

                    // Sumar los valores validados
                    totalDebe += debeValor;
                    totalHaber += haberValor;

            }
            sb.append("  Total (Debe - Haber): ").append(totalDebe - totalHaber).append("\n\n");
        }
        return sb.toString();
    }
}
