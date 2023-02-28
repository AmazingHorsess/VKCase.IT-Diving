package com.example.trenin.ui.theme
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trenin.R

@Composable
fun MemberCall(
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .width(411.dp)
            .height(300.dp)
            .padding(5.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        FirstMemberColorOne,
                        FirstMemberColorTwo,
                        FirstMemberColorThree,
                        FirstMemberColorFour,
                        FirstMemberColorFive,
                        FirstMemberColorSix,
                        FirstMemberColorSeven,
                        FirstMemberColorEight,
                        FirstMemberColorNine,
                        FirstMemberColorTen
                    ),
                    startY = 25f,
                    endY = 500f
                )


            ),
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)

        ) {
            // Закругленная картинка
            Image(
                painter = painterResource(R.drawable.ff71302ed61038d85001215cdd99cc07),
                contentDescription = "Картинка пользователя", contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .padding(top = 16.dp)
                    .size(128.dp)
                    .clip(CircleShape)
            )
            Row(
                horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                CenterText()
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_mic_off_24),
                    tint = Color.White,
                    contentDescription = "Иконка выключенного микрофона у пользователя"
                )
            }
        }
    }
}

@Composable
fun MemberCallTwo() {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .width(411.dp)
            .height(300.dp)
            .padding(5.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(SecondMemberColorOne, SecondMemberColorTwo),
                )
            ),
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)

        ) {
            // Закругленная картинка
            Image(
                painter = painterResource(R.drawable.images), contentScale = ContentScale.Crop,
                contentDescription = "Картинка второго пользователя",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .padding(top = 16.dp)
                    .size(128.dp)
                    .clip(CircleShape)
            )
            Row(
                horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                CenterTextTwo()
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_mic_off_24),
                    tint = Color.White,
                    contentDescription = "Иконка выключенного микрофона у второго пользователя"
                )
            }
        }
    }
}

@Composable
fun CenterText() {
    Text(
        "You", textAlign = TextAlign.End,
        color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(horizontal = 6.dp),
    )
}

@Composable
fun CenterTextTwo() {
    Text(
        "Venera Phone Long Contact For Test And Test Again SDSDSADASDASDSADSADASDADSDSADADADSDSSDSADASDASDADADADSDDADADADSDSADASDDADSADADADAD",
        textAlign = TextAlign.End,
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .fillMaxWidth(.5f)


    )
}

@Preview
@Composable
fun ImageSwapScreen() {
    var isSwapped by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isSwapped) {
            MemberCall()
            MemberCallTwo()
        } else {
            MemberCallTwo()
            MemberCall()
        }
        Button(
            onClick = { isSwapped = !isSwapped },
            modifier = Modifier
                .fillMaxWidth()
        ) {
        }
    }
}

@Composable
fun Futter() {
    val openDialog = remember { mutableStateOf(false) }
    val activity = (LocalContext.current as? Activity)
    var videocampress by remember { mutableStateOf(false) }
    var micropressed by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(70.dp)
                .clip(shape = CircleShape)
                .background(Color(red = 0x36, green = 0x37, blue = 0x38, alpha = 0xFF))
        ) {
            Icon(painter = painterResource(R.drawable.ic_baseline_videocam_24),
                contentDescription = "Иконка включенной вебкамеры",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = { videocampress = !videocampress })
            )
            if (videocampress) {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .size(70.dp)
                        .clip(shape = CircleShape)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_videocam_off_24),
                        contentDescription = "Иконка выключенной вебкамеры",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .size(70.dp)
                .clip(shape = CircleShape)
                .background(Color(red = 0x36, green = 0x37, blue = 0x38, alpha = 0xFF))
        ) {
            Icon(painter = painterResource(R.drawable.baseline_mic_24),
                contentDescription = "Иконка включенного микрофона",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = { micropressed = !micropressed })
            )
            if (micropressed) {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .size(70.dp)
                        .clip(shape = CircleShape)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_mic_off_24),
                        contentDescription = "Иконка выключенного микрофона",
                        tint = Color.Black,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .size(70.dp)
                .clip(shape = CircleShape)
                .background(Color(red = 0x36, green = 0x37, blue = 0x38, alpha = 0xFF))
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_hands_up),
                contentDescription = "Иконка поднятой руки",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = { openDialog.value = true })
            )
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = { Text(text = "Привет!") },
                    text = { Text("Привет!") },
                    buttons = {
                        Button(modifier = Modifier
                            .fillMaxWidth(),
                            onClick = { openDialog.value = false }
                        ) {
                            Text("OK")
                        }
                    })
            }
        }
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .size(70.dp)
                .clip(shape = CircleShape)
                .background(Color(red = 0xE6, green = 0x46, blue = 0x46, alpha = 0xFF))
        ) {
            Icon(painter = painterResource(R.drawable.ic_phone),
                contentDescription = "Иконка сброса звонка",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = { activity?.finishAndRemoveTask() })
            )
        }
    }
}




