


// Call the dataTables jQuery plugin
$(document).ready(function() {    //Decir que se ejecute todo el codigo una vez que se alla cargado la pagina


    // cargarUsuarios();
    // $('#usuarios').DataTable();
  });
  
  
  async function registrarUsuario() {

    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;


    let repPass = document.getElementById('txtRepetirpass').value;

    if (repPass != datos.password) {
        alert('La contraseña es diferente¡¡¡¡¡');

        return
        
    }
  
    const request = await fetch('api/usuarios',{
  
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
  
  });
    alert("La cuenta fue creada con exito"); 
  window.location.href = 'login.html'

  

  }
  
 