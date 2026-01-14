import pandas as pd
import datapane as dp

# Leer informe (en la misma carpeta que este archivo.py)
fichero_csv = "DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)
#print(df)

# Crear informe solo con este codigo python
table = dp.Table(df)
data_table = dp.DataTable(df)

imagen = dp.Media(file='DI_U05_A02_PP_E_02.jpg')

titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
)

texto_explicativo = dp.HTML(
    '<p style="font-size:16px; text-align:center; color:#000000;">'
    'Esta información de aquí arriba es relevante para dirección porque se aprecia el crecimiento de la empresa'
    ' con el paso de lo años. Además, se observa la comparación de los dos últimos años, esto vale para saber el beneficio'
    ' en ese tiempo de la empresa y poder actuar sobre ello para posibles mejoras en un futuro.</p>'
)

# Total de todo los años
total_2017 = df[df['Año'] == 2017]
venta2017 = total_2017['Ventas'].sum()
print(venta2017)

total_20218 = df[df['Año'] == 2018]
venta2018 = total_20218['Ventas'].sum()
print(venta2018)

total_20219 = df[df['Año'] == 2019]
venta2019 = total_20219['Ventas'].sum()
print(venta2019)

total_2020 = df[df['Año'] == 2020]
venta2020 = total_2020['Ventas'].sum()
print(venta2020)

total_2021 = df[df['Año'] == 2021]
venta2021 = total_2021['Ventas'].sum()
print(venta2021)

# Año con mayor volumen de ventas
mayor_ventas = df[df['Año'] == 2019]
venta = mayor_ventas['Ventas'].sum()
print(venta)

# Comparación de 2021/2020
ventas_2021 = df[df['Año'] == 2021]
suma_2021 = ventas_2021['Ventas'].sum()
print(suma_2021)

ventas_2020 = df[df['Año'] == 2020]
suma_2020 = ventas_2020['Ventas'].sum()
print(suma_2020)

# Cuadro comparativo
unidades1 = dp.BigNumber(
    heading='Ventas en 2021 / comparado con 2020',
    value=suma_2021,
    change=suma_2021 - suma_2020,
    is_upward_change=suma_2021 > suma_2020
)

# Cuadro con mayor volumen de ventas
unidades2 = dp.BigNumber(
    heading='Año con mayor volumen de ventas: 2019',
    value=venta,
)

# Ventas acumuladas de todos los años
total2017 = dp.BigNumber(
    heading='Total de ventas 2017',
    value=venta2017,
)

total2018 = dp.BigNumber(
    heading='Total de ventas 2018',
    value=venta2018,
)

total2019 = dp.BigNumber(
    heading='Total de ventas 2019',
    value=venta2019,
)

total2020 = dp.BigNumber(
    heading='Total de ventas 2020',
    value=venta2020,
)

total2021 = dp.BigNumber(
    heading='Total de ventas 2021',
    value=venta2021,
)

# Fichero descarga
fichero = dp.Attachment(file='DI_U05_A02_PP_E_01.csv')

# Resumen de la página
report = dp.Report(
    imagen,
    titulo,
    total2017,
    total2018,
    total2019,
    total2020,
    total2021,
    unidades2,
    unidades1,
    texto_explicativo,
    data_table,
    fichero
)
# crea html con el resumen creado
report.save(path="DI_U05_A02_PP_E_01.html", open=True)