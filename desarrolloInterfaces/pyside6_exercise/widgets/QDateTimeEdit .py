import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QDateTimeEdit
from PySide6.QtCore import QDateTime, Qt


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Hour and date selector")

        self.date_time_edit = QDateTimeEdit()
        self.date_time_edit.setDisplayFormat("dddd, d 'de' MMMM 'de' yyyy hh:mm") # Formato 
        self.date_time_edit.setDateTime(QDateTime.currentDateTime()) # Muestra la fecha y hora actuales al iniciar
        self.date_time_edit.setCalendarPopup(True)  # Permite desplegar un calendario (opcional)

        # Conectar la señal dateTimeChanged(QDateTime) a un método
        self.date_time_edit.dateTimeChanged.connect(self.on_date_time_changed)

        self.setCentralWidget(self.date_time_edit)

    # Método que se ejecuta cada vez que cambia la fecha y la hora
    def on_date_time_changed(self, datetime):
        print("Chosen date:", datetime.toString("dddd, d 'de' MMMM 'de' yyyy hh:mm"))

app = QApplication(sys.argv)
window = MainWindow()
window.resize(400, 100)
window.show()
sys.exit(app.exec())
