package com.example.myprojetocheck

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity(), View.OnClickListener, DialogInterface.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoPagar.setOnClickListener(this);
    }
    override fun onClick(dialog: DialogInterface?, tipo: Int) {
        if(tipo == AlertDialog.BUTTON_POSITIVE){
            Toast.makeText(this,"Pagamento realizado com sucesso!",Toast.LENGTH_SHORT)
                .show();
        }
        else if(tipo == AlertDialog.BUTTON_NEGATIVE){
            Toast.makeText(this,"Pagamento cancelado!",Toast.LENGTH_SHORT)
                .show();
        }
        checkAgua.setChecked(false);
        checkLuz.setChecked(false);
        checkTelefone.setChecked(false);
        checkCelular.setChecked(false);
    }


    override fun onClick(v: View?) {
        var total = 0;

        if(checkAgua.isChecked())
            total += Integer.parseInt(checkAgua.getTag().toString());

        if(checkLuz.isChecked())
            total += Integer.parseInt(checkLuz.getTag().toString());

        if(checkTelefone.isChecked())
            total += Integer.parseInt(checkTelefone.getTag().toString());

        if(checkCelular.isChecked())
            total += Integer.parseInt(checkCelular.getTag().toString());

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Pagamento");
        dialog.setMessage("O valor do pagamento total é "+total+". Confirma pagamento?");
        dialog.setPositiveButton("OK",this);
        dialog.setNegativeButton("Cancelar",this);
        dialog.show();
    }


}
