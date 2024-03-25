package com.eglelue.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eglelue.coffeemasters.ui.theme.Alternative2

@Preview(showBackground = true, widthDp = 400)
@Composable
private fun Offer_Preview() {
    Offer("Title", "Description")
}


@Preview(showBackground = true, widthDp = 400)
@Composable
fun OffersPage() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffe", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
    }
}

@Composable
fun Offer(title: String, description: String) {
    var style = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    Box(modifier = Modifier.padding(16.dp)){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "BG",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = title,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = description,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Alternative2)
            )
        }
    }
}