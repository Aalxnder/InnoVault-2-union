// Editar
$('a.btn-primary').click(function () {
    const form      = document.querySelector('#editObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject     = form.querySelector('input[id="idObjectE"]');
    const nombre       = form.querySelector('input[id="nombre"]');
    const codigo       = form.querySelector('input[id="codigo"]');
    const correo       = form.querySelector('input[id="correo"]')
    const permisos     = form.querySelector('select[id="permisos"]');

    // Acceder a las celdas específicas por índice
    const celdaNombre           = fila.cells[0];
    const celdaCodigo           = fila.cells[1];
    const celdaCorreo           = fila.cells[2]
    const celdaPermisos         = fila.cells[3];



    // Obtener los valores de las celdas
    const valorNombre    = celdaNombre.textContent;
    const valorCodigo    = celdaCodigo.textContent;
    const valorCorreo    = celdaCorreo.textContent;
    const valorPermisos  = celdaPermisos.textContent;


    // ID del objeto a editar
    idObject.value = filaId;
    
    nombre.value       = valorNombre;
    codigo.value       = valorCodigo;
    correo.value       = valorCorreo;
    permisos.value     = valorPermisos;
});

// Eliminar
$('a.btn-danger').click(function () {
    const form      = document.querySelector('#deleteObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject  = form.querySelector('input[id="idObjectD"]');

    // Acceder a las celdas específicas por índice
    const celdaNombre     = fila.cells[0];
    const celdaCodigo  = fila.cells[1];

    // Obtener los valores de las celdas
    const valorNombre     = celdaNombre.textContent;
    const valorCodigo     = celdaCodigo.textContent;

    // ID del objeto a eliminar
    idObject.value = filaId;
    form.querySelector('#nombreObjetoD').textContent = (valorNombre + ' - ' + valorCodigo);
});


// Detalles
$('a.btn-info').click(function () {
    const modal  = document.querySelector('#detailsObjectModal');
    const filaId          = $(this).closest('tr').data('id');
    const fila   = document.querySelector(`tr[data-id="${filaId}"]`);

    const nombre  = modal.querySelector('p[id="nombre"]');
    const codigo  = modal.querySelector('p[id="codigo"]');
    const correo  = modal.querySelector('p[id="correo"]');
    const telefono= modal.querySelector('p[id="telefono"]')
    const permisos= modal.querySelector('p[id="permisos"]');
    const fechaR  = modal.querySelector('p[id="fechaR"]');

    // Acceder a las celdas específicas por índice
    const celdaNombre           = fila.cells[0];
    const celdaCodigo           = fila.cells[1];
    const celdaCorreo           = fila.cells[2];
    const celdaPermisos         = fila.cells[3];
    const celdaTelefono         = fila.cells[4];
    const celdaFechaR  = fila.querySelector('td.d-none.R');
    
    // Obtener los valores de las celdas
    const valorNombre        = celdaNombre.textContent;
    const valorCodigo        = celdaCodigo.textContent;
    const valorCorreo        = celdaCorreo.textContent;
    const valorPermisos      = celdaPermisos.textContent;
    const valorTelefono      = celdaTelefono.textContent;
    const valorFechaR = celdaFechaR.textContent;

    nombre.textContent    = valorNombre;
    codigo.textContent    = valorCodigo;
    correo.textContent    = valorCorreo;
    permisos.textContent  = valorPermisos;
    telefono.textContent  = valorTelefono;
    fechaR.textContent    = valorFechaR;
});