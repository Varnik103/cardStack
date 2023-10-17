package com.example.cred_project.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.lifecycle.ViewModel
import credLimit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class StackItem(
    val id: MutableState<Int> = mutableStateOf(0),
    val isExpanded: MutableState<Boolean> = mutableStateOf(false),
    val heading: MutableState<String> = mutableStateOf(""),
    val cardContent: @Composable () -> Unit
)

@HiltViewModel
class StackCardViewModel @Inject constructor() : ViewModel() {

    private val _cardStateList1 = mutableListOf<StackItem>(
        StackItem(
            id = mutableStateOf(1),
            isExpanded = mutableStateOf(true),
            heading = mutableStateOf("Explore Cred Limit"),
            cardContent = {
                credLimit()
            }
        ),
    )
    val cardStateList1: MutableList<StackItem> get() = _cardStateList1

    private val _cardStateList2 = mutableListOf<StackItem>(
        StackItem(
            id = mutableStateOf(2),
            isExpanded = mutableStateOf(false),
            heading = mutableStateOf("Proceed to emi selection"),
            cardContent = {
                emiOption()

            }
        ),
        StackItem(
            id = mutableStateOf(3),
            isExpanded = mutableStateOf(false),
            heading = mutableStateOf("Back Account"),
            cardContent = {
//                Column(
//                    modifier = Modifier
//                        .background(Color(0xFF161922))
//                ) {
                    BankOptions()
//                }
            }
        ),
        StackItem(
            id = mutableStateOf(4),
            isExpanded = mutableStateOf(false),
            heading = mutableStateOf("Tap for 1-click KYC"),
            cardContent = { }
        ),
    )
    val cardStateList2: MutableList<StackItem> get() = _cardStateList2


    fun onCardClicked(id: Int) {
        println("clicked id is ${id}")
        if (_cardStateList2.isNotEmpty() && _cardStateList2[0].id.value == id) {
            _cardStateList1[0].isExpanded.value = false
            _cardStateList1.add(0, _cardStateList2[0])
            _cardStateList2.removeAt(0)
            _cardStateList1[0].isExpanded.value = true
        } else {
            while (_cardStateList1.isNotEmpty()) {
                if (_cardStateList1[0].id.value == id) {
                    cardStateList1[0].isExpanded.value = true
                    break
                } else {
                    _cardStateList1[0].isExpanded.value = false
                    if (_cardStateList2.isEmpty()) {
                        _cardStateList2.add(_cardStateList1[0])
                    } else {
                        _cardStateList2.add(0, _cardStateList1[0])
                    }
                    _cardStateList1.removeAt(0)
                    _cardStateList1[0].isExpanded.value = true

                }
            }
        }


    }

    fun onBackLogic(context: Context) {
//
        if(_cardStateList1.size == 1){
            finishAffinity(context as Activity)
            return
        }

        _cardStateList1[0].isExpanded.value = false
        if (_cardStateList2.isEmpty()) {
            _cardStateList2.add(_cardStateList1[0])
        } else {
            _cardStateList2.add(0, _cardStateList1[0])
        }
        _cardStateList1.removeAt(0)
        _cardStateList1[0].isExpanded.value = true
    }

}