package com.example.myapplication

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import com.example.myapplication.ui.theme.HappyBirthdayTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                   GreetingText(
//                        message = "Happy Birthday Sam!",
//                        from = "From Emma",
//                        modifier = Modifier.padding(8.dp)
//                    )
                    Botones()
                   // Login()
                }

            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier

    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
        Button(onClick = {},
            modifier = Modifier

        ){
            Text(text = "Pulsar")
        }

    }
}

@Composable
fun Login() {
    // Dos maneras diferentes de definir un estado
    // con el = necesitamos utilizar value
    var counter by remember { mutableStateOf(0) }
    var name = remember { mutableStateOf("") }

    Column {
        // mostrar el contador de clics
        TextButton(onClick = { counter++ }) {
            Text("CLICS: $counter")
        }
    }
    // mientras no tecleamos mas de tres caracteres no se muestra el saludo
    if (name.value.length > 3) {
        Text(
            text = "Nombre: ${name.value}!",
            fontSize = 24.sp

        )
    }
    // campo de texto para rellenar
    OutlinedTextField(
        value = name.value,
        onValueChange = {
            name.value = it
        },
        label = { Text(text = "Name") }
    )
}

enum class colorClase(val rgb: Int){
    ROJO(1), VERDE(2), MAGENTA(3), AZUL(4)
}

data class juego(var rondas: Int, var record: Int)

@Composable
fun Botones(modifier: Modifier = Modifier){
    var rondas = remember {
        mutableStateOf(1)
    }

    var record by remember {
        mutableStateOf(value = 0)
    }
    var listaMutable by remember {
        mutableStateOf(mutableListOf<Int>())
    }

    var listaMutableR by remember{
        mutableStateOf(mutableListOf<Int>())
    }
    var texto by remember {
        mutableStateOf(value = "")
    }

    fun chequeo() {

    }



    var name by remember {mutableStateOf("")}
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

    Column (verticalArrangement = Arrangement.Center){
        Text(text = "Ronda " + rondas.value.toString()
        ,modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally))

    Row {
        Button(onClick = { name = "rojo"
            listaMutable.add(element = colorClase.ROJO.rgb)
            Log.i("Rojo","Lista: " + listaMutable.toString())
            texto = colorClase.ROJO.name
            chequeo()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            modifier = Modifier
                .padding(2.dp)
        ) {
          //  Text(text = "Boton1")
        }
        Button(onClick = { name = "magenta"
            listaMutable.add(element = colorClase.MAGENTA.rgb)
            Log.e("Magenta","Lista: " + listaMutable.toString())
            texto = colorClase.MAGENTA.name
            chequeo()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            modifier = Modifier
                .padding(2.dp)

        ) {
           // Text(text = "Boton2")
        }
    }

    Row {
        Button(onClick = { name = "verde"
            listaMutable.add(element = colorClase.VERDE.rgb)
            Log.d("Verde","Lista: " + listaMutable.toString())
            texto = colorClase.VERDE.name
            chequeo()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green
            ),
            modifier = Modifier
                .padding(2.dp)
        ) {
           // Text(text = "Boton3")
        }
        Button(onClick = {name = "Azul"
            listaMutable.add(element = colorClase.AZUL.rgb)
            Log.e("Azul","Lista: " + listaMutable.toString())
            texto = colorClase.AZUL.name
            chequeo()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            modifier = Modifier
                .padding(2.dp)
        ) {
            //Text(text = "Boton4")

        }

    }
        Column (verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)) {
            Text(text = texto)
        }
    }

    }

}



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {

    Botones()
}