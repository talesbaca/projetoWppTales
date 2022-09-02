package br.com.up.projetowhats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout telInputLayout;
    private TextInputLayout msgInputLayout;

    private TextInputEditText telInputText;
    private TextInputEditText msgInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telInputLayout = findViewById(R.id.telnputLayout);
        msgInputLayout = findViewById(R.id.msgInputLayout);

        telInputText = findViewById(R.id.telInputText);
        msgInputText = findViewById(R.id.msgInputText);

        View sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String num = telInputText.getText().toString();
                    String msg = msgInputText.getText().toString();
                    if(num.isEmpty()){
                        telInputLayout.setError("Favor inserir o número de telefone");
                        return;
                    }

                    if(msg.isEmpty()){
                        msgInputLayout.setError("Favor inserir uma mensagem");
                        return;
                    }

                    Uri link = Uri.parse("https://wa.me/" + num + "?text=" + msg);

                    Intent callIntent = new Intent(Intent.ACTION_VIEW, link);
                    startActivity(callIntent);
                }
            }
            );
    }
}