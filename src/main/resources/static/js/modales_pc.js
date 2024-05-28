// Editar
$('a.btn-primary').click(function () {
    const form      = document.querySelector('#editObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject  = form.querySelector('input[id="idObjectE"]');
    const numero    = form.querySelector('input[id="numeroE"]');
    const modelo    = form.querySelector('input[id="modeloE"]');
    const marca     = form.querySelector('input[id="marcaE"]');
    const notas     = form.querySelector('#notasE');
    
    // Acceder a las celdas específicas por índice
    const celdaNumero  = fila.cells[0];
    const celdaModelo  = fila.cells[1];
    const celdaMarca   = fila.cells[2];
    const celdaNotas= fila.querySelector('td.d-none.N');



    // Obtener los valores de las celdas
    const valorNumero   = celdaNumero.textContent;
    const valorModelo   = celdaModelo.textContent;
    const valorMarca    = celdaMarca.textContent;
    const valorNotas = celdaNotas.textContent;


    // ID del objeto a editar
    idObject.value = filaId;
    
    numero.value   = valorNumero;
    modelo.value   = valorModelo;
    marca.value    = valorMarca;
    notas.value    = valorNotas;
});

// Eliminar
$('a.btn-danger').click(function () {
    const form      = document.querySelector('#deleteObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject  = form.querySelector('input[id="idObjectD"]');

    // Acceder a las celdas específicas por índice
    const celdaNumero   = fila.cells[0];
    const celdaModelo   = fila.cells[1];
    // Obtener los valores de las celdas
    const valorNumero  = celdaNumero.textContent;
    const valorModelo  = celdaModelo.textContent;

    // ID del objeto a eliminar
    idObject.value = filaId;
    form.querySelector('#nombreObjetoD').textContent = (valorNumero + ' ' + valorModelo);
});


// Detalles
$('a.btn-info').click(function () {
    const modal  = document.querySelector('#detailsObjectModal');
    const filaId = $(this).closest('tr').data('id');
    const fila   = document.querySelector(`tr[data-id="${filaId}"]`);

    const numero = modal.querySelector('p[id="numero"]');
    const modelo = modal.querySelector('p[id="modelo"]');
    const marca  = modal.querySelector('p[id="marca"]');
    const fechaR = modal.querySelector('p[id="fechaR"]');
    const notas  = modal.querySelector('textarea[id="notas"]');
    const fechaE = modal.querySelector('p[id="fechaE"]');
    
    // Acceder a las celdas específicas por índice
    const celdaNumero         = fila.cells[0];
    const celdaModelo         = fila.cells[1];
    const celdaMarca          = fila.cells[2];
    const celdaFechaR= fila.querySelector('td.d-none.R');
    const celdaNotas = fila.querySelector('td.d-none.N');
    const celdaFechaE= fila.querySelector('td.d-none.E');
    
    // Obtener los valores de las celdas
    const valorNumero        = celdaNumero.textContent;
    const valorModelo        = celdaModelo.textContent;
    const valorMarca         = celdaMarca.textContent;
    const valorFechaR = celdaFechaR.textContent;
    const valorNotas  = celdaNotas.textContent;
    const valorFechaE = celdaFechaE.textContent;

    numero.textContent  = valorNumero;
    modelo.textContent  = valorModelo;
    marca.textContent   = valorMarca;
    fechaR.textContent  = valorFechaR;
    notas.value         = valorNotas;
    fechaE.textContent  = valorFechaE;
});