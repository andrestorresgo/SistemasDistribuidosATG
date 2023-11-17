namespace SOAPBNB
{
    internal class Cuenta
    {
        public int Id { get; set; }
        public string NumeroCuenta { get; set; }
        public string Moneda { get; set; }
        public double Saldo { get; set; }
        public int CodigoCliente { get; set; }
    }
}