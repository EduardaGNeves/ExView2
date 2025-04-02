package com.example.exview2;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exview2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);
        binding.edtNome.setFilters(new InputFilter[]{new InputFilter.AllCaps()});


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLimpar){
            //Toast.makeText(this,"Limpar",Toast.LENGTH_SHORT).show();
            binding.txtNome.setText("Nome: " + binding.edtNome.getText().toString().toUpperCase());
            binding.rdgSexo.clearCheck();
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.chkMusica.setChecked(false);
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastronomia.setChecked(false);
            binding.swtNotificacao.setChecked(false);
        }
        else if (view.getId() == R.id.btnExibir){
            //Toast.makeText(this,"Exibir",Toast.LENGTH_LONG).show();
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: "
                    + binding.edtNome.getText().toString());

            int idrdbSelecionado = binding.rdgSexo.getCheckedRadioButtonId();
            if(idrdbSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                binding.txtSexo.setText("Sexo: "
                        + rdbSelecionado.getText().toString());
            }

            binding.txtEmail.setText("E-mail: "
                    + binding.edtEmail.getText().toString());

            binding.txtTelefone.setText("Telefone: "
                    + binding.edtTelefone.getText().toString());

            String pref="";
            if(binding.chkMusica.isChecked())
                pref = binding.chkMusica.getText().toString();
            if(binding.chkCinema.isChecked()){
                pref += " ";
                pref += binding.chkCinema.getText().toString();
            }
            if(binding.chkEsporte.isChecked()){
                pref += " ";
                pref += binding.chkEsporte.getText().toString();
            }
            if(binding.chkGastronomia.isChecked()){
                pref += " ";
                pref += binding.chkGastronomia.getText().toString();
            }
            binding.txtPref.setText("Preferências: " + pref);

            if(binding.swtNotificacao.isChecked()){
                binding.txtNotificacao.setText("Ativar Notificalções: "
                        +binding.swtNotificacao.getTextOn());
            }else{
                binding.txtNotificacao.setText("Ativar Notificalções: "
                        +binding.swtNotificacao.getTextOff());
            }

        }
    }
}