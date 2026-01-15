import pandas as pd
import datapane as dp

# Cargar los datos desde el CSV
df = pd.read_csv("DI_U05_A02_PP_E_01.csv")

# Seleccionamos solo las filas donde la columna "Año" es 2020 o 2021
df_filtrado = df[df["Año"].isin([2020, 2021])]

# Agrupar los datos por mes y sumar las unidades vendidas
ventas_2021 = df_filtrado.groupby(["Año"], sort=False).sum()

# Crear el gráfico de líneas (Matplotlib a través de Pandas)
grafico_matplotlib = ventas_2021.plot(y="Ventas")

# Adaptar el gráfico para Datapane
grafico_datapane = dp.Plot(grafico_matplotlib)

reporte = dp.Report(
    dp.Text("# Evolución de ventas"),
    grafico_datapane,
)

reporte.save("evolucion_ventas.html", open=True)