public class PreguntasRespuestas {
    String[] preguntas = {"4+5*6-2=?", "3+2*8-1=?", "7+3*9-4=?", "5+6*7-3=?", "2+4*6-1=?", "8+3*5-2=?", "6+7*4-3=?", "9+2*6-1=?", "4+8*3-2=?", "7+5*4-3=?"};
    Double[] respuestas = {32.0, 23.0, 68.0, 44.0, 25.0, 23.0, 25.0, 22.0, 26.0, 24.0};
    int[] numeroPreguntas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] preguntaActual;
    int respuestasCorrectas;

    public PreguntasRespuestas() {
        this.numeroPreguntas = new int[10];
        this.preguntas = new String[10];
        this.respuestas = new Double[10];
        this.preguntaActual = new int[10];
        this.respuestasCorrectas = 0;
    }

    public void iniciar (){
        this.respuestasCorrectas = 0;
        this.preguntaActual = this.numeroPreguntas;
    }

    public String getPregunta(int i){
        if (this.preguntaActual != this.numeroPreguntas){
            return preguntas[preguntaActual[i]];
        }
        else{
            return "Fin del juego";
        }
    }

    public String verificarRespuesta (int i, Double respuesta){
        if (respuesta == respuestas[preguntaActual[i]]){
            this.respuestasCorrectas++;
            return "Respuesta correcta";
        }
        else{
            return "Respuesta incorrecta";
        }
    }

    public Double getRespuesta(int i){
        return respuestas[i];
    }

    public int getRespuestasCorrectas(){
        return respuestasCorrectas;
    }
}
