document.getElementById('selectCategoria').addEventListener('change', function () {
    var categoria = this.value;
    var selectDependiente = document.getElementById('selectDependiente');
    var container = document.getElementById('selectDependienteContainer');

    // Limpiar las opciones anteriores
    selectDependiente.innerHTML = '';

    if (categoria) {
        container.style.display = 'block'; // Muestra el segundo combobox
        if (categoria === 'Libros') {
            const libros = [
                'Harry Potter y la piedra filosofal',
                'Harry Potter y la cámara secreta',
                'Harry Potter y el prisionero de Azkaban',
                'Harry Potter y el cáliz de fuego',
                'Harry Potter y la orden de fénix',
                'Harry Potter y el misterio del príncipe',
                'Harry Potter y las reliquias de la muerte',
            ];
            libros.forEach(libro => {
                const option = document.createElement('option');
                option.value = libro;
                option.textContent = libro;
                selectDependiente.appendChild(option);
            });
        } else if (categoria === 'Personajes') {
            const personajes = [
                'Harry Potter',
                'Hermione Granger',
                'Ron Weasley',
                'Draco Malfoy',
                'Luna Lovegood',
                'Albus Dumbledore',
                'Minerva McGonagall',
                'Yini weasley',
                'Severus Snape',
            ];
            personajes.forEach(personaje => {
                const option = document.createElement('option');
                option.value = personaje;
                option.textContent = personaje;
                selectDependiente.appendChild(option);
            });
        } else if (categoria === 'Hechizos') {
            const hechizos = [
                'accio',
                'Alohomora',
                'Animagus',
                'Avada Kedavra',
                'crucio',
                'Desilusion',
                'Engorgio',
                'epelliarmus',
                'Episkey',
                'Ferula',
                'imperio',
                'levicorpus',
                'lumus',
                'protego',
                'Rennervate',
                'sectumsempra',
                'Wingardium Leviosa'

            ];
            hechizos.forEach(hechizo => {
                const option = document.createElement('option');
                option.value = hechizo;
                option.textContent = hechizo;
                selectDependiente.appendChild(option);
            });
        }
    } else {
        container.style.display = 'none'; // Ocultar el segundo combobox si no hay categoría seleccionada
    }
});