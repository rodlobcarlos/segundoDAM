const express = require('express') 
const router = express.Router();

router.get('/', (req, res) => {
    res.render("peques", { 
        arrayPeques: [ 
            {id: '1', nombre: 'Miguel', edad:'20'},
            {id: '2', nombre: 'María', edad:'30'},
            {id: '3', nombre: 'Enrrique', edad:'40'}
        ]
    })
})
module.exports = router;