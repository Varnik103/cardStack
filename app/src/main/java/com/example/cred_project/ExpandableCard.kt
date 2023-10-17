package com.example.cred_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpandableCardRow(
    title: String,
    expandedState: Boolean = false,
    onRowClicked: () -> Unit = {},
    expandedCard: @Composable () -> Unit = {},
    isBottom: Boolean = false
) {
    val backgroundColor = if(!isBottom) Color(0xFF161922).copy(0.2f) else Color(0xFF3b479b)



    Column(
        modifier =
            Modifier.fillMaxSize()
//                .border(5.dp, Color.Red)
    ) {

        Row(Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onRowClicked() }
            .background(backgroundColor, RoundedCornerShape(5.dp)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                color = Color.White,
                style = TextStyle(fontSize = 20.sp),
                fontWeight = FontWeight(500)
            )

            IconButton(onClick = { onRowClicked() }, modifier = Modifier.align(Alignment.CenterVertically)) {
                Icon(
                    painter = painterResource(id = if (expandedState) R.drawable.baseline_keyboard_arrow_up_24 else R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = "Expandable icon",
                    tint = Color.White
                )
            }

        }
        if (expandedState) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(Color(0xFF161922))
            ) {
                expandedCard()
            }
        }
    }
}