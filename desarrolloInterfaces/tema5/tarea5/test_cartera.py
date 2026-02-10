#Carlos Rodríguez Lobato

from cartera import Cartera

# 1. Saldo inicial por defecto
def test_constructor_saldo_defecto():
    mi_cartera = Cartera()
    assert mi_cartera.saldo == 0

# 2. Tipo incorrecto en el constructor
def test_constructor_tipo_incorrecto():
    mi_cartera = Cartera("cien euros")
    assert mi_cartera.saldo == 0

# 3. Saldo negativo en el constructor
def test_constructor_saldo_negativo():
    mi_cartera = Cartera(-50)
    assert mi_cartera.saldo == 0

# 4. Saldo inicial válido (entero positivo)
def test_constructor_saldo_valido():
    mi_cartera = Cartera(100)
    assert mi_cartera.saldo == 100

def test_ingresar_suma_correctamente():
    mi_cartera = Cartera(10)
    ingreso = 5
    
    resultado_retorno = mi_cartera.ingresar(ingreso)
    
    assert resultado_retorno == 15
    
    assert mi_cartera.saldo == 15


# 1. Gastar dinero resta correctamente
def test_gastar_resta_correctamente():
    # Saldo inicial de 100, gastamos 30
    mi_cartera = Cartera(100)
    resultado_retorno = mi_cartera.gastar(30)
    
    # Comprobamos que devuelva 70 y que el saldo interno sea 70
    assert resultado_retorno == 70
    assert mi_cartera.saldo == 70

# 2. Gastar más del saldo disponible
def test_gastar_excesivo_devuelve_none():

    mi_cartera = Cartera(20)
    resultado_retorno = mi_cartera.gastar(50)
    
    assert resultado_retorno is None

    assert mi_cartera.saldo == 20