// 1. Función para Crear Planta
document.getElementById('formPlanta').addEventListener('submit', async (e) => {
    e.preventDefault(); // Evita que la página se recargue sola

    const planta = {
            nombre: document.getElementById('nombre').value,
            precio: parseFloat(document.getElementById('precio').value),
            stock: parseInt(document.getElementById('stock').value),
            codigoSKU: document.getElementById('codigoSKU').value,

            minStock: 5,           // El valor mínimo que definiste en el DTO (@Min(5))
                    tipoProducto: "PLANTA", // Obligatorio en la entidad Producto
                    descripcion: "Sin descripción", // Evita posibles nulos si la DB los pide
                    activo: true
        };

    const response = await fetch('/api/plantas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(planta)
    });

    if (response.ok) {
        alert("¡Planta creada con éxito!");
        location.reload(); // Recarga para ver la nueva planta
    } else {
        // Esto te dirá EXACTAMENTE qué campo está fallando según Spring
        const errorMsg = await response.text();
        console.error("Error del servidor:", errorMsg);
        alert("Error al guardar: revisa la consola de Spring");
    }
});

// 2. Función para Activar/Desactivar
async function cambiarEstado(id, estaActivo) {
    const accion = estaActivo ? 'desactivar' : 'activar';
    const response = await fetch(`/api/plantas/${id}/${accion}`, {
        method: 'PATCH'
    });

    if (response.ok) {
        location.reload();
    } else {
        alert("No se pudo cambiar el estado");
    }
}