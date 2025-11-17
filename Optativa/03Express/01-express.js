const { render } = require('ejs');
const express = require('express')
const app = express()
const port = 3000

app.use(express.static(__dirname + '/public'));
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {
    res.send('Ya somos unos cracks en NodeExpress')
})

app.get('/pruebas', (req, res) => {
    res.render("pruebas", {titulo: "Titulo dinamico"})
})

app.get('/contacto.html', (req, res) => {
  res.send('Estás en contacto')
})

app.get('/aboutUs.html', (req, res) => {
  res.send('aboutUs')
})

app.use((req, res) => {
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})