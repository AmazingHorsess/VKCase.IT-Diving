package com.example.trenin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.trenin.ui.theme.*

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Функция, которая создает Intent для открытия приложения "Сообщения"
        fun openSms() {
            val smsintent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:"))
            startActivity(smsintent)
        }

        //Функция, которая создает Intent для открытия приложения "Контакты"
        fun openContact() {
            val contactintent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
            startActivity(contactintent)

        }
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                TopBlackTwo,
                                BottomGray
                            ),
                            startY = 300f,
                            endY = 500f
                        )
                    )
            ) {
                //Контент
                Column {

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp)
                    )

                    var isSwapped by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        //Header
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth()
                                .background(color = TopBlackTwo)
                                .padding(16.dp)
                        ) {
                            Icon(painter = painterResource(R.drawable.ic_chat),
                                tint = Color.White,
                                contentDescription = "Иконка чата",
                                modifier = Modifier
                                    .clickable(onClick = { openSms() })
                            )
                            Icon(painter = painterResource(R.drawable.union),
                                tint = Color.White,
                                contentDescription = "Иконка чата",
                                modifier = Modifier
                                    .clickable(onClick = { openContact() })
                            )
                            Icon(painter = painterResource(R.drawable.ic_cube),
                                tint = Color.White,
                                contentDescription = "Иконка чата",
                                modifier = Modifier
                                    .clickable(onClick = { isSwapped = !isSwapped })
                            )
                        }
                        if (isSwapped) {
                            MemberCall()
                            MemberCallTwo()
                        } else {
                            MemberCallTwo()
                            MemberCall()
                        }
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp)
                        )

                        Futter()
                    }
                }
            }
        }
    }
}







