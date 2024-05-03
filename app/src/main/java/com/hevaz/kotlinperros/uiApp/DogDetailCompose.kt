package com.hevaz.kotlinperros.uiApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.hevaz.kotlinperros.data.DogModel

@Preview
@Composable
fun DogDetailCompose() {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .padding(start = 8.dp, end = 8.dp, bottom = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        val dog = DogModel(
            1L,
            12,
            "asd",
            "asd",
            "12",
            "23",
            "https://static.fundacion-affinity.org/cdn/farfuture/PVbbIC-0M9y4fPbbCsdvAD8bcjjtbFc0NSP3lRwlWcE/mtime:1643275542/sites/default/files/los-10-sonidos-principales-del-perro.jpg",
            "23",
            "asd",
            "32",
            "31"
        )
        DogInformation(dog)
        Image(
            modifier = Modifier
                .width(270.dp)
                .padding(top = 50.dp),
            painter = rememberImagePainter(dog.imageUrl), contentDescription = ""
        )
    }
}

@Composable
fun DogInformation(dog: DogModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 180.dp)

    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dog.index.toString(), // Convertir a String si es necesario
                    fontSize = 32.sp, // En lugar de 32.dp para el tamaño del texto
                    color = Color.Black,
                    textAlign = TextAlign.End
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dog.name.toString(),
                    fontSize = 32.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dog.lifeExpectancy.toString() + " años",
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )


                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = dog.temperament.toString(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,

                    )

                Divider(
                    modifier =
                    Modifier.padding(top = 18.dp, start = 8.dp, end = 8.dp, bottom = 16.dp),
                    thickness = 1.dp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DogDateColumn(
                        modifier = Modifier.weight(1f),
                        "FEMALE",
                        dog.weightFemale,
                        dog.heightFemale
                    )
                    VerticalDivider()
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = dog.type,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,

                            )

                        Text(
                            modifier = Modifier.padding(top = 18.dp),
                            text = "Group",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,

                            )

                    }

                    VerticalDivider()

                    DogDateColumn(
                        modifier = Modifier.weight(1f),
                        "MALE",
                        dog.weightMale,
                        dog.heightMale
                    )

                }

            }
        }
    }
}

@Composable
private fun VerticalDivider() {
    Divider(
        modifier = Modifier
            .height(42.dp)
            .width(1.dp), color = Color.Gray
    )
}

@Composable
private fun DogDateColumn(modifier: Modifier, genre: String, weight: String, height: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = genre,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,

            )

        Text(
            modifier = Modifier.padding(top = 18.dp),
            text = weight,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Weight",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,

            )

        Text(
            modifier = Modifier.padding(top = 18.dp),
            text = height,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Height",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,

            )
    }
}
