package com.example.cred_project.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cred_project.R


@Composable
fun BankOptions(){

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            style = TextStyle(
                fontSize = 20.sp,
            ),
            text = "Where should we send the money?",
            color = Color(0xFF798393),
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 20.sp
            ),
            text = "amount will be credited to this bank account, EMI will also be debited from this bank account",
            color = Color(0xFF434a5c) // Set the text color to #798393
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically// Pushes the image to the right
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image: Painter = painterResource(id = R.drawable.hdfc)
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(15.dp))
                ) {
                    Image(
                        painter = image,
                        contentDescription = "Your Image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column() {
                    Text(
                        style = TextStyle(
                            fontSize = 15.sp
                        ),
                        text = "HDFC Bank",
                        color = Color(0xFFb6b9c5)
                    )
                    Text(
                        style = TextStyle(
                            fontSize = 15.sp
                        ),
                        text = "50100117009192",
                        color = Color(0xFF4f5261)
                    )
                }
            }
            val checkImage: Painter = painterResource(id = R.drawable.check)
            Image(
                painter = checkImage,
                contentDescription = "Check Image",
                modifier = Modifier.size(25.dp)
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
                text = "Change Account",
                color = Color(0xFF95a3b5),
                modifier = Modifier.padding(15.dp)
            )
        }
        Spacer(modifier = Modifier.height(340.dp))
    }

}