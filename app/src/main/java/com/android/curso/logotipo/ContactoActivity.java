package com.android.curso.logotipo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitleMarginStart(265);
        setSupportActionBar(miActionBar);

        Button btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario);


        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ContactoActivity.this, "Enviando Comentario", Toast.LENGTH_SHORT).show();

                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session = Session.getInstance(props, null);

                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(((EditText)findViewById(R.id.etContactoCorreo)).getText().toString());

                    msg.setRecipients(Message.RecipientType.TO, "fer.and.73025@gmail.com");
                    msg.setSubject("Mascotas");
                    msg.setSentDate(new Date());
                    msg.setText(((EditText)findViewById(R.id.etContactoMensaje)).getText().toString());
                    Transport.send(msg, "fer.and.73025@gmail.com", "miPassword");
                } catch (Exception mex) {
                }

            }
        });

    }



}
