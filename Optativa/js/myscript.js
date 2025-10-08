function $(selector) {
    return document.querySelector(selector);
}

/*
console.log("Hola buenos dias!");

var table = "Normal Table";
let chair = "One chair";

let testBoolean = true;
console.log(testBoolean);

let testString = "text";
console.log(testString);

let testnumber = 10;
console.log(testnumber);

let testBooleanObject = new Boolean(true);
console.log(testBooleanObject);

let testNumberObject = new Number(10);
console.log(testNumberObject);

let testStringObject = new String("text");
console.log(testStringObject);

let name = "John";
let surname = "doe";
let question = "How are you"+name+" "+surname+"?";
let answer = `How are you`+name+` `+surname+`?`;

let operador_a = 3;
let operador_b = 3;
let expo = operador_a** operador_b;
let inc = ++operador_a;
let dec = --operador_a;
console.log(expo);
console.log(inc);
console.log(dec);

// Typeof, null & undefinded
let testboolean = true;
let testNumber = 12;
let teststring = "Hello";
let testbooleanObject = new Boolean(true);

// Typeof, null & undefined I
let testNull = null;
console.log(testNull);

// Typeof, null & undefined II
let testUndefined;
console.log(testUndefined);

//Array definition
var first_array = [];
var second_array = new Array(3);
var third_array = new Array(3,5,"Seville",true,third_array);
var fourth_array = new Array(3,5);
console.log(first_array);
console.log(second_array),
console.log(third_array);

//Array access
console.log(third_array[1]);
console.log(fourth_array[1][0]);

// Array push 
console.log(fourth_array.push("Spain"));

var array = new Array(3,4,6,7,8,9,10,3,2,1,3,5,4,9,78,45,32,12,3,65);
for(var i= 0; array.length > i; i++){
    console.log(array[i]);
}

var array = new Array(3,4,6,7,8,9,10,3,2,1,3,5,4,9,78,45,32,12,3,65);

for(var i = third_array.length-1; i>=0 ;i--) {
    console.log("Entramos en la iteración de " + array);
}



var i = array.length-1;
for(; i>=0; i--){
    console.log("Entramos en la iteración de " +array[i]);
}



array.forEach(function myFunction(item) {
  console.log(item); 
});



// date object
let today = new Date();
let firstOctober = new Date(2025, 9, 1);
console.log(today);
console.log(firstOctober);
console.log(today.getDate());

if(today>firstOctober) {
    console.log("Is after");
} else {
    console.log("Is before");
}

function myFirstFuntion() {
    console.log("Thank you for your click");
}

function mySecondFuntion() {
    console.log("Thank you for your interest");
}

function myThirdFuntion() {
    console.log("Pesado");
}

// Select DOM
var div = document.getElementById("my_div");
div.classList.add("my_class");
console.log(div);

var div2 = document.getElementsByTagName("div");
console.log(div2);

var div3 = document.querySelector("#my_second_div");
console.log(my_second_div);

console.log($("#my_third_div"));
console.log($("#my_third_div".classList));

console.log($(".pruebas"));

var numbers = [1,2,3,4];
var n_Elevator_2 = numbers.map(n => n*n);
console.log(n_Elevator_2);

*/

console.log($("#btn"));

$("#btn").addEventListener("click", function(){
    var input = document.createElement("input");
    console.log("input");
});

$("#btn").addEventListener("click", function(){
    var input = document.createElement("input");
    input.setAttribute("type", "email");
    input.setAttribute("placeholder", "E-email");
    input.setAttribute("name", "emails[]");
    $("#form").appendChild(input);
    myAlert("Add new email input");
});