document.addEventListener('DOMContentLoaded', function() {

        document.getElementById('Registrar').addEventListener('click', function(e) {
            var nombre = document.getElementById('Name').value;
            var nickname = document.getElementById('nickname').value;
            var apellido = document.getElementById('apellido').value;
            var emailRegistro = document.getElementById('mail').value;
            var contrasena = document.getElementById('pswd').value;
            var fechaNacimiento = document.getElementById('FechaNacimiento').value;
            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            var fechaPattern = /^\d{4}-\d{2}-\d{2}$/; // Define un patrón de fecha (AAAA-MM-DD)

            var isValid = true; // Variable para verificar si todos los campos son válidos

            // Verificar si el nombre está lleno
            if (nombre.trim() === '') {
                document.getElementById('error-nombre').textContent = 'Por favor, ingresa tu nombre';
                isValid = false;
            } else {
                document.getElementById('error-nombre').textContent = '';
            }
            // Verificar si el nickname está lleno
            if (nickname.trim() === '') {
                document.getElementById('error-nickname').textContent = 'Por favor, ingresa un nickname valido';
                isValid = false;
            } else {
                document.getElementById('error-nickname').textContent = '';
            }

            // Verificar si el apellido está lleno
            if (apellido.trim() === '') {
                document.getElementById('error-apellido').textContent = 'Por favor, ingresa un apellido valido';
                isValid = false;
            } else {
                document.getElementById('error-apellido').textContent = '';
            }

            // Verificar si el correo electrónico de registro es válido
            if (!emailRegistro.match(emailPattern)) {
                document.getElementById('error-email').textContent = 'Por favor, ingresa un correo electrónico válido';
                isValid = false;
            } else {
                document.getElementById('error-email').textContent = '';
            }

            // Verificar si la contraseña está lleno
            if (contrasena.trim() === '') {
                document.getElementById('error-contrasena').textContent = 'Por favor, ingresa una contraseña';
                isValid = false;
            } else {
                document.getElementById('error-contrasena').textContent = '';
            }

            // Verificar si la fecha cumple con el formato esperado
            if (!fechaNacimiento.match(fechaPattern)) {
                document.getElementById('error-fecha').textContent = 'Por favor, ingresa una fecha válida en el formato DD-MM-AAAA';
                isValid = false;
            } else {
                document.getElementById('error-fecha').textContent = '';
            }

            // Si no es válido, detener la ejecución
            if (!isValid) {
                e.preventDefault();
                return;
            }

            e.preventDefault(); // Evitar que el formulario se envíe automáticamente

            $.ajax({
                url: '/api/users/CrearUsuario',
                type: 'POST',
                data: {
                    'Name': nombre,
                    'nickname': nickname,
                    'pswd': contrasena,
                    'apellido': apellido,
                    'mail': emailRegistro,
                    'FechaNacimiento': fechaNacimiento
                },
                success: function(response) {
                    // Si la autenticación es exitosa, redirige al usuario a la API de películas
                    window.location.href = '/api/users/planSuscripcion';
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    // Si la autenticación falla, muestra el mensaje de error al usuario
                    if(jqXHR.status == 401) { // 401 es el código de estado para no autorizado
                        document.getElementById('error-usuario-registrado').textContent = 'El correo ya esta registrado';
                    } else {
                        document.getElementById('error-usuario-registrado').textContent = 'Error desconocido. Por favor, inténtelo de nuevo más tarde.';
                    }
                }
            });
        });




    document.getElementById('Acceder').addEventListener('click', function(e) {
        e.preventDefault(); // Evitar que el formulario se envíe automáticamente

        var emailAcceso = document.getElementById('mail-2').value;
        var contrasena = document.getElementById('pswd-2').value;
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        // Verificar si el correo electrónico de acceso es válido
        if (!emailAcceso.match(emailPattern)) {
            document.getElementById('error-email-acceso').textContent = 'Por favor, ingresa un correo electrónico válido';
            return; // Detener la ejecución si el correo electrónico no es válido
        } else {
            document.getElementById('error-email-acceso').textContent = '';
        }

        // Verificar si la contraseña está lleno
        if (contrasena.trim() === '') {
            document.getElementById('error-contrasena-acceso').textContent = 'Por favor, ingresa una contraseña';
            return; // Detener la ejecución si la contraseña está vacía
        } else {
            document.getElementById('error-contrasena-acceso').textContent = '';
        }




        // Realizar la solicitud AJAX al controlador de autenticación
        $.ajax({
            url: '/api/users/AccederUsuario',
            type: 'POST',
            data: { 'mail-2': emailAcceso, 'pswd-2': contrasena },
            success: function(response) {
                if (response === "Autenticación exitosa") {
                    // Si la autenticación es exitosa, redirigir al usuario a la API de películas
                    window.location.href = '/api/peliculas/';
                } else if (response === "Sin plan de suscripción, por favor selecciona uno.") {
                    // Si el usuario no tiene un plan de suscripción, redirigir a la página de actualización de plan
                    window.location.href = '/api/users/planSuscripcion';
                } else {
                    // Otro caso de respuesta (como error de autenticación)
                    document.getElementById('error-contrasena-acceso').textContent = response;
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                // Si la autenticación falla, muestra el mensaje de error al usuario
                var responseText = jqXHR.responseText;
                if(responseText === "Usuario o contraseña incorrectos") { // 401 es el código de estado para no autorizado
                    document.getElementById('error-contrasena-acceso').textContent = 'Usuario o contraseña incorrectos';
                } else if(responseText === "Usuario no encontrado"){
                    document.getElementById('error-contrasena-acceso').textContent = 'Por favor registrese.';
                } else{
                    document.getElementById('error-contrasena-acceso').textContent = 'Error desconocido. Por favor, inténtelo de nuevo más tarde.';
                }
            }
        });
    });

    document.getElementById('signIn').addEventListener('click', function() {
        document.getElementById('container').classList.remove('right-panel-active');
    });

    document.getElementById('signUp').addEventListener('click', function() {
        document.getElementById('container').classList.add('right-panel-active');
    });






});




