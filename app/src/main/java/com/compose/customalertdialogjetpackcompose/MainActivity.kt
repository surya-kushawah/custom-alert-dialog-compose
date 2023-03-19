package com.compose.customalertdialogjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.customalertdialogjetpackcompose.ui.theme.CustomAlertDialogJetpackComposeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CustomAlertDialogJetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          AlertDialogPlayground()
        }
      }
    }
  }
}

@Composable
fun AlertDialogPlayground() {
  val showPopupDialog = remember { mutableStateOf(false) }
  val showAlertDialog = remember { mutableStateOf(false) }
  val showCustomDialog = remember { mutableStateOf(false) }
  val nameList = remember { mutableStateOf("") }
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    /**
     * Button for display popup alert dialog
     */
    Button(
      onClick = {
        showPopupDialog.value = true
      }, modifier = Modifier
        .padding(8.dp)
        .width(200.dp)
    ) {
      Text(text = "Show PopupDialog")
    }
    if (showPopupDialog.value) {
      PopupDialog(onDismiss = { showPopupDialog.value = false }, onConfirm = {
        showPopupDialog.value = false
      })
    }
    /**
     * Button for display alert dialog
     */
    Button(
      onClick = {
        showAlertDialog.value = true
      }, modifier = Modifier
        .padding(8.dp)
        .width(200.dp)
    ) {
      Text(text = "Show AlertDialog")
    }
    if (showAlertDialog.value) {
      AlertDialog(onDismiss = { showAlertDialog.value = false }, onConfirm = {
        showAlertDialog.value = false
      })
    }

    /**
     * Button for display  Custom alert dialog
     */
    Button(
      onClick = {
        showCustomDialog.value = true
      }, modifier = Modifier
        .padding(8.dp)
        .width(200.dp)
    ) {
      Text(text = "Show  CustomDialog")
    }
    if (showCustomDialog.value) {
      CustomAlertDialog(onDismiss = { showCustomDialog.value = false }, onConfirm = { name ->
        nameList.value = nameList.value + "\n" + name
        showCustomDialog.value = false
      })
    }

    Text(
      text = "List\n" + "----------------------------------------------------------------------------------" + nameList.value,
      modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .padding(16.dp),
      fontWeight = FontWeight.Normal
    )
  }
}









