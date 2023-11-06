using ServiceReference1;
using System.Security.Cryptography.Pkcs;

namespace FormFactura
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServiceReference1.ServicioImpuestosSoapClient servicio = new ServiceReference1.ServicioImpuestosSoapClient(new ServiceReference1.ServicioImpuestosSoapClient.EndpointConfiguration());

            // Collect data from the user input fields (text boxes, etc.)
            int idAmbiente = int.Parse(textBox1.Text);
            int NIT = int.Parse(textBox2.Text);
            string cufd = servicio.ObtenerCufd();
            int modalidad = int.Parse(textBox4.Text);
            int razonSocial = int.Parse(textBox5.Text);

            Factura factura = new Factura
            {
                NIT = NIT,
                razonSocial = razonSocial,
                fecha = DateTime.Now,  // You can replace this with the actual date
                numeroFactura = int.Parse(textBox6.Text),
                cuf = cufd,
                nombreCliente = textBox7.Text,
                // Add code to populate the list of DetalleFactura objects
            };

            // Call the EmitirFactura method from the web service
            Respuesta response = servicio.EmitirFactura(idAmbiente, NIT, cufd, modalidad, factura);

            // Check the response and display it to the user
            MessageBox.Show($"Estado: {response.estado}\nMensaje: {response.mensaje}");

            //servicio.EmitirFactura(idAmbiente, NIT, cufd, modalidad, factura);


        }


        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}