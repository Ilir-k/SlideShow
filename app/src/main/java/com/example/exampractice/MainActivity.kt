package com.example.exampractice

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exampractice.ui.theme.ExamPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Photos()
                }
            }
        }
    }
}



@Composable
fun Photos() {
    var input by remember { mutableIntStateOf(0) }
    var curImage by remember { mutableIntStateOf(0) }
    val imageList = listOf(
        painterResource(id = R.drawable.i1),
        painterResource(id = R.drawable.i2),
        painterResource(id = R.drawable.i3),
        painterResource(id = R.drawable.i4),
        painterResource(id = R.drawable.i5))
    val imageDescription = listOf(
        "Photo 0",
        "Photo 1",
        "Photo 2",
        "Photo 3",
        "Photo 4"
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = imageList[curImage],
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(300.dp).padding(24.dp)
        )
        Text(
            text = imageDescription[curImage],
            modifier = Modifier.padding(16.dp)
        )

        Row()
        {

            TextField(
                value = input.toString(),
                onValueChange = {input = it.toIntOrNull() ?: 0},
                modifier = Modifier.padding(16.dp),
                singleLine = true,
                label = { Text(text = "Image Select (0-4)") }
            )
            Button(
                onClick = {
                    if(input > imageList.size - 1) input = 0
                    else if(input < 0) input = 0
                    curImage = input

                },
                modifier = Modifier.padding(16.dp),
                content = {
                    Text(text = "Go")
                }
            )
        }

        Row()
        {
            Button(
                onClick = {
                    if(curImage == 0) curImage = imageList.size - 1
                    else curImage--
                },
                modifier = Modifier.padding(16.dp),
                content = {
                    Text(text = "Back")
                }
            )

            Button(
                onClick = {
                    if(curImage >= imageList.size - 1) curImage = 0
                    else curImage++
                },
                modifier = Modifier.padding(16.dp),
                content = {
                    Text(text = "Next")
                }
            )
        }
    }
}
