/**
 * Programa de prueba para verificar el correcto funcionamiento de las clases
 * {@link Paquete} y {@link CotizadorEnvio}.
 * 
 * @author Rafael Landeros
 */
public class PruebaPaqueteria {

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  PRUEBAS DEL SISTEMA DE ENVIOS POSTALES (PRACTICA 7) ");
        System.out.println("======================================================\n");

        // ---------------------------------------------------------------------
        // CASO 1: Paquete estandar pequeno (peso fisico domina)
        // Datos requeridos: codigo "PK-001", peso 3.5 kg, dimensiones 20x15x10 cm,
        // valor declarado $800.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 1: Paquete pequeno estandar ---");
        Paquete p1 = new Paquete("PK-001", 3.5, 20, 15, 10, 800, false);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 2: Paquete liviano pero voluminoso (peso volumetrico domina)
        // Datos requeridos: codigo "PK-002", peso 2.0 kg, dimensiones 50x40x50 cm,
        // valor declarado $1500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 2: Paquete voluminoso (volumen predomina) ---");
        Paquete p2 = new Paquete("PK-002", 2, 50, 40, 50, 1500.0, false);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico calculado: %.2f kg\n", p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable final: %.2f kg\n", p2.obtenerPesoCobrable());
        }
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $425.00)\n", CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 3: Paquete de alto valor comercial (requiere seguro por monto)
        // Datos requeridos: codigo "PK-003", peso 4.0 kg, dimensiones 30x25x20 cm,
        // valor declarado $6500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 3: Paquete de alto valor monetario ---");
        Paquete p3 = new Paquete("PK-003", 4, 30, 25, 20, 6500, false);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo de envio: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 4: Paquete sobredimensionado (arista > 60 cm o suma > 150 cm)
        // Datos requeridos: codigo "PK-004", peso 5.0 kg, dimensiones 70x30x20 cm,
        // valor declarado $1200.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 4: Paquete sobredimensionado ---");
        Paquete p4 = new Paquete("PK-004", 5, 70, 30, 20, 1200, false);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true por dimensiones)");
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 5: Validacion de referencia nula (null)
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 5: Validacion de referencia nula (null) ---");
        Paquete pNulo = null;
        System.out.println("Es valido un paquete null?: " + CotizadorEnvio.esPaqueteValido(pNulo) + " (Esperado: false)");
        System.out.printf("Cotizacion de un paquete null: $%.2f (Esperado: -1.00)\n", CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro un paquete null?: " + CotizadorEnvio.requiereSeguro(pNulo) + " (Esperado: false)");
        System.out.println();

        // =====================================================================
        // CASOS DE PRUEBAS DE MI METODO PERSONAL (PARTE 2)
        // =====================================================================
        System.out.println("======================================================");
        System.out.println("        PRUEBAS DE TU PROPUESTA PERSONAL              ");
        System.out.println("======================================================");

        // ---------------------------------------------------------------------
        // CASO 6: Paquete con descuento local valido
        // Datos requeridos: codigo "PK-006", peso 2.0 kg, dimensiones 50x40x50 cm,
        // valor declarado $1500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("\n--- Caso 6: Paquete con descuento ---");
        Paquete p6 = new Paquete("PK-006", 2, 50, 40, 50, 1500.0, true);
        mostrarDetallePaquete(p6);
        System.out.printf("Costo de envio cotizado normal: $%.2f \n", CotizadorEnvio.cotizarEnvio(p6));
        System.out.println("Aplica para descuento: " + p6.isLocal());
        System.out.println("Costo de envio aplicando descuento: $" + CotizadorEnvio.aplicarDescuento(p6) + " (Esperado: $340)");

        // ---------------------------------------------------------------------
        // CASO 7: Paquete con descuento local invalido
        // Datos requeridos: codigo "PK-007", peso 3.5 kg, dimensiones 20x15x10 cm,
        // valor declarado $800.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("\n--- Caso 7: Paquete sin descuento ---");
        Paquete p7 = new Paquete("PK-007", 3.5, 20, 15, 10, 800, false);
        mostrarDetallePaquete(p7);
        System.out.printf("Costo de envio cotizado normal: $%.2f \n", CotizadorEnvio.cotizarEnvio(p7));
        System.out.println("Aplica para descuento: " + p7.isLocal());
        System.out.println("Costo de envio aplicando descuento: $" + CotizadorEnvio.aplicarDescuento(p7) + " (Esperado: $120)");
        System.out.println();
    }

    /**
     * Metodo auxiliar para imprimir en consola los datos basicos de un paquete.
     * Utiliza los metodos de acceso (getters) implementados en la clase Paquete.
     * 
     * @param p Paquete a imprimir.
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("  [Paquete no valido o no instanciado]");
            return;
        }else{

            System.out.println("El codigo del paquete es: " + p.getCodigo());
            System.out.println("Medidas del paquete, Alto: " + p.getAlto() + "cm, Largo: " + p.getLargo() + "cm, Ancho: " + p.getAncho() + "cm");
            System.out.println("El peso del paquete es de: " + p.getPesoKg() + "Kg");
        }
    }
}
