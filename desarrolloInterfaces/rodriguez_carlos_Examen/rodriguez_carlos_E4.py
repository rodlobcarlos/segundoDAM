import pandas as pd
import datapane as dp

df = pd.read_csv("uso_servicios_municipales.csv")

servicios = df.groupby(['anio'], sort=False).sum()
grafico_linea = servicios.plot(y='numero_usos')

servicios = df.groupby(['distrito'], sort=False).sum()
grafico_barra = servicios.plot.bar(y='numero_usos')

servicios = df.groupby(['servicio'], sort=False).sum()
grafico_sector = servicios.plot.pie(y='numero_usos', legend=False, ylabel="")

table = dp.Table(df)
dataTable = dp.DataTable(df)

bloque_linea = dp.Plot(grafico_linea)
bloque_barra = dp.Plot(grafico_barra)
bloque_sector = dp.Plot(grafico_sector)

report = dp.Report(
    dp.Page(
        title="Resumen",
        blocks=[
            dp.Group(
                bloque_linea, 
                bloque_barra, 
                bloque_sector,
                dataTable,
                columns=2
            )
        ]
    ),
    dp.Page(
        title="Anáisis",
        blocks=[
            dp.Select(
                blocks=[
                    bloque_barra, table
                ]
            )
        ]
    )
)

report.save(path="rodriguez_carlos_E1_informe_organizado.html", open=True)