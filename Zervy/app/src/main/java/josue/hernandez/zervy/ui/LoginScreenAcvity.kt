package josue.hernandez.zervy.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text

import androidx.compose.ui.unit.dp
import josue.hernandez.zervy.ui.ui.theme.ZervyTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.layout.ContentScale
import josue.hernandez.zervy.LoginScreenActivity
import josue.hernandez.zervy.R

class LoginScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZervyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreenActivity(Modifier.padding(innerPadding), {}) {
                        val intent = Intent(this, SignUpActivity::class.java)
                        startActivity(intent)
                    }
                    LoginScreenActivity(
                        onLoginClick = {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        },
                        onSignUpClick = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreenActivity(modifier: Modifier = Modifier, onLoginClick: () -> Unit, onSignUpClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Fondo decorativo con imágenes
        Image(
            painter = painterResource(id = R.drawable.group5),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(0.dp)
                .fillMaxWidth(0.25f),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.group6),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(0.dp)
                .fillMaxWidth(0.2f),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Imagen decorativa inferior (group3)
            Image(
                painter = painterResource(id = R.drawable.group3),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(150.dp)
                    .offset(y = 30.dp),
                contentScale = ContentScale.FillWidth
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.Center)
                .offset(y = (-50).dp) // Subimos todo el contenido hacia arriba
        ) {
            // Logo centrado
            Image(
                painter = painterResource(id = R.drawable.union),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(top = 10.dp) // Reducimos el margen superior
            )

            // Texto de bienvenida
            Text(
                text = "Inicia Sesion en Zervy",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Campo de Email
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Email") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el TextField
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Campo de Contraseña
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Contraseña") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp) // Bordes redondeados en el TextField
            )

            // Texto de "¿Aun no posees una cuenta?"
            Text(
                text = "¿Aun no posees una cuenta?",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 24.dp)
            )

            // Botón de "Aceptar" con bordes redondeados
            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.5f), // Tamaño del botón ajustado
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el botón
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7E57C2)) // Color del botón
            ) {
                Text(text = "Aceptar", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ZervyTheme {
        josue.hernandez.zervy.ui.LoginScreenActivity(
            onLoginClick = {},
            onSignUpClick = {}
        )


    }
}
