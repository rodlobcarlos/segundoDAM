const express = require('express')
const app = express()
const port = 3000

app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {
    res.send('Ya somos unos cracks en NodeExpress')
})

app.get('/contacto.html', (req, res) => {
  res.send('Estás en contacto')
})

app.get('/aboutUs.html', (req, res) => {
  res.send('aboutUs')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})