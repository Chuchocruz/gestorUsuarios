


// Call the dataTables jQuery plugin
$(document).ready(function() {    //Decir que se ejecute todo el codigo una vez que se alla cargado la pagina


    // cargarUsuarios();
    // $('#usuarios').DataTable();
  });
  
  
  async function registrarUsuario() {
  
    const request = await fetch('api/usuarios',{
  
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
  
  });
    // const usuarios = await request.json();
  
    let listadoHtml = '';
  
    
  
    
    
    
    
  
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
  
    
  }
  
 