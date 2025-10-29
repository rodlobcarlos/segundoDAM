document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("registroForm");
    
    const campos = Array.from(form.querySelectorAll(".data, select, #condiciones"));
    let currentStep = 0;

    const showError = (campo, mensaje) => {
        const span = campo.nextElementSibling;
        if (span) {
            span.textContent = mensaje;
            span.style.display = "block"; 
        }
    };

    const clearError = (campo) => {
        const span = campo.nextElementSibling;
        if (span) {
            span.textContent = "";
            span.style.display = "none"; 
        }
    };

    campos.forEach((campo, index) => {
        campo.style.display = index === 0 ? "block" : "none";

        let errorSpan = campo.nextElementSibling;
        if (!errorSpan || !errorSpan.classList.contains('error-msg')) {
            errorSpan = document.createElement('span');
            errorSpan.classList.add('error-msg');
            campo.insertAdjacentElement('afterend', errorSpan);
        }
        errorSpan.style.display = "none";
    });

    const validators = {
        nombre: (v) => /^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$/.test(v),
        apellido: (v) => /^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$/.test(v),
        correo: (v) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v),
        telefono: (v) => /^[0-9]{9}$/.test(v),
        dni: (v) => /^[0-9]{8}[A-Za-z]$/.test(v),

        password: (v) => v.length >= 6, 
        password2: (v) => v === form.password.value,
        genero: (v) => v !== "",
        fecha: (v) => v !== "",
        condiciones: (checked) => checked,
        
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

        if (!validators[name] || !validators[name](value)) {
            showError(campo, errorMessages[name] || "Campo inválido.");
            campo.focus();
            return;
        } else {
            clearError(campo);
        }

            if (currentStep < campos.length - 1) {
            
            
            campos[currentStep + 1].style.display = "block";
            campos[currentStep + 1].focus();
            currentStep++;
            
        } else {
            alert("¡Todos los campos son válidos! Formulario enviado.");
            form.submit();
        }
    });

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