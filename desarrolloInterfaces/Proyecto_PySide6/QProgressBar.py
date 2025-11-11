import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QProgressBar
from PySide6.QtCore import QTimer


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.current_progress = 0 # Inicializa el progreso en 0%

        self.bar = QProgressBar()
        self.bar.setRange(0, 100) # Rango de la barra: 0 a 100
        self.bar.setValue(self.current_progress) # Valor inicial de la barra
        self.setCentralWidget(self.bar)

        # Crear un temporizador que cada 2 segundos pedirá acción al usuario
        self.timer = QTimer(self) 
        self.timer.timeout.connect(self.ask_user) # Conecta la señal timeout al método ask_user
        self.timer.start(2000)  # Inicia el temporizador con intervalo de 2000 ms (2 segundos)  

        self.setWindowTitle("progress: 0%")

    # Método que se ejecuta cada vez que el temporizador hace timeout
    def ask_user(self):
        print("\n=== Control progress ===")
        print("1 → incress progress")
        print("2 → decress progress")
        print("0 → Exit")
        opcion = input("Select an option: ")

        if opcion == "1":
            self.changed_progress("incress") # Aumenta progreso
        elif opcion == "2":
            self.changed_progress("decress") # Disminuye progreso
        elif opcion == "0":
            print("¡See you later!")
            self.timer.stop() # Detiene el temporizador 
            self.close() # Cierra la ventana
        else:
            print("Invalide option, retry.")

    # Método para actualizar el progreso según la acción
    def changed_progress(self, mood):
        if mood == "incress":
            self.current_progress = min(100, self.current_progress + 20) # Aumenta 20%, máximo 100
        elif mood == "decress":
            self.current_progress = max(0, self.current_progress - 20)  # Disminuye 20%, mínimo 0

        # Actualiza la barra de progreso
        self.bar.setValue(self.current_progress)

        if self.current_progress == 100:
            self.setWindowTitle("Completed task!")
        else:
            self.setWindowTitle(f"Progress: {self.current_progress}%")


        print("current_progress:", self.current_progress, "%")

app = QApplication(sys.argv)
MainWindow = MainWindow()
MainWindow.show()
sys.exit(app.exec())