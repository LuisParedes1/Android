package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantScreen()
                }
            }
        }
    }
}


@Composable
fun CardScreen(title: String, content: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(backgroundColor).padding(16.dp).fillMaxSize()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier){
    Column (Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)){
            CardScreen(
                title = stringResource(R.string.title_text_composable),
                content = stringResource(R.string.description_text_composable),
                backgroundColor = colorResource(R.color.first_color),
                modifier = Modifier.weight(1f)
            )
            CardScreen(
                title = stringResource(R.string.title_image_composable),
                content = stringResource(R.string.description_image_composable),
                backgroundColor = colorResource(R.color.second_color),
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            CardScreen(
                title = stringResource(R.string.title_row_composable),
                content = stringResource(R.string.description_row_composable),
                backgroundColor = colorResource(R.color.third_color),
                modifier = Modifier.weight(1f)
            )
            CardScreen(
                title = stringResource(R.string.title_column_composable),
                content = stringResource(R.string.description_column_composable),
                backgroundColor = colorResource(R.color.fourth_color),
                modifier = Modifier.weight(1f)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    CardScreen(
        title = "Hello World",
        content = "This is a test",
        backgroundColor = colorResource(R.color.first_color)
    );
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    MyApplicationTheme {
        QuadrantScreen()
    }
}