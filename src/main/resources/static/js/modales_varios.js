// Editar
$('a.btn-primary').click(function () {
    const form      = document.querySelector('#editObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject     = form.querySelector('input[id="idObjectE"]');
    const nombre       = form.querySelector('input[id="nombre"]');
    const cantidad     = form.querySelector('input[id="cantidad"]');
    const categoria    = form.querySelector('input[id="categoria"]');
    const descripcion  = form.querySelector('#descripcion');
    
    // Acceder a las celdas específicas por índice
    const celdaNombre              = fila.cells[0];
    const celdaCantidad            = fila.cells[1];
    const celdaCategoria           = fila.cells[2];
    const celdaDescripcion= fila.cells[3];



    // Obtener los valores de las celdas
    const valorNombre       = celdaNombre.textContent;
    const valorCantidad     = celdaCantidad.textContent;
    const valorCategoria    = celdaCategoria.textContent;
    const valorDescripcion  = celdaDescripcion.textContent;


    // ID del objeto a editar
    idObject.value = filaId;
    
    nombre.value       = valorNombre;
    cantidad.value     = valorCantidad;
    categoria.value    = valorCategoria;
    descripcion.value  = valorDescripcion;
});

// Eliminar
$('a.btn-danger').click(function () {
    const form      = document.querySelector('#deleteObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject  = form.querySelector('input[id="idObjectD"]');

    // Acceder a las celdas específicas por índice
    const celdaNombre     = fila.cells[0];
    const celdaCategoria  = fila.cells[2];

    // Obtener los valores de las celdas
    const valorNombre     = celdaNombre.textContent;
    const valorCategoria  = celdaCategoria.textContent;

    // ID del objeto a eliminar
    idObject.value = filaId;
    form.querySelector('#nombreObjetoD').textContent = (valorNombre + ' - ' + valorCategoria);
});


// Detalles
$('a.btn-info').click(function () {
    const modal  = document.querySelector('#detailsObjectModal');
    const filaId = $(this).closest('tr').data('id');
    const fila   = document.querySelector(`tr[data-id="${filaId}"]`);

    const nombre     = modal.querySelector('p[id="nombre"]');
    const cantidad   = modal.querySelector('p[id="cantidad"]');
    const categoria  = modal.querySelector('p[id="categoria"]');
    const fechaR     = modal.querySelector('p[id="fechaR"]');
    const descripcion= modal.querySelector('textarea[id="descripcion"]');
    const fechaE     = modal.querySelector('p[id="fechaE"]');
    
    // Acceder a las celdas específicas por índice
    const celdaNombre              = fila.cells[0];
    const celdaCantidad            = fila.cells[1];
    const celdaCategoria           = fila.cells[2];
    const celdaFechaR     = fila.querySelector('td.d-none.R');
    const celdaDescripcion         = fila.cells[3];
    const celdaFechaE     = fila.querySelector('td.d-none.E');
    
    // Obtener los valores de las celdas
    const valorNombre        = celdaNombre.textContent;
    const valorCantidad      = celdaCantidad.textContent;
    const valorCategoria     = celdaCategoria.textContent;
    const valorFechaR = celdaFechaR.textContent;
    const valorDescripcion   = celdaDescripcion.textContent;
    const valorFechaE = celdaFechaE.textContent;

    nombre.textContent    = valorNombre;
    cantidad.textContent  = valorCantidad;
    categoria.textContent = valorCategoria;
    fechaR.textContent    = valorFechaR;
    descripcion.value     = valorDescripcion;
    fechaE.textContent    = valorFechaE;
});