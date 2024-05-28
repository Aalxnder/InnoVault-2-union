// Editar
$('a.btn-primary').click(function () {
    const form      = document.querySelector('#editObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject          = form.querySelector('input[id="idObjectE"]');
    const nombreObjeto      = form.querySelector('input[id="nombreObjetoE"]');
    const TipoFilamento     = form.querySelector('input[id="TipoFilamentoE"]');
    const CantidadFilamento = form.querySelector('input[id="CantidadFilamentoE"]');
    const ColorFilamento    = form.querySelector('input[id="ColorFilamentoE"]');
    const notas             = form.querySelector('#notasE');
    
    // Acceder a las celdas específicas por índice
    const celdaNombre   = fila.cells[1];
    const celdaTipo     = fila.cells[2]; 
    const celdaCantidad = fila.cells[3]; 
    const celdaColor    = fila.cells[4]; 
    const celdaNotas    = fila.cells[5]; 
    
    // Obtener los valores de las celdas
    const valorNombre    = celdaNombre.textContent;
    const valorTipo      = celdaTipo.textContent;
    const valorCantidad  =  parseFloat(celdaCantidad.textContent);
    const valorColor     = celdaColor.textContent;
    const valorNotas     = celdaNotas.textContent;
    
    // ID del objeto a editar
    idObject.value = filaId;
    
    nombreObjeto.value      = valorNombre;
    TipoFilamento.value     = valorTipo;    
    CantidadFilamento.value = valorCantidad;
    ColorFilamento.value    = valorColor;   
    notas.value             = valorNotas;  
});

// Eliminar
$('a.btn-danger').click(function () {
    const form      = document.querySelector('#deleteObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject  = form.querySelector('input[id="idObjectD"]');

    // Acceder a las celdas específicas por índice
    const celdaNombre   = fila.cells[1];
    const celdaColor    = fila.cells[4];
    // Obtener los valores de las celdas
    const valorNombre   = celdaNombre.textContent;
    const valorColor    = celdaColor.textContent;

    // ID del objeto a eliminar
    idObject.value = filaId;
    form.querySelector('#nombreObjetoD').textContent = (valorNombre + ' ' + valorColor);
});


// Detalles
$('a.btn-info').click(function () {
    const modal  = document.querySelector('#detailsObjectModal');
    const filaId = $(this).closest('tr').data('id');
    const fila   = document.querySelector(`tr[data-id="${filaId}"]`);

    const nombreObjeto       = modal.querySelector('p[id="nombreObjetoDs"]');
    const TipoFilamento      = modal.querySelector('p[id="TipoFilamentoDs"]');
    const CantidadFilamento  = modal.querySelector('p[id="CantidadFilamentoDs"]');
    const ColorFilamento     = modal.querySelector('p[id="ColorFilamentoDs"]');
    const notas              = modal.querySelector('textarea[id="notasDs"]');
    const fechaEdicion       = modal.querySelector('p[id="fechaDs"]');
    
    // Acceder a las celdas específicas por índice
    const celdaNombre        = fila.cells[1];
    const celdaTipo          = fila.cells[2];
    const celdaCantidad      = fila.cells[3];
    const celdaColor         = fila.cells[4];
    const celdaNotas         = fila.cells[5];
    const celdaFechaEdicion  = fila.querySelector('td.d-none');
    
    // Obtener los valores de las celdas
    const valorNombre       = celdaNombre.textContent;
    const valorTipo         = celdaTipo.textContent;
    const valorCantidad     = celdaCantidad.textContent;
    const valorColor        = celdaColor.textContent;
    const valorNotas        = celdaNotas.textContent;
    const valorFechaEdicion = celdaFechaEdicion.textContent;

    nombreObjeto.textContent        = valorNombre;
    TipoFilamento.textContent       = valorTipo;
    CantidadFilamento.textContent   = valorCantidad;
    ColorFilamento.textContent      = valorColor;
    notas.value                     = valorNotas;
    fechaEdicion.textContent        = valorFechaEdicion;
});