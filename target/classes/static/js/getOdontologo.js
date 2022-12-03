window.onload = function(){
fetch("/odontologo")
.then(function(response){
    return response.json();})
.then(function(data){
    let tablaOdontologos = document.querySelector("#BodyTablaOdontologos");
    console.log(tablaOdontologos);
        for(let i = 0; i < data.length; i++){
        console.log("YO!" + i);
        }
}
)
}