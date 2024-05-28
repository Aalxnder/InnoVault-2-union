
$('a.btn-info').click(function () {
    const modal  = document.querySelector('#detailsObjectModal');
    const filaId          = $(this).closest('tr').data('id');
    const fila   = document.querySelector(`tr[data-id="${filaId}"]`);

    const nombre  = modal.querySelector('p[id="nombreMisObjetoDs"]');
    const tipo  = modal.querySelector('p[id="TipoMisFilamentoDs"]');
    const cantidad  = modal.querySelector('p[id="CantidadMisFilamentoDs"]');
    const color = modal.querySelector('p[id="ColorMisFilamentoDs"]')
    const fechaRs= modal.querySelector('p[id="fechaMisRs"]');
    const notas = modal.querySelector('textarea[id="notasMisDs"]');
    const fechaDs  = modal.querySelector('p[id="fechaMisDs"]');

    // Acceder a las celdas específicas por índice
    const celdaNombre           = fila.cells[0];
    const celdaTipo           = fila.cells[1];
    const celdaCantidad           = fila.cells[2];
    const celdaColor         = fila.cells[3];
    const celdaNotas          = fila.cells[4];
    const celdaFechaRs= fila.querySelector('td.d-none.R');
    const celdaFechaDs  = fila.querySelector('td.d-none.E');

    // Obtener los valores de las celdas
    const valorNombre        = celdaNombre.textContent;
    const valorTipo      = celdaTipo.textContent;
    const valorCantidad     = celdaCantidad.textContent;
    const valorColor = celdaColor.textContent;
    const valorFechaRs   = celdaFechaRs.textContent;
    const valorNotas     = celdaNotas.textContent;
    const valorFechaDs = celdaFechaDs.textContent;

    nombre.textContent    = valorNombre;
    tipo.textContent  = valorTipo;
    cantidad.textContent = valorCantidad;
    color.textContent    = valorColor;
    fechaRs.textContent     = valorFechaRs;
    notas.value     = valorNotas;
    fechaDs.textContent    = valorFechaDs;
});