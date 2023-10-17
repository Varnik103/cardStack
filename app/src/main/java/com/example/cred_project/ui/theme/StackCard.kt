package com.example.cred_project.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cred_project.ExpandableCardRow
import com.example.cred_project.R


@Composable
fun StackManager(viewModel: StackCardViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val colors = arrayOf(Color.Red, Color.Blue, Color.Gray)
    val backgroundColor = Color(0xFF161922).copy(0.8f)
    BackHandler() {
        viewModel.onBackLogic(context)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var len = viewModel.cardStateList1.size

        Column(
            modifier = Modifier
                .fillMaxSize()
//                .border(5.dp, Color.Yellow),

            ) {
            println("recomposed")
            for (index in viewModel.cardStateList1.size - 1 downTo 0) {
                val item = viewModel.cardStateList1[index]


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            translationY = (index * 50f)
                        }
                        .background(backgroundColor)
                ) {
                    ExpandableCardRow(
                        title = item.heading.value,
                        expandedState = item.isExpanded.value,
                        onRowClicked = {
                            viewModel.onCardClicked(item.id.value)
                        },
                        expandedCard = {
                            item.cardContent()
                        },
                    )
                }
                len -= 1
            }
        }

        Column() {
            if (!viewModel.cardStateList2.isEmpty()) {
                val item = viewModel.cardStateList2[0]
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ExpandableCardRow(
                        title = item.heading.value,
                        expandedState = item.isExpanded.value,
                        onRowClicked = {
                            viewModel.onCardClicked(item.id.value)
                        },
                        expandedCard = {
                            item.cardContent()
                        },
                        isBottom = true
//                        viewModel.cardStateList1.size.toFloat()
                    )
                }
            }
        }
    }
}