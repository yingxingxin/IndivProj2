package com.example.indivproj2

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val answerKey = listOf("Katseye", "Stronger", "Red Velvet", "B.o.B ft Hayley Williams", "Enchanted", "Palette")
var index = 0
var totalCorrect = 0

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Default))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {navController.navigate("quiz_screen1") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {navController.navigate("register_screen") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Register here")
            }
        }
    }
}

@Composable
fun RegisterScreen(navController: NavController) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val dateOfBirth by remember { mutableStateOf("") }
    val email by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }

    TextField(
        value = firstName.value,
        onValueChange = { firstName.value = it },
        label = { Text(text = "First Name") },
        modifier = Modifier.fillMaxWidth()
        )

    Spacer(modifier = Modifier.height(20.dp))
    TextField(
        value = lastName.value,
        onValueChange = { lastName.value = it },
        label = { Text(text = "Last Name") },
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun QuizScreen1(navController: NavController, context: Context) {
    var selectedAnswer by remember { mutableStateOf("")}
    index = 0
    totalCorrect = 0


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Question 1",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        RadioGroup(
            labelText = "Who is the artist of the song \"Touch\"?",
            radioOptions = listOf("Katseye", "Bruno Mars", "BTS", "Aespa"),
            selectedOption = selectedAnswer,
            onSelected = { selectedAnswer = it },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { if(isCorrect(selectedAnswer)) {
                Toast.makeText(context, "The answer is correct", Toast.LENGTH_SHORT).show()
                totalCorrect++
            } else {
                Toast.makeText(context, "The answer is wrong", Toast.LENGTH_SHORT).show()
            }
                navController.navigate("quiz_screen2")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}

@Composable
fun QuizScreen2(navController: NavController, context: Context){

    var selectedAnswer by remember { mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Question 2",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        RadioGroup(
            labelText = "What song did Kelly Clarkson sing?",
            radioOptions = listOf("Heartbeat", "Moonlit Night", "Apt", "Stronger"),
            selectedOption = selectedAnswer,
            onSelected = { selectedAnswer = it },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = {
                if(isCorrect(selectedAnswer)) {
                Toast.makeText(context, "The answer is correct", Toast.LENGTH_SHORT).show()
                totalCorrect++
            } else {
                Toast.makeText(context, "The answer is wrong", Toast.LENGTH_SHORT).show()
            }
                navController.navigate("quiz_screen3")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}

@Composable
fun QuizScreen3(navController: NavController, context: Context) {
    var selectedAnswer by remember { mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Question 3",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        RadioGroup(
            labelText = "Which artist sang the song \"Cosmic\"?",
            radioOptions = listOf("Blackpink", "Lady Gaga", "Red Velvet", "Beyonce"),
            selectedOption = selectedAnswer,
            onSelected = { selectedAnswer = it },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { if(isCorrect(selectedAnswer)) {
                Toast.makeText(context, "The answer is correct", Toast.LENGTH_SHORT).show()
                totalCorrect++
            } else {
                Toast.makeText(context, "The answer is wrong", Toast.LENGTH_SHORT).show()
            }
                navController.navigate("quiz_screen4")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}

@Composable
fun QuizScreen4(navController: NavController, context: Context) {
    var selectedAnswer by remember { mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Question 4",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        RadioGroup(
            labelText = "Which artist sang the song \"Airplanes\"?",
            radioOptions = listOf("Rihanna", "B.o.B ft Hayley Williams", "Eminem", "Taylor Swift"),
            selectedOption = selectedAnswer,
            onSelected = { selectedAnswer = it },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { if(isCorrect(selectedAnswer)) {
                Toast.makeText(context, "The answer is correct", Toast.LENGTH_SHORT).show()
                totalCorrect++
            } else {
                Toast.makeText(context, "The answer is wrong", Toast.LENGTH_SHORT).show()
            }
                navController.navigate("quiz_screen5")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}

@Composable
fun QuizScreen5(navController: NavController, context: Context) {
    var selectedAnswer by remember { mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Question 5",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        RadioGroup(
            labelText = "Of the songs listed, which is a Taylor Swift song?",
            radioOptions = listOf("Enchanted", "Cheerleader", "Falling", "Undetected"),
            selectedOption = selectedAnswer,
            onSelected = { selectedAnswer = it },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { if(isCorrect(selectedAnswer)) {
                Toast.makeText(context, "The answer is correct", Toast.LENGTH_SHORT).show()
                totalCorrect++
            } else {
                Toast.makeText(context, "The answer is wrong", Toast.LENGTH_SHORT).show()
            }
                navController.navigate("quiz_screen6")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}

@Composable
fun QuizScreen6(navController: NavController, context: Context) {
    var selectedAnswer by remember { mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Question 6",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        RadioGroup(
            labelText = "Which of these IU songs was a collab with G-Dragon?",
            radioOptions = listOf("Lilac", "Ending Scene", "Twenty-three", "Palette"),
            selectedOption = selectedAnswer,
            onSelected = { selectedAnswer = it },
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { if(isCorrect(selectedAnswer)) {
                Toast.makeText(context, "The answer is correct", Toast.LENGTH_SHORT).show()
                totalCorrect++
            } else {
                Toast.makeText(context, "The answer is wrong", Toast.LENGTH_SHORT).show()
            }
                navController.navigate("last_screen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}

@Composable
fun LastScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {Text(
        text = "Game Over",
        fontSize = 36.sp,
        modifier = Modifier.padding(bottom = 15.dp)
    )
        Text(
            text = "Your statistics:",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Text(
            text = "Questions Correct",
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Text(
            text = "$totalCorrect/7",
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 15.dp),
            color = Color.White
        )
    }
}

fun isCorrect(userAnswer:String) : Boolean {
    if(answerKey[index] == userAnswer) {
        index++
        return true
    } else {
        index++
        return false
    }
}


@Composable
fun RadioGroup(
    labelText: String,
    radioOptions: List<String>,
    selectedOption: String,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isSelectedOption: (String) -> Boolean = { selectedOption == it }

    Column {
        Text(labelText)
        radioOptions.forEach { option ->

            val backgroundColor = if (isSelectedOption(option)) Color.Magenta else Color.White
            Row(
                modifier = modifier
                    .selectable(
                        selected = isSelectedOption(option),
                        onClick = { onSelected(option)},
                        role = Role.RadioButton
                    )
                    .background(backgroundColor)
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = isSelectedOption(option),
                    onClick = null,
                    modifier = modifier.padding(end = 8.dp)
                )
                Text(
                    text = option,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}