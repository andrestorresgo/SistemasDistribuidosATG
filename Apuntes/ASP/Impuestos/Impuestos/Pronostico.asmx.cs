using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Impuestos
{
    /// <summary>
    /// Summary description for Pronostico
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class Pronostico : System.Web.Services.WebService
    {
        private static readonly List<PronosticoInfo> Pronosticos = new List<PronosticoInfo>
        {
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-04"), Temperatura = 21, Probabilidad = 36.74 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-05"), Temperatura = 22, Probabilidad = 80 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-06"), Temperatura = 25, Probabilidad = 1.26 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-07"), Temperatura = 26, Probabilidad = 0.42 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-08"), Temperatura = 28, Probabilidad = 46.85 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-09"), Temperatura = 19, Probabilidad = 4.21 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-10"), Temperatura = 22, Probabilidad = 8.79 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-11"), Temperatura = 12, Probabilidad = 0.69 },
            new PronosticoInfo { Fecha = DateTime.Parse("2021-02-12"), Temperatura = 18, Probabilidad = 0.65 },
        };
        [WebMethod]
        public string ObtenerPronostico(string fecha, string formato)
        {
            var pronostico = Pronosticos.FirstOrDefault(p => p.Fecha.Date == DateTime.Parse(fecha).Date);
            if (pronostico == null)
            {
                return "No se encontró pronóstico para la fecha proporcionada.";
            }
            switch (formato)
            {
                case "temperatura":
                    return $"La temperatura para el {fecha} es {pronostico.Temperatura} grados.";
                case "porcentaje":
                    return $"La probabilidad de lluvia para el {fecha} es {pronostico.Probabilidad}%.";
                default:
                    return "Formato no reconocido. Por favor, utiliza 'temperatura' o 'porcentaje'.";
            }
        }

        public class PronosticoInfo
        {
            public DateTime Fecha { get; set; }
            public int Temperatura { get; set; }
            public double Probabilidad { get; set; }
        }
    }
}
