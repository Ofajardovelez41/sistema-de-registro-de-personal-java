package listapeso;

public class ninio {
    private String Registro_civil;
    private String Nombre;
    private float Talla;
    private float Peso;
    private int Edad;
    private String IdentificacionPadre;
    private String NombrePadre;
    private String Municipio;
    private ninio sig;
    
    public ninio(){
        this.Registro_civil = "";
        this.Nombre = "";
        this.Talla = 0;
        this.Peso = 0;
        this.IdentificacionPadre = "";
        this.NombrePadre = "";
        this.Municipio = "";
        this.sig = null;
    }

    public String getRegistro_civil() {
        return Registro_civil;
    }

    public void setRegistro_civil(String Registro_civil) {
        this.Registro_civil = Registro_civil;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getTalla() {
        return Talla;
    }

    public void setTalla(float Talla) {
        this.Talla = Talla;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    public String getIdentificacionPadre() {
        return IdentificacionPadre;
    }

    public void setIdentificacionPadre(String IdentificacionPadre) {
        this.IdentificacionPadre = IdentificacionPadre;
    }

    public String getNombrePadre() {
        return NombrePadre;
    }

    public void setNombrePadre(String NombrePadre) {
        this.NombrePadre = NombrePadre;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public ninio getSig() {
        return sig;
    }

    public void setSig(ninio sig) {
        this.sig = sig;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
}
