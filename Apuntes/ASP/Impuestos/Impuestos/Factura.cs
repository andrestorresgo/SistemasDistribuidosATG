using System;
using System.Collections.Generic;

namespace Impuestos
{
    public class Factura
    {
        public int NIT;
        public int razonSocial;
        public DateTime fecha;
        public int numeroFactura;
        public String cuf;
        public String nombreCliente;
        public List<DetalleFactura> detalleFactura;

    }
}