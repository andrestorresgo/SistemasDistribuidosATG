import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cotes extends UnicastRemoteObject implements IEmpresa {

    public Cotes() throws RemoteException {
        super();
    }

    @Override
    public Factura[] pendientes(int idcliente) throws RemoteException {
        Factura[]aux=new Factura[2];
        Empresa empresa=new Empresa("COTES",109198457L);
        switch (idcliente){
            case 1:
                aux[0]=new Factura(empresa, 200, Mes.MARZO,2021, 100);
                aux[1]=new Factura(empresa, 400, Mes.ENERO,2022, 200);
                break;
            case 2:
                aux[0]=new Factura(empresa, 100, Mes.ENERO,2022, 700);
                aux[1]=new Factura(empresa, 500, Mes.FEBRERO,2022, 900);
                break;
        }        return aux;
    }

    @Override
    public String pagar(Factura[] facturas) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
