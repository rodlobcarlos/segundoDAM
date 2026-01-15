import pandas as pd
import datapane as dp

# Cargar los datos desde el CSV
df = pd.read_csv("DI_U05_A02_PP_E_01.csv")

# Agrupar por vendedor y sumar (para obtener los totales)
ventas_productos = df.groupby(["Tipo de producto"]).sum()

# Crear el gráfico de sectores (tarta)
grafico_matplotlib = ventas_productos.plot.pie(
    y="Ventas",
    legend=False,
    ylabel=""
)

# Adaptar el gráfico para Datapane
grafico_datapane = dp.Plot(grafico_matplotlib)

# Crear el informe Datapane
reporte = dp.Report(
    dp.Text("# Distribución de las ventas por productos."),
    grafico_datapane
)

# Guardar y abrir el informe
reporte.save("informe_distribución_de_las_ventas_totales.html", open=True)