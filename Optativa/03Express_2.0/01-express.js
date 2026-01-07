const express = require('express') //Requerimos Express
const app = express() //Variable para utilizar lo que estamos requiriendo
const port = 3000 //Habitualmente el 3000 para entornos locales
//Cuando lo subamos a un servidor real, deberemos cambiarlo, COMO YA VEREMOS

app.set('view engine', 'ejs')
app.set('views', __dirname + '/views')

app.use(express.static(__dirname + '/public'));

//Vamos a recibir una petición realizada por el cliente mediante GET,
//que como ya hemos visto y sabemos viene determinada por la URL
app.get('/', (req, res) => {  //Usamos la función flecha (para evitar crear ninguna función)
// Siempre, siempre, siempre tendremos un requerimiento (req) y una respuesta (res)
// La barra, como sabemos, es para que busque en la raíz (localhost) 
 res.render("index", {titulo : "mi titulo dinámico!!"})
})

app.get('/contacto', (req, res) => {
    res.render("contacto", {tituloContacto : "Estas en contactos de manera dinámica!!"})
})

app.use((req, res) => {
    res.status(404).render("404", {
        titulo : "Error 404",
        descripcion : "Página no encontrada"
    })
})

app.listen(port, () => { //Nuevamente, usamos la función flecha
  console.log(`Example app listening at http://localhost:${port}`)
  //Es importante mostrar el puerto, ya que cuando esté en producción
  //ese puerto será dinámico y habrá cambiado. Así podremos saber cual es
})