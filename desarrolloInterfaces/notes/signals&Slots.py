'''
Este código enseñá la conección de una señal a
un slot(funión).
'''

'''Importe de clases'''
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My app!")
        button = QPushButton("Press me!")

      
        #Conecta una señal(clicked) a un funcion(the_button_was_clicked)
        button.clicked.connect(self.the_button_was_clicked) 

        self.setCentralWidget(button)

    # Definimos esa funcion conectada a la señal
    def the_button_was_clicked(self):
        print("Clicked!!")

app = QApplication([])
window = MainWindow()
window.show()
app.exec()