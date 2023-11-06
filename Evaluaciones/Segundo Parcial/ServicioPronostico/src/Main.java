import javax.xml.soap.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crea una fábrica de mensajes SOAP
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMsg = factory.createMessage();

        // Crea un objeto SOAP Part
        SOAPPart part = soapMsg.getSOAPPart();

        // Crea un envelope SOAP
        SOAPEnvelope envelope = part.getEnvelope();
        envelope.addNamespaceDeclaration("web", "http://tempuri.org/");


        // Crea un cuerpo SOAP
        SOAPBody body = envelope.getBody();

        // Crea un elemento SOAP
        SOAPElement element = body.addChildElement("ObtenerPronostico", "web");

        // Añade elementos hijos
        element.addChildElement("fecha", "web").addTextNode("2021-02-04");
        element.addChildElement("formato", "web").addTextNode("temperatura");

        // Guarda los cambios en el mensaje SOAP
        soapMsg.saveChanges();

        // Crea un objeto URL
        URL url = new URL("http://localhost:55572/Pronostico.asmx?WSDL");

        // Abre una conexión a la URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Configura la solicitud para ser un POST
        conn.setRequestMethod("POST");

        // Configura las propiedades de la solicitud
        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestProperty("SOAPAction", "http://tempuri.org/ObtenerPronostico");

        // Habilita la entrada y salida de datos
        conn.setDoOutput(true);
        conn.setDoInput(true);

        // Envia el mensaje SOAP
        soapMsg.writeTo(conn.getOutputStream());

        // Obtiene la respuesta
        SOAPMessage response = factory.createMessage(null, conn.getInputStream());

        // Imprime la respuesta
        response.writeTo(System.out);
    }
}

