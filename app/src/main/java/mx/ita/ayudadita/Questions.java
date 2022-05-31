package mx.ita.ayudadita;

public class Questions {
    private String id;
    private String contenido;
    private String semestreId;
    private String materiaId;
    private String usuarioId;
    private String fecha;


    public Questions(){}
    public Questions(String id, String contenido, String semestreId, String materiaId,String usuarioId, String fecha) {
        this.id= id;
        this.contenido=contenido;
        this.semestreId=semestreId;
        this.materiaId=materiaId;
        this.usuarioId=usuarioId;
        this.fecha=fecha;
    }

    public String getId(){return id;}
    public String getContenido(){return contenido;}
    public String getSemestreId(){return semestreId;}
    public String getMateriaId(){return materiaId;}
    public String getUsuarioId() {return usuarioId;}
    public String getFecha() {return fecha;}

    public void setId(String id) {this.id = id;}
    public void setContenido(String contenido) {this.contenido = contenido;}
    public void setSemestreId(String semestreId) {this.semestreId = semestreId;}
    public void setMateriaId(String materiaId) {this.materiaId = materiaId;}
    public void setUsuarioId(String usuarioId) {this.usuarioId = usuarioId;}
    public void setFecha(String fecha) {this.fecha = fecha;}
}
