package com.compose.customalertdialogjetpackcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PopupDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
  /**
  onDismissRequest - Executes when the user tries to dismiss the Dialog by clicking outside or pressing the back button. This is not called when the dismiss button is clicked.
  confirmButton - A button which is meant to confirm a proposed action, thus resolving what triggered the dialog. The dialog does not set up any events for this button so they need to be set up by the caller.
  modifier - Modifier to be applied to the layout of the dialog.
  dismissButton - A button which is meant to dismiss the dialog. The dialog does not set up any events for this button so they need to be set up by the caller.
  title - The title of the Dialog which should specify the purpose of the Dialog. The title is not mandatory, because there may be sufficient information inside the text. Provided text style will be Typography.subtitle1.
  text - The text which presents the details regarding the Dialog's purpose. Provided text style will be Typography.body2.
  shape - Defines the Dialog's shape
  backgroundColor - The background color of the dialog.
  contentColor - The preferred content color provided by this dialog to its children.
  properties - Typically platform specific properties to further configure the dialog.
   */
  androidx.compose.material.AlertDialog(onDismissRequest = onDismiss, title = {
    Text(
      text = "Update title here", modifier = Modifier.padding(4.dp), fontWeight = FontWeight.Bold
    )
  }, text = {
    Text(text = "Update message here", modifier = Modifier.padding(4.dp))
  }, confirmButton = {
    Button(onClick = {
      /**
       * invoke onConfirm
       */
      /**
       * invoke onConfirm
       */
      onConfirm.invoke()
    }) {
      Text(text = "Ok")
    }
  }, dismissButton = {})
}
