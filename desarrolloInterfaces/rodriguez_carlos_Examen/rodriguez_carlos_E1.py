import pandas as pd
import datapane as dp

df = pd.read_csv("uso_servicios_municipales.csv")

table = dp.Table(df)
dataTable = dp.DataTable(df)
report = dp.Report(table, dataTable)

report.save(path="rodriguez_carlos_E1_tabla.html", open=True)