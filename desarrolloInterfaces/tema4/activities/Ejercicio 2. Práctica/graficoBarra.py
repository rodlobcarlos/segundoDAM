import pandas as pd
import datapane as dp

# Cargar los datos desde el CSV
df = pd.read_csv("DI_U05_A02_PP_E_01.csv")

# Agrupar los datos por vendedor y sumar los importes
ventas_region = df.groupby(["Región"]).sum()

# Crear el gráfico de barras (Pandas usa Matplotlib internamente)
grafico_matplotlib = ventas_region.plot.bar(y="Ventas")

# Adaptar el gráfico para Datapane
grafico_datapane = dp.Plot(grafico_matplotlib)

# Crear el informe Datapane
reporte = dp.Report(
    dp.Text("# Ventas por región"),
    grafico_datapane
)

# Guardar y abrir el informe
reporte.save("informe_ventas_region.html", open=True)