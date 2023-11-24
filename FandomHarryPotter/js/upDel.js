
export const editarComentario = async (id, nuevoTexto) => {
    try {
        const res = await fetch(`http://localhost:8080/api/comments/${id}`, {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ comment: nuevoTexto })
        });
        const dataJson = await res.json();
        console.log('Comentario actualizado:', dataJson);
        return dataJson;
    } catch (error) {
        console.error('Error al actualizar comentario:', error);
    }
}

export const eliminarComentario = async (id) => {
    try {
        const res = await fetch(`http://localhost:8080/api/comments/${id}`, {
            method: "DELETE",
        });
        console.log('Comentario eliminado:', id);
        return res.ok;
    } catch (error) {
        console.error('Error al eliminar comentario:', error);
    }
}
