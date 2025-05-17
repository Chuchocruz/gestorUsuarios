


// Call the dataTables jQuery plugin
$(document).ready(function() {    //Decir que se ejecute todo el codigo una vez que se alla cargado la pagina


    // cargarUsuarios();
    // $('#usuarios').DataTable();
  });
  
  
  async function iniciarSesion() {

    let datos = {};
   
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;


    const request = await fetch('api/login',{
  
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
  
  });
    const response = await request.json();
  

  }
  
 