
package clubfutbol.torerosclub.modulos.tablas;

public class DatosTemporada {
    
    public String PJ;
    public String PG;
    public String PE;
    public String PP;
    public String PTS;
    public String pLiga;
    public String titulos;

    public DatosTemporada( String PJ, String PG, String PE, String PP, String PTS , String pLiga, String titulos) {
        this.PJ = PJ;
        this.PG = PG;
        this.PE = PE;
        this.PP = PP;
        this.PTS  = PTS;
        this.pLiga = pLiga;
        this.titulos = titulos;
    }

    public String getPJ() {
        return PJ;
    }

    public String getPG() {
        return PG;
    }

    public String getPE() {
        return PE;
    }

    public String getPTS() {
        return PTS;
    }

    public String getpLiga() {
        return pLiga;
    }

    public String getTitulos() {
        return titulos;
    }
    
    
    
}
