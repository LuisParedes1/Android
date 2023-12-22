package com.example.composearticle

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val headerImg: Painter = painterResource(R.drawable.bg_compose_background)
                    val title: String = stringResource(R.string.title_text)
                    val description: String = stringResource(R.string.description_text)
                    val article: String = stringResource(R.string.description_text)

                    ArticleScreen(headerImg = headerImg, title = title, description = description, article = article)
                }
            }
        }
    }
}

@Composable
fun ArticleScreen(
    headerImg: Painter,
    title: String,
    description: String,
    article: String,
    modifier: Modifier = Modifier
) {

    Column (modifier = Modifier
        .fillMaxSize()
    ) {
        // Set the image to fill the entire screen's width.
        Image(painter = headerImg,
            contentDescription = null
            )

        // Set the first Text composable to a 24sp font size and
        // 16dp padding (start, end, bottom, and top).
        Text(
            text = title,
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(16.dp)
        )

        // Set the second Text composable to a default font size,
        // 16dp padding(start and end), and Justify text align.
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start =  16.dp, end = 16.dp)
        )

        // Set the third Text composable to a default font size,
        // 16dp padding (start, end, bottom, and top), and Justify text align
        Text(
            text = article,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleScreen(
            painterResource(R.drawable.bg_compose_background),
            stringResource(R.string.title_text),
            stringResource(R.string.description_text),
            stringResource(R.string.article_text)
        )
    }
}