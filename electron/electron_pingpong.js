// main
ipcMain.on('check-request', (event, arg) => {
  console.log(arg) // prints “ping"
  autoUpdater.checkForUpdates()
  event.sender.send('check-done', 'pong')
})

// render
ipcRenderer.on(‘check - done', (event, arg) => {
 console.log(arg) // prints "pong"
})
ipcRenderer.send(‘check - request', 'ping')
