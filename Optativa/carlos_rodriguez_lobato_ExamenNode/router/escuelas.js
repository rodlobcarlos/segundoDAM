const express = require('express') 
const router = express.Router();

router.get('/', (req, res) => {
    res.render("escuelas", { 
        arrayEscuelas: [
            {id: '1', nombre: 'Tu coche', mensaje:' Vente a mi autoescuela y sacate el carnet a la primera.'},
            {id: '2', nombre: 'AutoSchool', mensaje:' El mejor precio no lo tiene cualquiera.'},
            {id: '3', nombre: 'Al volante', mensaje:' En las practicas te quitamos el miedo, subete!!.'}
        ]
    })
})
module.exports = router;