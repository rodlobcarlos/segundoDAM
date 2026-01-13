import pandas as pd
import datapane as dp

# Leer informe (en la misma carpeta que este archivo.py)
fichero_csv = "DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)
#print(df)

# Crear informe solo con este codigo python
table = dp.Table(df)
data_table = dp.DataTable(df)

report = dp.Report(table, data_table)

imagen = dp.Media(file='DI_U05_A02_PP_E_02.jpg')

titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
)


mayor_ventas = df[df['Año'] == 2020]
venta = mayor_ventas['Ventas'].max()
print(venta)

ventas_2021 = df[df['Año'] == 2021]
suma_2021 = ventas_2021['Ventas'].sum()
print(suma_2021)

ventas_2020 = df[df['Año'] == 2020]
suma_2020 = ventas_2020['Ventas'].count()
print(suma_2020)

unidades1 = dp.BigNumber(
    heading='Mayor venta',
    value=suma_2021,
    change=suma_2021 - suma_2020,
    is_upward_change=suma_2021 > suma_2020
)

unidades2 = dp.BigNumber(
    heading='2020',
    value=venta,
)

fichero = dp.Attachment(file='DI_U05_A02_PP_E_01.csv')

report = dp.Report(
    imagen,
    titulo,
    unidades1,
    unidades2,
    data_table,
    fichero
)
report.save(path="DI_U05_A02_PP_E_01.html", open=True)

'''
# Suma las unidades de el mes que le pases
datos_diciembre = df[df['Mes'] == 'Diciembre']
unidades_diciembre = datos_diciembre['Unidades'].sum()
print(unidades_diciembre)

datos_noviembre = df[df['Mes'] == 'Noviembre']
unidades_noviembre = datos_noviembre['Unidades'].sum()
print(unidades_noviembre)

# Crea html con los datos que le pasemos y lo carga
unidades = dp.BigNumber(
    heading='Unidades totales en diciembre',
    value=unidades_diciembre,
    change=unidades_diciembre - unidades_noviembre,
    is_upward_change=unidades_diciembre > unidades_noviembre
)

report = dp.Report(unidades)
report.save(path='DI_U05_A02_05.html', open=True)

texto = dp.Text("**Puedes descargar el fichero con los datos del informe.**")

titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
)

imagen = dp.Media(file='DI_U05_A02_07.png')

fichero = dp.Attachment(file='DI_U05_A02_02.csv')

report = dp.Report(
    imagen,
    titulo,
    unidades,
    texto,
    fichero
)

report.save(path='DI_U05_A02_08.html', open=True)
'''