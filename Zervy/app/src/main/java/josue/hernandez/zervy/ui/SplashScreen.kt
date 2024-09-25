package josue.hernandez.zervy.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import josue.hernandez.zervy.LoginActivity
import josue.hernandez.zervy.R
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenContent {
                // Navegar al LoginActivity cuando se complete el splash screen
                startActivity(Intent(this, LoginActivity::class.java))
                finish() // Finaliza el SplashScreen para que no regrese al pulsar atrás
            }
        }
    }
}

@Composable
fun SplashScreenContent(onSplashFinished: () -> Unit) {
    // Transición infinita para el efecto de parpadeo (fade in y fade out)
    val transition = rememberInfiniteTransition(label = "fadeTransition")

    // Animación de opacidad (de transparente a opaco) con repetición infinita
    val alpha by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,  // Duración de la animación
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alphaAnimation"
    )

    // Introduce un retraso de 3 segundos antes de navegar al LoginActivity
    LaunchedEffect(Unit) {
        delay(3000) // 3 segundos de espera (ajusta este valor si lo necesitas)
        onSplashFinished() // Llama a la función para finalizar el splash y navegar
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A40)),  // Fondo color #1A1A40
        contentAlignment = Alignment.Center // Centrar el contenido
    ) {
        // Imagen animada solo con el efecto de parpadeo (fade in y fade out)
        Image(
            painter = painterResource(id = R.drawable.union),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(alpha = alpha) // Solo afecta la opacidad
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreenContent {}
}
