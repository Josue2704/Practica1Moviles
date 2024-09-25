package josue.hernandez.zervy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import josue.hernandez.zervy.R
import josue.hernandez.zervy.ui.ui.theme.ZervyTheme

class LoginActivityUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZervyTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginClick = { navController.navigate("login_screen_activity") },
                onRegisterClick = { navController.navigate("signup") }
            )
        }
        composable("signup") {
            SignUpScreen(onSignUpSuccess = { navController.popBackStack() })
        }
        composable("main") {
            MainScreen()
        }
        composable("login_screen_activity") {
            LoginScreenActivity()  // Navegando hacia la pantalla LoginScreenActivity.kt
        }
    }
}

@Composable
fun LoginScreen(onLoginClick: () -> Unit, onRegisterClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Imagen decorativa superior izquierda (group1)
        Image(
            painter = painterResource(id = R.drawable.group1),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(0.dp)
                .fillMaxWidth(0.25f),  // Ajustar al tamaño deseado
            contentScale = ContentScale.Crop
        )

        // Imagen decorativa superior derecha (group2)
        Image(
            painter = painterResource(id = R.drawable.group2),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(0.dp)
                .fillMaxWidth(0.2f),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Spacer(modifier = Modifier.height(150.dp))

            // Logo (group4.png)
            Image(
                painter = painterResource(id = R.drawable.group4),
                contentDescription = null,
                modifier = Modifier
                    .size(258.dp, 153.dp)
                    .padding(top = 24.dp) // Ajuste del margen superior
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Botón Iniciar Sesión
            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2)), // Color ajustado
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(48.dp)
            ) {
                Text("Iniciar Sesión", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón Registrarse
            OutlinedButton(
                onClick = onRegisterClick,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF7E57C2)),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(48.dp)
            ) {
                Text("Registrarse", color = Color(0xFF7E57C2), fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Imagen decorativa inferior (group3)
                Image(
                    painter = painterResource(id = R.drawable.group3),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)  // Alineado al centro inferior dentro de un Box
                        .fillMaxWidth()                  // Ocupa todo el ancho disponible
                        .height(200.dp)                 // Ajuste del tamaño para que sobresalga correctamente
                        .offset(y = 80.dp),             // Mueve la imagen hacia arriba en lugar de usar padding negativo
                    contentScale = ContentScale.FillWidth // Ajuste para llenar el ancho
                )
            }
        }
    }
}

@Composable
fun SignUpScreen(onSignUpSuccess: () -> Unit) {
    // Aquí puedes diseñar la pantalla de registro
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Pantalla de Registro")
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onSignUpSuccess) {
            Text("Registrarse")
        }
    }
}

@Composable
fun MainScreen() {
    // Aquí puedes diseñar la pantalla principal
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla Principal")
    }
}

@Composable
fun LoginScreenActivityComposable() {
    // Aquí puedes personalizar lo que debe verse en la actividad LoginScreenActivity
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Esta es la LoginScreenActivity")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    ZervyTheme {
        LoginScreen(onLoginClick = {}, onRegisterClick = {})
    }
}



