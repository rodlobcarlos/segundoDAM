var http = require("http")

function webServer(req,res) {
    res.writeHead(200, {'Content-Type': 'text/html'}).end('<h1>Hola Node.js</h1>')
}

http
    .createServer(webServer)
    .listen(3000, 'localhost')
console.log("servidor corriendo en http://localhost:3000")