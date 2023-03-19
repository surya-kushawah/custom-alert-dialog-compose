package com.compose.customalertdialogjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun CustomAlertDialog(onDismiss: () -> Unit, onConfirm: (name: String) -> Unit) {
  val name = remember { mutableStateOf(TextFieldValue("")) }
  AlertDialog(onDismissRequest = onDismiss, title = {
    Text(
      text = "Enter your name",
      modifier = Modifier
        .padding(4.dp)
        .height(48.dp),
      fontWeight = FontWeight.Bold
    )
  }, text = {
    Column(modifier = Modifier.fillMaxWidth()) {
      TextField(
        value = name.value,
        onValueChange = { name.value = it },
        label = { Text(text = "Your name") },
        placeholder = { Text(text = "Surya") },
        modifier = Modifier.padding(4.dp)
      )
    }
  }, confirmButton = {
    Button(onClick = {
      val input = name.value.text
      if (input.isNotEmpty()) onConfirm.invoke(input)
    }) {
      Text(text = "Add")
    }
  }, dismissButton = {
    Button(onClick = onDismiss) {
      Text(text = "Cancel")
    }
  })
}