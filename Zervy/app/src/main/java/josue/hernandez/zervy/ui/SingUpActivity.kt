package josue.hernandez.zervy.ui

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import josue.hernandez.zervy.R
import josue.hernandez.zervy.ui.ui.theme.ZervyTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZervyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
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
                .fillMaxWidth(0.21f),
            contentScale = ContentScale.Crop
        )
        // Logo pequeño en la esquina superior derecha
        Image(
            painter = painterResource(id = R.drawable.group4),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(99.dp)
                .padding(end = 20.dp, top = 16.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .align(Alignment.Center)
        ) {
            // Texto de bienvenida
            Text(
                text = "Crea una cuenta en Zervy",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 40.dp)
            )

            // Campo de Nombres
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Nombre") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el TextField
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Campo de Celular
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Celular") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_local_phone_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el TextField
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )


            // Campo de Fecha de Nacimiento
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Fecha de nacimiento") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_calendar_today_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el TextField
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Campo de Email
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Correo") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.99f)
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
                        painter = painterResource(id = R.drawable.baseline_password_24),
                        contentDescription = null
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .padding(top = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el TextField
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Texto "¿Ya posees una cuenta?"
            Text(
                text = "¿Ya posees una cuenta?",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Botón "Aceptar"
            Button(
                onClick = { /* Acción al hacer clic */ },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.5f), // Tamaño del botón ajustado
                shape = RoundedCornerShape(16.dp), // Bordes redondeados en el botón
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7E57C2)) // Color del botón
            ) {
                Text(text = "Aceptar", color = Color.White)
            }
        }

        // Imagen decorativa inferior
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
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ZervyTheme {
        SignUpScreen()
    }
}
