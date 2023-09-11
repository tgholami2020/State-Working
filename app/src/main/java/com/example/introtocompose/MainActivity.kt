package com.example.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color((0xFF546E7a))
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$100", style = TextStyle(
                    color=Color.White,
                    fontSize = 35.sp,
                    fontWeight =FontWeight.ExtraBold))
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle()
        }
    }
}

@Composable
fun CreateCircle(){
    var moneyCounter by remember {
        mutableStateOf(0)
    }
    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
            moneyCounter += 1
            Log.d("Counter", "Create Article:$moneyCounter")
        },
        shape = RectangleShape)
    {
        Box (modifier= Modifier,
            contentAlignment = Alignment.Center)
        {
            Text(text = "Tap $moneyCounter",modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroToComposeTheme {
       MyApp()
    }
}