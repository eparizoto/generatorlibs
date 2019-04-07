package com.example.root.generatorlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RaizEQuadrado";

    //Used to load the 'mynativelib' library on application startup.
    static {
        System.loadLibrary("mynativecalcsJNI");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtDesc = (TextView)findViewById(R.id.textViewDescription);
        txtDesc.setText("App para gerar as libs dvbpsi em várias plataformas.\n" +
                "O cálculo de quadrado e raiz quadrada serve apenas \n" +
                "para testar o uso de uma lib gerada com o código \n" +
                "fonte c++ inserido no projeto Android. As libs são \n" +
                "geradas no diretório: \n " +
        "/home/eldorado/Git/raizequadrado/app/build/intermediates/cmake/debug/obj");

        TextView textViewQuad = (TextView)findViewById(R.id.textViewQu);
        textViewQuad.setText(String.valueOf(quadrado(5)));
        Log.d(TAG, "Quadrado = " + quadrado(5));

        TextView textViewRaiz = (TextView)findViewById(R.id.textViewRq);
        textViewRaiz.setText(String.valueOf(raiz(49)));
        Log.d(TAG, "Raiz = " + raiz(49));
    }

    public native double quadrado(int number);
    public native double raiz(int number);
}
