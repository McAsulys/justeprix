import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import java.util.concurrent.ThreadLocalRandom

@Composable
fun JustePrixGame() {
    var target by remember { mutableStateOf(ThreadLocalRandom.current().nextInt(1, 101)) }
    var input by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("Devine un nombre entre 1 et 100 !") }
    var color by remember { mutableStateOf(Color.Black) }
    var attempts by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Le Juste Prix", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Ton nombre") },
            singleLine = true,
            modifier = Modifier.width(200.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                scope.launch {
                    try {
                        val guess = input.text.toIntOrNull() ?: throw NumberFormatException()
                        attempts++
                        if (guess == target) {
                            message = "Bravo ! Trouvé en $attempts coup(s)."
                            color = Color(0xFF4CAF50)
                        } else if (guess < target) {
                            message = "Plus haut !"
                            color = Color(0xFFFF9800)
                        } else {
                            message = "Plus bas !"
                            color = Color(0xFFFF9800)
                        }
                    } catch (e: Exception) {
                        message = "Entre un nombre entre 1 et 100."
                        color = Color(0xFFF44336)
                    }
                }
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Valider")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = message,
            color = color,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                target = ThreadLocalRandom.current().nextInt(1, 101)
                input = TextFieldValue("")
                message = "Nouveau nombre choisi. Devine entre 1 et 100 !"
                color = Color.Black
                attempts = 0
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Recommencer")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Le Juste Prix") {
        MaterialTheme {
            JustePrixGame()
        }
    }
}
