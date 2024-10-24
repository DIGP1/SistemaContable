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
    public Map<String, Double> obtenerTotales() {
        Map<String, Double> mapaTotales = new HashMap<>();

        for (String tipoCuenta : cuentas.keySet()) {
            double totalDebe = 0;
            double totalHaber = 0;

            // Iterar sobre los registros contables asociados a cada tipo de cuenta
            for (RegistrosContables registro : cuentas.get(tipoCuenta)) {
                double debeValor = (registro.getDebe() != null && !registro.getDebe().isEmpty()) 
                                   ? Double.parseDouble(registro.getDebe()) 
                                   : 0;

                double haberValor = (registro.getHaber() != null && !registro.getHaber().isEmpty()) 
                                    ? Double.parseDouble(registro.getHaber()) 
                                    : 0;

                totalDebe += debeValor;
                totalHaber += haberValor;
            }

            // Calcular el total (Debe - Haber) y agregarlo al mapa
            mapaTotales.put(tipoCuenta, totalDebe - totalHaber);
        }

        return mapaTotales;
    }

    public List<Object> obtenerBalance() {
        List<Object> balanceGeneral = new ArrayList<>(); // Lista principal para almacenar el balance general

        for (String tipoCuenta : cuentas.keySet()) {
            List<Object> cuentaInfo = new ArrayList<>(); // Crear una lista para cada tipo de cuenta
            cuentaInfo.add(tipoCuenta); // Agregar el tipo de cuenta como primer elemento

            List<Map<String, Object>> registrosList = new ArrayList<>(); // Lista para los registros contables de esta cuenta

            List<RegistrosContables> listaRegistros = cuentas.get(tipoCuenta);

            if (listaRegistros.isEmpty()) {
                cuentaInfo.add("No hay registros en esta categoría.");
            } else {
                for (RegistrosContables registro : listaRegistros) {
                    // Crear un mapa para almacenar los atributos del registro
                    Map<String, Object> registroMap = new HashMap<>();
                    
                    double debeValor = (registro.getDebe() != null && !registro.getDebe().isEmpty())
                                       ? Double.parseDouble(registro.getDebe())
                                       : 0;

                    double haberValor = (registro.getHaber() != null && !registro.getHaber().isEmpty())
                                        ? Double.parseDouble(registro.getHaber())
                                        : 0;
                    registroMap.put("Codigo", registro.getCodigo());
                    registroMap.put("Cuenta", registro.getCuenta());
                    
                    if (debeValor < haberValor) {
                        registroMap.put("Debe", "");
                        registroMap.put("Haber", debeValor - haberValor);
                    } else {
                        registroMap.put("Debe", debeValor - haberValor);
                        registroMap.put("Haber", "");
                    }
                    
                    // Añadir el mapa del registro a la lista de registros
                    registrosList.add(registroMap);
                }
            }

            cuentaInfo.add(registrosList); // Añadir los registros a la información de la cuenta
            balanceGeneral.add(cuentaInfo); // Añadir la información de la cuenta a la lista principal
        }

        return balanceGeneral; // Devolver la lista estructurada
    }



}
