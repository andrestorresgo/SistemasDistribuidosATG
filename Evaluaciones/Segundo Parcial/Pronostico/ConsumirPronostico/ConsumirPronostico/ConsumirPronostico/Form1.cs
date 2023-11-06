namespace ConsumirPronostico
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            // Configura el DataGridView
            dataGridView1.ColumnCount = 3;
            dataGridView1.Columns[0].Name = "Fecha";
            dataGridView1.Columns[1].Name = "Temperatura";
            dataGridView1.Columns[2].Name = "Probabilidad de Lluvia";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServiceReference1.PronosticoSoapClient servicio = new ServiceReference1.PronosticoSoapClient(new ServiceReference1.PronosticoSoapClient.EndpointConfiguration());

            // Recoge los datos de los cuadros de texto
            string fecha = textBox1.Text;
            string formato = textBox2.Text;

            // Llama al método ObtenerPronostico del servicio web
            string resultado = servicio.ObtenerPronostico(fecha, formato);

            // Muestra el resultado
            MessageBox.Show(resultado);
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            ServiceReference1.PronosticoSoapClient servicio = new ServiceReference1.PronosticoSoapClient(new ServiceReference1.PronosticoSoapClient.EndpointConfiguration());

            // Define las fechas a consultar
            List<string> fechas = new List<string>
            {
                "2021-02-04",
                "2021-02-05",
                "2021-02-06",
                "2021-02-07",
                "2021-02-08",
                "2021-02-09",
                "2021-02-10",
                "2021-02-11",
                "2021-02-12",
                // Agrega más fechas aquí
            };

            // Recoge el formato de los cuadros de texto
            // string formato = textBox2.Text;

            // Limpia el DataGridView
            dataGridView1.Rows.Clear();

            // Llama al método ObtenerPronostico del servicio web para cada fecha
            foreach (string fecha in fechas)
            {
                string temperatura = servicio.ObtenerPronostico(fecha, "temperatura");
                string probabilidad = servicio.ObtenerPronostico(fecha, "porcentaje");

                // Añade los resultados al DataGridView
                dataGridView1.Rows.Add(fecha, temperatura, probabilidad);
            }
        }
    }
}