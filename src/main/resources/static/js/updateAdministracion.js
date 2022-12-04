/*function actualizarOdontologo(matricula){
    let url = '/actualizar';
    const settings = {
        method: 'PUT'
        headers: {
            'Content-Type': 'application/json'}
        body: JSON.stringify(data)
    }
    fetch(url,settings)
    .then(function(response){
        location.reload();
        return response.json();})
    .then(function(){
        console.log(matricula);
    })
}*/

function actualizarOdontologo(matricula){
    let registro = document.querySelector("#registroOdontologoKey" + matricula);
    let divFormulario = document.querySelector("#divOdontologoUpdate");
    let btnUpdate = document.querySelector("#btnUpdate");
    let organizador = [];
    for(let i = 0; i < registro.cells.length - 2; i++){
        divFormulario.childNodes[1][i].value = registro.cells[i].textContent;
    }
    divFormulario.style.display = "block";
    divFormulario.childNodes[1][0].value = matricula;
    btnUpdate.addEventListener("click",function(e){
        let role = "x";
        e.preventDefault();
        for(let i = 0; i < divFormulario.childNodes[1].length-1; i++){
            organizador.push(divFormulario.childNodes[1][i].value);
        }
        console.log(organizador);
        fetch("/odontologo/"+matricula)
        .then(function(response){
            console.log(response);
            return response.json();})
        .then(function(data){
            role = data.ROLE;
        })
        console.log(role);
        let data = "";
    })


/*
    fetch("/odontologo/"+matricula)
    .then(function(response){
        console.log(response);
        return response.json();})
    .then(function(data){
        console.log(data);
    })

*/

}