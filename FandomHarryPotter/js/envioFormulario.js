document.getElementById('formPublicacion').addEventListener('submit', function (event) {
    event.preventDefault();

    var comment = {
        house: document.getElementById('selectCasa').value,
        username: document.getElementById('inputNombreUsuario').value,
        category: document.getElementById('selectCategoria').value,
        categoryOption: document.getElementById('selectDependiente').value,
        comment: document.getElementById('textareaComentario').value
    };

    fetch('http://localhost:8080/api/comments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(comment),
    })
        .then(response => {
            window.location.reload()
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});
