package com.ieseljust.pmdm.comptadorcomposable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieseljust.pmdm.comptadorcomposable.ui.theme.ComptadorComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Definim el contingut en una composable a banda
            ComptadorApp()
        }
    }
}

@Composable
fun ComptadorApp() {
    // Definim la propietat comptador com a rememberSaveable, per a que
    // mantinga l'estat entre rotacions de pantalla
    var comptador by rememberSaveable { mutableStateOf(0) }

    ComptadorComposableTheme {
        // Definim l'esquelet amb un Scaffold
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            // El contingut s'organitzarà en forma de columna
            Column(
                // Definim l'aliniació horitzontal i vertical
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                // Fem que ocupe la pantalla completa
                modifier = Modifier.fillMaxSize().padding(paddingValues) // Agregamos el padding
            ) {
                Text(text = comptador.toString(), fontSize = 178.sp)
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 60.dp, end = 60.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // - Un boto per incrementar el comptador
                    Button(onClick = { comptador++ }) {
                        Text(text = "+", fontSize = 34.sp)
                    }

                    // Altre espaiador
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = { comptador-- }) {
                        Text(text = "-", fontSize = 34.sp)
                    }
                }

                // Mover el botón "Resetejar" debajo de los botones + y -
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { comptador = 0 }) {
                    Text(text = "Resetejar", fontSize = 34.sp)
                }

                // Altra funcio composable amb el boto per obrir la segona activitat
                OpenActivityButton(comptador)
            }
        }
    }
}

@Composable
fun OpenActivityButton(comptador: Int) {
    val context = LocalContext.current
    Button(onClick = {
        val intent = Intent(context, MostraComptadorActivity::class.java).apply {
            putExtra("comptador", comptador)
        }
        context.startActivity(intent)
    }) {
        Text(text = "Open Activity")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComptadorApp()
}
