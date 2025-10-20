 document.addEventListener("DOMContentLoaded", () => { const form = document.getElementById("registroForm");

  form.addEventListener("submit", (e) => { e.preventDefault(); // Evita que se recargue la página

    const nombre = document.querySelector("[name='nombre']").value.trim();
    const apellido = document.querySelector("[name='apellido']").value.trim();
    const correo = document.querySelector("[name='correo']").value.trim();
    const telefono = document.querySelector("[name='telefono']").value.trim();
    const fecha = document.querySelector("[name='fecha']").value;
    const dni = document.querySelector("[name='dni']").value.trim();
    const password = form.password.value.trim();
    const password2 = form.password2.value.trim();
    const genero = document.querySelector("[name='genero']").value;
    const condiciones = form.condiciones.checked;

    // Validaciones
    if (!nombre || !apellido || !correo || !telefono || !fecha || !dni || !password || !password2 || !genero) {
      alert("Complete todos los campos para continuar.");
      return;
    }

    const emailRegex = /^[a-zA-Z]+@[a-zA-Z]+\.(com|es|org)$/;
    if (!emailRegex.test(correo)) {
      alert("Introduzca un correo válido, este no es valido.");
      return;
    }

    if (password.length < 6) {
      alert("La contraseña debe tener al menos 6 caracteres.");
      return;
    }

    if (password !== password2) {
      alert("Las contraseñas no coinciden.");
      return;
    }

    if (!condiciones) {
      alert("Debe aceptar las condiciones y términos antes de continuar.");
      return;
    }

    alert("Formulario enviado.");
    form.submit();
  });
});
