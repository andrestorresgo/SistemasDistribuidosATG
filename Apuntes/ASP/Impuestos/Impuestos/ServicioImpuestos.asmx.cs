using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Impuestos
{
    /// <summary>
    /// Summary description for ServicioImpuestos
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ServicioImpuestos : System.Web.Services.WebService
    {

        [WebMethod]
        public DateTime Sincronizar()
        {
            return DateTime.Now;
        }

        [WebMethod]
        public String ObtenerCufd()
        {
            return "AB0000134534521";
        }

        [WebMethod]
        public Respuesta EmitirFactura(int idAmbiente, int NIT, String cufd, int modalidad, Factura factura)
        {
            Respuesta aux = new Respuesta("Valido", "Recibido correctamente " + factura.razonSocial);
            return aux;
        }
    }
}
