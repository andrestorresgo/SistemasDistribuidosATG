namespace Impuestos
{
    public class Respuesta
    {
        public string estado;
        public string mensaje;
        public Respuesta()
        { 
        
        }

        public Respuesta(string estado, string mensaje)
        {
            this.estado = estado;
            this.mensaje = mensaje;
        }
    }
}