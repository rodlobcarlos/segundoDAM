const express = require('express');
const router = express.Router();
const Pokemon = require('../models/pokemon');


router.get('/', async (req, res) => {
    try {
        //Le pondremos arrayPokemonDB para diferenciar
        //los datos que vienen de la base de datos
        //con respecto al arrayPokemon que tenemos EN LA VISTA
        const arrayPokemonDB = await Pokemon.find();
        console.log(arrayPokemonDB);
        res.render("pokemon", { 
            arrayPokemon: arrayPokemonDB
        })
    } catch (error) {
        console.error(error)
    }
})

router.get('/crear', (req, res) =>{
    res.render('crear')
})

router.post('/', async (req, res)=> {
    const body = req.body
    console.log(body)
    try{
        const pokemonDB = new Pokemon(body)
        await pokemonDB.save()
        res.redirect('/pokemon')
    } catch (error){
        console.log('error', error)
    }
})
module.exports = router;