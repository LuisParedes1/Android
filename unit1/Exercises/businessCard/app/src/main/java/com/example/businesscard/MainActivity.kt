package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val fullName = stringResource(R.string.full_name)
                    val title = stringResource(R.string.title)
                    val phoneNumber = stringResource(R.string.phone_number)
                    val socialMedia = stringResource(R.string.social_media)
                    val email = stringResource(R.string.email)
                    val imgLogo = painterResource(R.drawable.android_logo)
                    BusinessScreen(fullName, title, imgLogo, phoneNumber, socialMedia, email)
                }
            }
        }
    }
}

@Composable
fun Logo(fullName: String, title: String, imgLogo: Painter, modifier: Modifier = Modifier){
    return Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ){
        Image(painter = imgLogo,
            contentDescription = null,
            modifier = Modifier
                .background(Color(R.color.black))
                .height(100.dp)
                .width(100.dp)
            )
        Text(
            text = fullName,
            fontSize = 26.sp,
            modifier = modifier
        )
        Text(
            text = title,
            modifier = modifier
        )


    }
}

@Composable
fun ContactInfo(phoneNumber: String,
                socialMedia: String,
                email: String,
                modifier: Modifier){
    return Column (
    ) {
        Row {
            Image(Icons.Rounded.Call, contentDescription = null)
            Text(
                text = "+$phoneNumber",
                modifier = modifier.padding(start = 16.dp)
            )
        }

        Row {
            Image(Icons.Rounded.Share, contentDescription = null)
            Text(
                text = "@$socialMedia" ,
                modifier = modifier.padding(start = 16.dp)
            )
        }
        Row{
            Image(Icons.Rounded.Email, contentDescription = null)
            Text(
                text = email,
                modifier = modifier.padding(start = 16.dp)
            )
        }

    }
}

@Composable
fun BusinessScreen(fullName: String,
                   title: String,
                   imgLogo: Painter,
                   phoneNumber: String,
                   socialMedia: String,
                   email: String,
                   modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
            .background(Color(0xFF3ddc84))
            .padding(16.dp)
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Logo(fullName, title, imgLogo, modifier)
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
            ){
            ContactInfo(phoneNumber, socialMedia, email, modifier)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        val fullName = stringResource(R.string.full_name)
        val title = stringResource(R.string.title)
        val phoneNumber = stringResource(R.string.phone_number)
        val socialMedia = stringResource(R.string.social_media)
        val email = stringResource(R.string.email)
        val imgLogo = painterResource(R.drawable.android_logo)

        BusinessScreen(fullName, title, imgLogo, phoneNumber, socialMedia, email)
    }
}