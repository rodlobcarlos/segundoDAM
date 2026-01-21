import pandas as pd
import datapane as dp

# 1. Carga y procesamiento 
df = pd.read_csv("DI_U05_A02_PP_E_01.csv")
df_filtrado = df[df["Año"].isin([2020, 2021])]

# Gráfico 1: Ventas por Año
grafico_datapane1 = dp.Plot(df_filtrado.groupby(["Año"]).sum().plot(y="Ventas"))

# Gráfico 2: Ventas por Región
grafico_datapane2 = dp.Plot(df.groupby(["Región"]).sum().plot.bar(y="Ventas"))

# Gráfico 3: Ventas por Producto
grafico_datapane3 = dp.Plot(df.groupby(["Tipo de producto"]).sum().plot.pie(y="Ventas", legend=False, ylabel=""))

data_table = dp.DataTable(df)

# Definimos el reporte con sus páginas y lo guardamos en la variable 'reporte'
reporte = dp.Report(
    dp.Page(
        title="Informe general",
        blocks=[
            dp.Group(
                grafico_datapane1, 
                grafico_datapane2,
                grafico_datapane3,
                data_table,
                columns=2
            )
        ]
    ),
    dp.Page(
        title="Página alternativa",
        blocks=[
        dp.Select(
            blocks=[grafico_datapane1, grafico_datapane2, grafico_datapane3]
        )]
    )
)



   
# Ahora guardamos el objeto que contiene las páginas
reporte.save("rodriguez_carlos_T4.4.html", open=True)