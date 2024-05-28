// Editar
$('a.btn-primary').click(function () {
    const form      = document.querySelector('#editObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject     = form.querySelector('input[id="idObjectE"]');
    const numero       = form.querySelector('input[id="numImpresora"]');
    const tipo         = form.querySelector('select[id="tipo"]');
    const marca        = form.querySelector('input[id="marca"]');
    const estatus      = form.querySelector('select[id="estatus"]');
    //const notas        = form.querySelector('textarea[id="notas"]');


    // Acceder a las celdas específicas por índice
    const celdaNumero        = fila.cells[0];
    const celdaTipo          = fila.cells[1];
    const celdaMarca         = fila.cells[2];
    const celdaEstatus       = fila.cells[3];
    //const celdaNotas         = fila.cells[4];


    // Obtener los valores de las celdas
    const valorNumero   = celdaNumero.textContent;
    const valorTipo     = celdaTipo.textContent;
    const valorMarca    = celdaMarca.textContent;
    const valorEstatus  = celdaEstatus.textContent;


    // ID del objeto a editar
    idObject.value = filaId;
    
    numero.value   = valorNumero;

    marca.value    = valorMarca;

    for (let option of estatus.options) {
        if (option.value === valorEstatus) {
            option.selected = true;
            break;
        }
    }
    for (let option of tipo.options) {
        if (option.value === valorTipo) {
            option.selected = true;
            break;
        }
    }
});

// Eliminar
$('a.btn-danger').click(function () {
    const form      = document.querySelector('#deleteObject');
    const filaId    = $(this).closest('tr').data('id');
    const fila      = document.querySelector(`tr[data-id="${filaId}"]`);

    const idObject  = form.querySelector('input[id="idObjectD"]');

    // Acceder a las celdas específicas por índice
    const celdaNumero     = fila.cells[0];
    const celdaTipo       = fila.cells[1];

    // Obtener los valores de las celdas
    const valorNumero  = celdaNumero.textContent;
    const valorTipo    = celdaTipo.textContent;

    // ID del objeto a eliminar
    idObject.value = filaId;
    form.querySelector('#nombreObjetoD').textContent = (valorNumero + ' - ' + valorTipo);
});


// Detalles
$('a.btn-info').click(function () {
    const modal  = document.querySelector('#detailsObjectModal');
    const filaId = $(this).closest('tr').data('id');
    const fila   = document.querySelector(`tr[data-id="${filaId}"]`);

    const numero  = modal.querySelector('p[id="numImpresora"]');
    const tipo    = modal.querySelector('p[id="tipo"]');
    const marca   = modal.querySelector('p[id="marca"]');
    const estatus = modal.querySelector('p[id="estatus"]');
    const fechaR  = modal.querySelector('p[id="fechaR"]');
    const fechaM  = modal.querySelector('p[id="fechaM"]');
    
    // Acceder a las celdas específicas por índice
    const celdaNumero         = fila.cells[0];
    const celdaTipo           = fila.cells[1];
    const celdaMarca          = fila.cells[2];
    const celdaEstatus        = fila.cells[3];
    const celdaFechaM         = fila.cells[4];
    const celdaFechaR= fila.querySelector('td.d-none');

    // Obtener los valores de las celdas
    const valorNumero        = celdaNumero.textContent;
    const valorTipo          = celdaTipo.textContent;
    const valorMarca         = celdaMarca.textContent;
    const valorEstatus       = celdaEstatus.textContent;
    const valorFechaM        = celdaFechaM.textContent;
    const valorFechaR = celdaFechaR.textContent;

    numero.textContent  = valorNumero;
    tipo.textContent    = valorTipo;
    marca.textContent   = valorMarca;
    estatus.textContent = valorEstatus;
    fechaM.value        = valorFechaM;
    fechaR.textContent  = valorFechaR;
});