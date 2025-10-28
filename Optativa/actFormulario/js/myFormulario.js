document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("registroForm");
    
    // Identifica todos los campos a validar y controlar su visibilidad
    const campos = Array.from(form.querySelectorAll(".data, select, #condiciones"));
    let currentStep = 0;

    // --- Funciones auxiliares de manejo de errores ---
    const showError = (campo, mensaje) => {
        const span = campo.nextElementSibling;
        if (span) {
            span.textContent = mensaje;
            span.style.display = "block"; // Se muestra el mensaje
        }
    };

    const clearError = (campo) => {
        const span = campo.nextElementSibling;
        if (span) {
            span.textContent = "";
            span.style.display = "none"; // Se oculta el span completamente
        }
    };
    // --------------------------------------------------------------------------------------------------

    // Inicialización: Oculta todo excepto el primer campo y crea los spans de error
    campos.forEach((campo, index) => {
        campo.style.display = index === 0 ? "block" : "none";

        let errorSpan = campo.nextElementSibling;
        if (!errorSpan || !errorSpan.classList.contains('error-msg')) {
            errorSpan = document.createElement('span');
            errorSpan.classList.add('error-msg');
            campo.insertAdjacentElement('afterend', errorSpan);
        }
        // Clave: Ocultar el span de error al inicio
        errorSpan.style.display = "none";
    });

    // --- REGISTRO DE VALIDACIONES ESTRICTAS ---
    const validators = {
        nombre: (v) => /^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$/.test(v),
        apellido: (v) => /^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$/.test(v),
        correo: (v) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v),
        telefono: (v) => /^[0-9]{9}$/.test(v),
        dni: (v) => /^[0-9]{8}[A-Za-z]$/.test(v),
        // Contraseña: Mínimo 6 caracteres
        password: (v) => v.length >= 6, 
        password2: (v) => v === form.password.value,
        genero: (v) => v !== "",
        fecha: (v) => v !== "",
        condiciones: (checked) => checked,
        // Campos de socio (se mantienen aunque no se usen en este flujo simple)
        socio: (v) => v !== "",
        tipoSocio: (v) => v !== "",
        nick: (v) => v.length >= 3 && /^[A-Za-z0-9_]+$/.test(v),
        numSocio: (v) => /^[0-9]{5,10}$/.test(v)
    };

    const errorMessages = {
        nombre: "El nombre solo puede contener letras y espacios.",
        apellido: "El apellido solo puede contener letras y espacios.",
        correo: "Introduce un correo electrónico válido.",
        telefono: "El teléfono debe tener exactamente 9 números.",
        dni: "El DNI debe tener 8 números y una letra al final.",
        password: "La contraseña debe tener al menos 6 caracteres.",
        password2: "Las contraseñas no coinciden.",
        genero: "Selecciona tu género.",
        fecha: "Introduce una fecha válida.",
        condiciones: "Acepta los términos y condiciones.",
        socio: "Selecciona si deseas ser socio.",
        tipoSocio: "Selecciona tipo de socio.",
        nick: "El Nick debe tener al menos 3 caracteres y solo puede contener letras, números y guiones bajos.",
        numSocio: "El Número de Socio debe contener entre 5 y 10 dígitos."
    };
    // ----------------------------------------------------------------------------------

    // Función auxiliar para avanzar a un campo por su nombre y actualizar currentStep
    const avanzarACampo = (name) => {
        const campo = campos.find(c => c.name === name || c.id === name);
        if (campo) {
            campo.style.display = "block";
            campo.focus();
            currentStep = campos.indexOf(campo);
            return true;
        }
        return false;
    };


    const confirmarBtn = document.querySelector(".confirmar"); 
    
    confirmarBtn.addEventListener("click", (e) => {
        e.preventDefault();
        
        const campo = campos[currentStep];
        const name = campo.name || campo.id;
        const value = campo.type === "checkbox" ? campo.checked : campo.value ? campo.value.trim() : "";

        // 1. VALIDACIÓN DEL CAMPO ACTUAL
        if (!validators[name] || !validators[name](value)) {
            showError(campo, errorMessages[name] || "Campo inválido.");
            campo.focus();
            return;
        } else {
            clearError(campo);
        }

        // 2. LÓGICA DE AVANCE (Secuencial Simple)
        
        // Si no es el último campo (condiciones)
        if (currentStep < campos.length - 1) {
            
            // Si el campo actual es "fecha", "socio", "tipoSocio", etc., y tiene lógica condicional
            // para saltar, debes añadir la lógica de salto aquí.
            // Para el flujo simple solicitado, asumimos avance directo:
            
            campos[currentStep + 1].style.display = "block";
            campos[currentStep + 1].focus();
            currentStep++;
            
        } else {
            // Si es el último campo (condiciones) y es válido (validación pasó arriba)
            alert("¡Todos los campos son válidos! Formulario enviado.");
            form.submit();
        }
    });

    // BONUS: Listener para el botón Cancelar
    const cancelarBtn = document.querySelector(".cancelar");
    if (cancelarBtn) {
        cancelarBtn.addEventListener("click", (e) => {
            e.preventDefault();
            form.reset();
            currentStep = 0;
            campos.forEach((c, i) => {
                c.style.display = i === 0 ? "block" : "none";
                clearError(c);
            });
        });
    }
});