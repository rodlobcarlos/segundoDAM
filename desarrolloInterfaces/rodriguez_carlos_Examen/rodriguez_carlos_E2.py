import pandas as pd
import datapane as dp

df = pd.read_csv("uso_servicios_municipales.csv")

titulo = dp.HTML('<p style="font-size:30px;text-aling:center;color:#ffffff;background-color:#4d4d4d">Resumen ejecutivo - Uso de servicios multiples</p>')
texto = dp.Text("Este resumen ejecutivo es importante para el ayuntamiento, porque muestra información importante sobre el uso a lo largo de los años.")

total_usos = df[df['anio'] == 2019];
suma_usos = total_usos['numero_usos'].sum()

uso_2023 = df[df['anio'] == 2023];
total_2023 = uso_2023['numero_usos'].sum()

uso_2022 = df[df['anio'] == 2022];
total_2022 = uso_2022['numero_usos'].sum()

usos_totales = dp.BigNumber(
    heading='Usos totales',
    value=suma_usos
)

comparacion_años = dp.BigNumber(
    heading='Comparativa 2023/2022',
    value=total_2023,
    change=total_2023 - total_2022,
    is_upward_change= total_2023 > total_2022
)

report = dp.Report(
    titulo,
    texto,
    usos_totales,
    comparacion_años
)

report.save(path="rodriguez_carlos_E1_resumen.html", open=True)
