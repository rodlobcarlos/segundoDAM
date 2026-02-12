def factorial(n):
    if not isinstance(n, int): 
        raise TypeError("n debe ser un número entero")
    if n < 0: 
        raise ValueError("n no puede ser negativo")

    resultado = 1
    for i in range(2, n + 1):
        resultado *= i
    return resultado