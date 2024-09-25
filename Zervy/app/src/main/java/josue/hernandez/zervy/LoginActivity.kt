package josue.hernandez.zervy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import josue.hernandez.zervy.ui.LoginScreen
import josue.hernandez.zervy.ui.ui.theme.ZervyTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZervyTheme {
                // Pantalla de inicio de sesión utilizando Compose
                LoginScreen(
                    onLoginClick = {
                        // Redirigir a LoginScreenActivity
                        val intent = Intent(this, LoginScreenActivity::class.java)
                        startActivity(intent)
                    },
                    onRegisterClick = {
                        // Redirigir a SignUpActivity
                        val intent = Intent(this, SignUpActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}
