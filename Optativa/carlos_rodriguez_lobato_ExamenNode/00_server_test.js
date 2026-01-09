const express = require('express') 
const app = express() 
const port = 3000 


app.set('view engine', 'ejs')
app.set('views', __dirname + '/views')


app.use('/nuestrasAutoEscuelas', require('./router/escuelas'));
app.use('/peques', require('./router/peques'));
app.use('/escuelas', require('./router/escuelas'));

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/public/autoescuela.jpg');
});

app.get('/contacto', (req, res) => {
    res.render("contacto", {
        titulo : "Bienvenido!!!",
        descripcion : "Aquí puedes contactar con nosotros para dudas.",
        telefono : "34+ 213354523",
        correo : "recursoshumanos@gmail.com"
    })
})

app.get('/quienes_somos', (req, res) => {
    res.render("quienes_somos", {
        titulo : "Sobre nosotros",
        descripcion : "Somos una autoescuela que estará a tu disposición en todo momento.",
    })
})

app.listen(port, () => { 
  console.log(`Example app listening at http://localhost:${port}`)
})