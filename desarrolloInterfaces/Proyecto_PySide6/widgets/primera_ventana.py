from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My App") #Titulo de la ventana
        button = QPushButton("Press Me!") #Inicializo un botton (Press me!)
        button.setCheckable(True) #Nos dice un booleano, si es chequeado o no

        button.clicked.connect(self.the_button_was_clicked)
        button.clicked.connect(self.the_button_was_toggled)

        self.setCentralWidget(button)

    '''Nos dice si se hace click'''
    def the_button_was_clicked(self):
            print("Clicked!")

    '''
    Alterna el booelano checked entre True o False
    Solo si setCheckable(True), si es False sale solo False    
    '''
    def the_button_was_toggled(self, checked):
            print("Checkd?", checked) 

app = QApplication([])
window = MainWindow()
window.show()
app.exec()