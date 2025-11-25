import sys
from PySide6.QtWidgets import (
    QApplication, 
    QMainWindow, 
    QDialog, 
    QLabel, 
    QPushButton, 
    QLineEdit, 
    QVBoxLayout, 
    QFormLayout, 
    QMessageBox,
    QWidget
)
from PySide6.QtCore import Slot, Qt

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Gestión de archivo y preferencias") # 1. Título

        # Contenido de la ventana principal
        label = QLabel("«Ventana principal»")
        label.setStyleSheet("font-size: 24px; font-weight: bold; padding: 50px;")
        label.setAlignment(Qt.AlignmentFlag.AlignCenter)
        
        self.setCentralWidget(label)


class DialogoLogin(QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Inicio de Sesión Requerido")
        self.setFixedSize(300, 180)

        layout_principal = QVBoxLayout(self)
        
        layout_form = QFormLayout()
        
        self.campo_usuario = QLineEdit()
        layout_form.addRow("Usuario:", self.campo_usuario)
        
        self.campo_password = QLineEdit()
        self.campo_password.setEchoMode(QLineEdit.EchoMode.Password)
        layout_form.addRow("Contraseña:", self.campo_password)
        
        layout_principal.addLayout(layout_form)
        
        self.btn_login = QPushButton("Iniciar Sesión")
        self.btn_login.clicked.connect(self.validar_credenciales)
        layout_principal.addWidget(self.btn_login)
        
        self.campo_password.returnPressed.connect(self.validar_credenciales)
        self.campo_usuario.returnPressed.connect(self.validar_credenciales)

    @Slot()
    def validar_credenciales(self):
        usuario = self.campo_usuario.text()
        password = self.campo_password.text()

        if usuario == "admin" and password == "admin":
            self.accept()
        else:
            QMessageBox.critical(
                self, 
                "Error de Credenciales", 
                "El usuario o la contraseña son incorrectos."
            )

if __name__ == "__main__":
    app = QApplication(sys.argv)
    dialogo_login = DialogoLogin()
    resultado = dialogo_login.exec()
    if resultado == QDialog.DialogCode.Accepted:
        ventana_principal = VentanaPrincipal()
        ventana_principal.showMaximized()
        sys.exit(app.exec())
    else:
        sys.exit(0)