
package enviodeemail;

import javax.mail.MessagingException;

public class EnvioDeEmail {

    
    public static void main(String[] args) throws MessagingException {
       EmailWrapper e = new EmailWrapper();
       String remetente = "emailremetente@gmail.com";
       String destinatario = "emaildestinatario@gmail.com";
       String assunto = "Bom dia";
       String msg = "Bom dia";
       e.enviar(remetente, destinatario, assunto, msg);
    }
    
}
