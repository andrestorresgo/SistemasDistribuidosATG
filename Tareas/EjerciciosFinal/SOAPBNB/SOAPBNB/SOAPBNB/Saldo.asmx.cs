using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web;
using System.Web.Services;

namespace SOAPBNB
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {

        [WebMethod]
        public async Task<double> GetSaldo(string numeroCuenta)
        {
            using (HttpClient client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8000/api/");
                HttpResponseMessage response = await client.GetAsync("cuentas/" + numeroCuenta);
                if (response.IsSuccessStatusCode)
                {
                    var cuenta = await response.Content.ReadAsAsync<Cuenta>();
                    return cuenta.Saldo;
                }
                else
                {
                    throw new Exception("Número de cuenta no válido");
                }
            }
        }

    }
}
