window.onload = function(){
fetch("/odontologo")
.then(function(response){
    return response.json();})
.then(function(data){
    let tablaOdontologos = document.querySelector("#BodyTablaOdontologos");
    //let tablaPacientes = document.querySelector("#");
    for(let i = 0; i < data.length; i++){
        console.log(data[i]);
        console.log(data[i].apellido);
        tablaOdontologos.innerHTML +=
        "<tr id=\"registroOdontologoKey" + data[i].matricula + "\">" +
            "<th>" + data[i].matricula + "</th>" +
            "<th>" + data[i].user + "</th>" +
            "<th>" + data[i].password + "</th>" +
            "<th>" + data[i].nombre + "</th>" +
            "<th>" + data[i].apellido + "</th>" +
            "<th><input type=\"button\" class=\"btn btn-primary\" id = \"btnAgregar\" value=\"✏\"></input></th>" +
            "<th><input type=\"button\" class=\"btn btn-danger\" id = \"btnEliminar\" value=\"❌\"></input></th>" +
        "</tr>";
    }
})

fetch("/paciente")
.then(function(response){
    return response.json();})
.then(function(data){
    let tablaPacientes = document.querySelector("#BodyTablaPacientes");
    for(let i = 0; i < data.length; i++){
        console.log(data[i]);
        console.log(data[i].apellido);
        tablaPacientes.innerHTML +=
        "<tr id=\"registroPacienteKey" + data[i].DNI + "\">" +
            "<th>" + data[i].DNI + "</th>" +
            "<th>" + data[i].user + "</th>" +
            "<th>" + data[i].password + "</th>" +
            "<th>" + data[i].nombre + "</th>" +
            "<th>" + data[i].apellido + "</th>" +
            "<th>" + data[i].domicilio + "</th>" +
            "<th>" + data[i].fechaAlta + "</th>" +
            "<th><input type=\"button\" class=\"btn btn-primary\" id = \"btnAgregar\" value=\"✏\"></input></th>" +
            "<th><input type=\"button\" class=\"btn btn-danger\" id = \"btnEliminar\" value=\"❌\"></input></th>" +
        "</tr>";
    }
})
}