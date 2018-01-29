package com.example.andrei.http;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class MainActivity extends AppCompatActivity {

    Button http_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        http_post = (Button)findViewById(R.id.http_post);

        http_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client();
            }
        });


    }

    private void test(){
        System.out.println("Test");
    }
    private void client() {
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("lYCJfviyNl\\WDG74An","7Nt6pfe6Kl");
        client.register(feature);
        //  client.register(SseFeature.class);
        String baseurl="https://iot.simfony.net/8189b50fa17c2c1d9f0920544fea15da94897120/MTI5NQ==/test";


        WebTarget target = client.target(baseurl);

        Entity<String> payload = Entity.entity("test", MediaType.TEXT_PLAIN_TYPE);
        Response post = target.request().post(payload);

        try {
        //    if (post.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {

           // }

        } catch (Exception ex){

        }
          
        }

    }

