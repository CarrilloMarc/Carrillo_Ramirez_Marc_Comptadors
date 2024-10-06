package com.pmdm.ieseljust.comptador

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var comptador=0

    override fun onSaveInstanceState(estat: Bundle){
        super.onSaveInstanceState(estat)
        estat.putInt("Comptador",comptador)
    }
    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        comptador = estat.getInt("Comptador")
        val textViewComptador = findViewById<TextView>(R.id.textViewComptador)
        textViewComptador.text = comptador.toString().toString()
    }
    override fun onStart(){
        super.onStart()
        Log.d("Funcio Start", "Al mètode onStart")
    }
    override fun onResume(){
        super.onResume()
        Log.d("Funcio Resume", "Al mètode onResume")
    }
    override fun onPause(){
        super.onPause()
        Log.d("Funcio Pause", "Al mètode onPause")
    }
    override fun onStop(){
        super.onStop()
        Log.d("Funcio Stop", "Al mètode onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("Funcio Destroy", "Al mètode onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia al TextView
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        // Referencia al boto d'Open
        val btOpen=findViewById<Button>(R.id.btOpen)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.text=comptador.toString() // Estem fent una assignacio directament o accedinta algun metode?

        // Referencia al botón
        val btAdd=findViewById<Button>(R.id.btAdd)
        val btRest=findViewById<Button>(R.id.btRest)
        val btReset=findViewById<Button>(R.id.btReset)

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.text=comptador.toString()
        }

        btRest.setOnClickListener{
            comptador--
            textViewContador.text=comptador.toString()
        }

        btReset.setOnClickListener{
            comptador=0
            textViewContador.text=comptador.toString()
        }
        /*btOpen.setOnClickListener{
            val intent = Intent(baseContext, MostraComptadorActivity::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }*/

        btOpen.setOnClickListener {
            Intent(baseContext, MostraComptadorActivity::class.java).apply {
                putExtra("comptador", comptador)
                startActivity(this)
            }
        }
    }
}