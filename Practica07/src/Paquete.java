/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * 
 * @author Rafael Landeros
 * @version 1.0
 */
public class Paquete {

    // *** ATRIBUTOS ***
    // POR HACER: Declara los atributos necesarios de acuerdo a tu diseno y a la documentacion.
    // Recuerda aplicar el principio de encapsulamiento (declararlos privados).

    private String codigo;
    private double pesoKg;
    private double alto;
    private double ancho;
    private double largo;
    private double valorMon;
    private boolean local;


    // *** CONSTRUCTORES ***
    // POR HACER: Agrega el constructor por defecto y el constructor con parametros.
    // En el constructor con parametros, asegura que el paquete cuente con dimensiones validas.

    public Paquete(){

        codigo = "1a2b3c4d";
        pesoKg = 10;
        alto = 10;
        ancho = 10;
        largo = 10;
        valorMon = 100;
        local = false;

    }

    public Paquete(String cod, double peso, double alt, double anch, double larg, double valor, boolean loc){

        if(peso > 0 && alt > 0 && anch > 0 && larg > 0 && valor > 0){

            codigo = cod;
            pesoKg = peso;
            alto = alt;
            ancho = anch;
            largo = larg;
            valorMon = valor;
            local = loc;

        }else{

            System.out.println("Error: ingreso un valor no valido.");

        }
    }


    // *** METODOS DE ACCESO Y ASIGNACION ***
    // POR HACER: Agrega los metodos de consulta (getters) y de modificacion (setters) necesarios.

    public String getCodigo() {

        return codigo;

    }

    public void setCodigo(String nuevoCodigo){

        codigo = nuevoCodigo;

    }

    public double getPesoKg(){

        return pesoKg;

    }

    public void setPesoKg(double nuevoPesoKg){

        pesoKg = nuevoPesoKg;

    }

    public double getAlto(){

        return alto;

    }

    public void setAlto(double nuevoAlto){

        alto = nuevoAlto;
    }

    public double getAncho(){

        return ancho;

    }

    public void setAncho(double nuevoAncho){

        ancho = nuevoAncho;
    }

    public double getLargo(){

        return largo;

    }

    public void setLargo(double nuevoLargo){

        largo = nuevoLargo;
    }

    public double getValorMon(){

        return valorMon;

    }

    public void setValorMon(double nuevoValorMon){

        valorMon = nuevoValorMon;
    }

    public boolean isLocal(){

        return local;

    }

    public void setLocal(boolean nuevoLocal){

        local = nuevoLocal;

    }

    // *** METODOS CALCULADORES BASE ***

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        // POR HACER: Implementa la formula de peso volumetrico
        return (largo * ancho * alto) / 5000;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {
        // POR HACER: Implementa la comparacion entre peso real y peso volumetrico
        
        if(calculaPesoVolumetrico() > pesoKg){

            return calculaPesoVolumetrico();

        }else{

            return pesoKg;
        }

    }


    // *** PROPUESTA PERSONAL ***
    // POR HACER: Agrega aqui al menos un nuevo metodo calculador util para la empresa
    // (ejemplo: recargo por envio express, costo por material fragil, descuento local, etc.)
    // Incluye sus comentarios Javadoc y los atributos necesarios.

    public double validarDescuento(){

        if(local == true){

            return 0.8;

        }else{

            return 1;

        }


    }

}
