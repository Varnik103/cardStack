package com.example.cred_project.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cred_project.R

@Composable
fun emiOption(){
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 5.dp)
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            style = TextStyle(
                fontSize = 20.sp,
            ),
            text = "How do you wish to repay?",
            color = Color(0xFF798393),
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 20.sp
            ),
            text = "Choose one of your recommended plans or make your own",
            color = Color(0xFF434a5c) // Set the text color to #798393
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row() {
            Image(
                painter = painterResource(id = R.drawable.ninemonth),
                contentDescription = "Your Image",
                modifier = Modifier
                    .size(200.dp)
            )

//            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(id = R.drawable.twelvemonth),
                contentDescription = "Your Image",
                modifier = Modifier
                    .size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF808c9d),
                    shape = RoundedCornerShape(30.dp)
                )
        ) {
            Text(
                style = TextStyle(
                    fontSize = 15.sp
                ),
                text = "Create your own plan",
                color = Color(0xFF95a3b5),
                modifier = Modifier.padding(15.dp)
            )
        }
        Spacer(modifier = Modifier.height(240.dp))
    }
}