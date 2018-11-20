
package enviodeemail;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailWrapper {
    private Properties propiedades;
    private Session sessao;
    
    public EmailWrapper(){
        this.setPropriedades();
    }
    private void setPropriedades(){
        this.propiedades = new Properties();
        this.propiedades.put("mail.smtp.host","mail.dextak.com");//mudar as configuraçoes para o email que usara
        this.propiedades.put("mail.smtp.socketFactory.port","465");
        this.propiedades.put("mail.smtp.socketFactory.class","javax.net.ssl.SSlSocketFactory");
        this.propiedades.put("mail.smtp.auth","true");
        this.propiedades.put("mail.smtp.port","465");
    }
    
    private void autenticar(){
        this.sessao = Session.getDefaultInstance(this.propiedades,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("emaildosistema@teste.com","senhadoemail");
            }
        });
    }
    
    public boolean enviar(String remetente,String destinatario,String assunto,String msg) throws MessagingException{
       this.autenticar();
       Message message = new MimeMessage(this.sessao);
       message.setFrom(new InternetAddress(remetente));
       message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
       message.setSubject(assunto);
       message.setText(msg);
       Transport.send(message);
        return true;
    }
    
}
