package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Composable
fun LemonImgAndTextScreen(img: Painter,
                          imgDesc: String,
                          msgText: String,
                          onClick: ()->Unit,
                          modifier: Modifier = Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){


        Image(img,
            contentDescription = imgDesc,
            modifier = modifier
                .background(Color.Green)
                .clickable(enabled = true, onClick = onClick)
        )

        Spacer(modifier =  Modifier.height(16.dp))

        Text(
            text = msgText,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    val INIT_SCREEN_NUM = 1

    // screen is between 1 and 4
    var screen by remember {
        mutableIntStateOf(INIT_SCREEN_NUM)
    }

    var img: Painter
    var imgDescription: String
    var msg: String
    var onClick: ()->Unit

     when(screen){
        1 -> {
            img = painterResource(id = R.drawable.lemon_tree)
            imgDescription = stringResource(id = R.string.lemon_tree_img_desc)
            msg = stringResource(id =R.string.lemon_tree_text)
            onClick = { screen++ }
        }

        2 -> {
            img = painterResource(id = R.drawable.lemon_squeeze)
            imgDescription = stringResource(id = R.string.lemon_img_desc)
            msg = stringResource(id =R.string.lemon_squeeze_text)

            var numberTaps =  (2..4).random()

            onClick = {

                numberTaps--

                if(numberTaps == 0){
                    screen++
                }
            }
        }

        3 -> {
            img = painterResource(id = R.drawable.lemon_drink)
            imgDescription = stringResource(id = R.string.glass_of_lemonade_img_desc)
            msg = stringResource(id =R.string.lemon_drink_text)
            onClick = { screen++ }
        }

        else -> {
            img = painterResource(id = R.drawable.lemon_restart)
            imgDescription = stringResource(id = R.string.empty_glass_img_desc)
            msg = stringResource(id =R.string.lemon_restart_text)
            onClick = { screen = INIT_SCREEN_NUM }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

    Box (
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    ){
        LemonImgAndTextScreen(
            img,
            imgDescription,
            msg,
            onClick,
            modifier
        )
    }
    }
}

