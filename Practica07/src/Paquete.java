/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * 
 * @author Rafael Landeros
 */
public class Paquete {

    // *** ATRIBUTOS ***

    /**Codigo alfanumerico del paquete. */
    private String codigo;

    /**Peso en kg del paquete. */
    private double pesoKg;

    /**Altura en cm del paquete.*/
    private double alto;

    /**Ancho en cm del paquete. */
    private double ancho;

    /**Largo en cm del paquete. */
    private double largo;

    /**Precio del producto en el paquete */
    private double valorMon;

    /**Indica si es local la entrega del paquete. */
    private boolean local;


    // *** CONSTRUCTORES ***

    /**
    * Constructor por defecto.
    * Crea un Paquete con codigo 1a2b3c4d
    * 10 kg de peso, 10cm de alto, 10cm de ancho, 10cm de largo, $100 del valor del producto y no es local.
    */
    public Paquete(){

        this.codigo = "1a2b3c4d";
        this.pesoKg = 10;
        this.alto = 10;
        this.ancho = 10;
        this.largo = 10;
        this.valorMon = 100;
        this.local = false;

    }

    /**
    * Constructor con parámetros.
    * Crea un Paquete con los datos indicados. Si algun dato no es
    * valido, se corrige con un valor seguro.
    * @param codigo Codigo alfanumerico del paquete.
    * @param pesoKg Peso en kg del paquete (pesoKg &gt; 0).
    * @param alto Altura en cm del paquete (alto &gt; 0).
    * @param ancho Ancho en cm del paquete (ancho &gt; 0).
    * @param largo Largo en cm del paquete (largo &gt; 0).
    * @param valorMon Precio del producto en el paquete (valorMon &gt; 0).
    * @param local Indica si es local la entrega del paquete.
    */
    public Paquete(String codigo, double pesoKg, double alto, double ancho, double largo, double valorMon, boolean local){

        this.codigo = codigo;

        if(pesoKg > 0){

          this.pesoKg = pesoKg;  

        }else{

            System.out.println("Aviso: Peso invalido, se usa 10.");
            this.pesoKg = 10;

        }

        if(alto > 0){

          this.alto = alto;

        }else{

            System.out.println("Aviso: Altura invalida, se usa 10.");
            this.alto = 10;

        }

        if(ancho > 0){

          this.ancho = ancho;

        }else{

            System.out.println("Aviso: Ancho invalido, se usa 10.");
            this.ancho = 10;

        }

        if(largo > 0){

          this.largo = largo;

        }else{

            System.out.println("Aviso: Largo invalido, se usa 10.");
            this.largo = 10;

        }

        if(valorMon > 0){

          this.valorMon = valorMon;

        }else{

            System.out.println("Aviso: Precio invalido, se usa 100.");
            this.valorMon = 100;

        }

        this.local = local;

    }


    // *** METODOS DE ACCESO Y ASIGNACION ***

    /**
    * Devuelve el codigo alfanumerico del paquete.
    * @return Codigo alfanumerico del paquete.
    */
    public String getCodigo() {

        return codigo;

    }

    /**
    * Cambia el codigo alfanumerico del paquete.
    * @param nuevoCodigo Nuevo codigo alfanumerico del paquete.
    */
    public void setCodigo(String nuevoCodigo){

        codigo = nuevoCodigo;

    }

    /**
    * Devuelve el peso en kg del paquete.
    * @return El peso en kg del paquete.
    */
    public double getPesoKg(){

        return pesoKg;

    }

    /**
    * Cambia el peso en kg del paquete solo si es mayor a 0.
    * @param nuevoPesoKg Nuevo peso en kg del paquete.
    */
    public void setPesoKg(double nuevoPesoKg){

        if(nuevoPesoKg > 0){

            pesoKg = nuevoPesoKg;

        }else{

            System.out.println("Error: Peso invalido.");

        }

    }

    /**
    * Devuelve el alto en cm del paquete.
    * @return El alto en cm del paquete.
    */
    public double getAlto(){

        return alto;

    }

    /**
    * Cambia el alto en cm del paquete solo si es mayor a 0.
    * @param nuevoAlto Nuevo alto en cm del paquete.
    */
    public void setAlto(double nuevoAlto){

        if(nuevoAlto > 0){

            alto = nuevoAlto;

        }else{

            System.out.println("Error: Altura invalida.");

        }
    }

    /**
    * Devuelve el ancho en cm del paquete.
    * @return El ancho en cm del paquete.
    */
    public double getAncho(){

        return ancho;

    }

    /**
    * Cambia el ancho en cm del paquete solo si es mayor a 0.
    * @param nuevoAncho Nuevo ancho en cm del paquete.
    */
    public void setAncho(double nuevoAncho){

        if(nuevoAncho > 0){

            ancho = nuevoAncho;

        }else{

            System.out.println("Error: Anchura invalida.");

        }
    }

    /**
    * Devuelve el largo en cm del paquete.
    * @return El largo en cm del paquete.
    */
    public double getLargo(){

        return largo;

    }

    /**
    * Cambia el largo en cm del paquete solo si es mayor a 0.
    * @param nuevoLargo Nuevo largo en cm del paquete.
    */
    public void setLargo(double nuevoLargo){

        if(nuevoLargo > 0){

            largo = nuevoLargo;

        }else{

            System.out.println("Error: Largo invalido.");
        }
    }

    /**
    * Devuelve el valor monetario del producto en el paquete.
    * @return El valor monetario del producto en el paquete.
    */
    public double getValorMon(){

        return valorMon;

    }

    /**
    * Cambia el precio del producto en el paquete solo si es mayor a 0.
    * @param nuevoValorMon Nuevo precio del producto en el paquete.
    */
    public void setValorMon(double nuevoValorMon){

        if(nuevoValorMon > 0){

            valorMon = nuevoValorMon;

        }else{

            System.out.println("Error: Precio invalido.");
        }
    }

    /**
    * Indica si es entrega local.
    * @return true si es local.
    */
    public boolean isLocal(){

        return local;

    }

    /**
    * Cambia el valor de verdad de si es local.
    * @param nuevoLocal Nuevo valor de verdad de si es local.
    */
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

        return (largo * ancho * alto) / 5000;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {

        if(calculaPesoVolumetrico() > pesoKg){

            return calculaPesoVolumetrico();

        }else{

            return pesoKg;
        }

    }


    // *** PROPUESTA PERSONAL ***

    /** 
     * Determina si es un envio local y en base eso asignara un numero
     * con el cual se va a determinar el valor del descuento,
     * si local es true sera 0.8 para que se haga un descuento del 20%,
     * si es false sera de 1 para que regrese el mismo valor (que seria del 0% el descuento).
     * 
     *@return El numero con el cual se intentara aplicar el descuento al envio.
     */

    public double determinarDescuento(){

        if(local == true){

            return 0.8;

        }else{

            return 1;

        }


    }

}
