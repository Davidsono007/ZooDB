package Model.bean;

/**
 *
 * @author ALUNO
 */
public class Especie {
    
     private int id_especie;
     private String nm_especie;
     private String ds_dieta;

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public String getNm_especie() {
        return nm_especie;
    }

    public void setNm_especie(String nm_especie) {
        this.nm_especie = nm_especie;
    }

    public String getDs_dieta() {
        return ds_dieta;
    }

    public void setDs_dieta(String ds_dieta) {
        this.ds_dieta = ds_dieta;
    }
     
}