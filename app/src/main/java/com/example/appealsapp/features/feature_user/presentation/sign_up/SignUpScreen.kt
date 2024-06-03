package com.example.appealsapp.features.feature_user.presentation.sign_up

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignUp

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel(),
    context: Context)
{
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val firstName = remember { mutableStateOf(("")) }
        val lastName = remember { mutableStateOf(("")) }
        val email = remember { mutableStateOf(("")) }
        val sex = remember { mutableStateOf(("")) }
        val phoneNumber = remember { mutableStateOf(("")) }
        val password = remember { mutableStateOf(("")) }
        val repeatPassword = remember { mutableStateOf(("")) }

        val regex = """(\d)(\d{3})(\d{3})(\d{2})(\d{2})""".toRegex()

        val userRequestSignUp = UserRequestSignUp(firstName.value,
            lastName.value,
            email.value,
            sex.value,
            regex.replace(phoneNumber.value, "+$1 $2 $3-$4-$5"),
            password.value)

        Text(text = "Регистрация", style = TextStyle(fontSize = 28.sp))

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Имя") },
            value = firstName.value,
            onValueChange = { firstName.value = it })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Фамилия") },
            value = lastName.value,
            onValueChange = { lastName.value = it })

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Адрес электронной почты") },
            value = email.value,
            onValueChange = { email.value = it })

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Пол") },
            value = sex.value,
            onValueChange = { sex.value = it })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Номер телефона") },
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it })

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Пароль") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text(text = "Повторите пароль") },
            value = repeatPassword.value,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { repeatPassword.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if(firstName.value != "" &&
                        lastName.value != "" &&
                        email.value != "" &&
                        sex.value != "" &&
                        phoneNumber.value != "" &&
                        password.value != "" && password.value.length > 5 &&
                        password.value == repeatPassword.value) {
                        viewModel.createUser(userRequestSignUp, navController, context)
                    } else Toast.makeText(context, "Для успешной регистрации требуется заполнить все нужные поля!", Toast.LENGTH_LONG).show()},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Зарегистрироваться")
            }
        }
    }
}