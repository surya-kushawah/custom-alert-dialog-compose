package com.compose.customalertdialogjetpackcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
  androidx.compose.material.AlertDialog(onDismissRequest = onDismiss, title = {
    Text(text = "Request Failed", modifier = Modifier.padding(4.dp), fontWeight = FontWeight.Bold)
  }, text = {
    Text(
      text = "We encounter some issue in APIs, Please try again", modifier = Modifier.padding(4.dp)
    )
  }, confirmButton = {
    //
    Button(onClick = {
      onConfirm.invoke()
    }) {
      /**
       * invoke onConfirm pass any param if needed
       */
      /**
       * invoke onConfirm pass any param if needed
       */
      Text(text = "Retry")
    }
  }, dismissButton = {
    Button(onClick = onDismiss) {
      Text(text = "Cancel")
    }
  })
}
