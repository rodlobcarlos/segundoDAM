
const express = require('express')
const app = express()
const port = 3000

// motor de plantillas 
app.set('view engine', 'ejs');

// carpeta de las vistas
app.use('views', express.static(__dirname + '/views'));

// para poder usar la carpeta donde tengamos ficheros (middleworld)
app.use(express.static(__dirname + '/public'))

// llamamos al fichero de las rutas
/*
app.use('/', require('./router/rutas'));
app.use('/pokemon', require('./router/pokemon'));


app.get('/pruebas', (req, res) => {
    //console.log(__dirname + '/public') // pinta la ruta de donde estamos
  res.render('pruebas', {titulo:'Título dinámico'})
})
*/

app.get("/inicio", (req, res) => {
    res.render("inicio");
});

app.get("/quienes_somos", (req, res) => {
    res.render("quienes_somos");
});

app.get("/contacto", (req, res) => {
    res.render("contacto");
});

app.get("/nuestras_autoescuela", (req, res) => {
    res.render("nuestras_autoescuela");
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})