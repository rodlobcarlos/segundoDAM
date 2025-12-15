import sys
import os
from PySide6.QtWidgets import (QApplication, QWidget, QVBoxLayout, 
                             QLabel, QLineEdit, QCheckBox, QRadioButton, 
                             QComboBox, QPushButton, QHBoxLayout, QFrame)
from PySide6.QtCore import Qt

class VentanaTarea(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Tarea 3.1 - Galería de Widgets Personalizados")
        self.setFixedSize(400, 900) 
        
        # --- LAYOUT PRINCIPAL ---
        layout = QVBoxLayout()
        layout.setContentsMargins(30, 30, 30, 30)
        layout.setSpacing(15) 
        self.setLayout(layout)

        # 0. TÍTULO DE LA VENTANA
        lbl_titulo = QLabel("TAREA 3.1: ESTILOS QSS")
        lbl_titulo.setObjectName("encabezado_principal")
        lbl_titulo.setAlignment(Qt.AlignmentFlag.AlignCenter)
        layout.addWidget(lbl_titulo)

        # --- 1. SECCIÓN QLINEEDIT ---
        lbl_1 = QLabel("1. Campo de Texto (QLineEdit)")
        lbl_1.setObjectName("etiqueta_seccion") 
        layout.addWidget(lbl_1)
        
        self.input_texto = QLineEdit()
        self.input_texto.setPlaceholderText("Escribe algo aquí...")
        layout.addWidget(self.input_texto)

        # --- 2. SECCIÓN QCHECKBOX ---
        lbl_2 = QLabel("2. Casilla de Verificación (QCheckBox)") 
        lbl_2.setObjectName("etiqueta_seccion")
        layout.addWidget(lbl_2)
        
        # CheckBox Normal
        self.chk_normal = QCheckBox("Opción Normal (:hover)")
        self.chk_normal.setCursor(Qt.CursorShape.PointingHandCursor)
        
        # CheckBox Activado
        self.chk_checked = QCheckBox("Opción Activada (:checked)")
        self.chk_checked.setChecked(True)
        self.chk_checked.setCursor(Qt.CursorShape.PointingHandCursor)

        # CheckBox Deshabilitado
        self.chk_disabled = QCheckBox("Opción Deshabilitada")
        self.chk_disabled.setEnabled(False) 
        self.chk_disabled.setChecked(True)  

        layout.addWidget(self.chk_normal)
        layout.addWidget(self.chk_checked)
        layout.addWidget(self.chk_disabled)

        # --- 3. SECCIÓN QRADIOBUTTON ---
        lbl_3 = QLabel("3. Botón de Opción (QRadioButton)")
        lbl_3.setObjectName("etiqueta_seccion")
        layout.addWidget(lbl_3)
        
        layout_radios = QVBoxLayout()
        layout_radios.setSpacing(10)
        
        self.rb_1 = QRadioButton("Opción A (Predeterminada)")
        self.rb_1.setChecked(True)
        self.rb_1.setCursor(Qt.CursorShape.PointingHandCursor)
        
        self.rb_2 = QRadioButton("Opción B (Alternativa)")
        self.rb_2.setCursor(Qt.CursorShape.PointingHandCursor)
        
        layout_radios.addWidget(self.rb_1)
        layout_radios.addWidget(self.rb_2)
        layout.addLayout(layout_radios)

        # --- 4. SECCIÓN QCOMBOBOX ---
        lbl_4 = QLabel("4. Desplegable (QComboBox)")
        lbl_4.setObjectName("etiqueta_seccion")
        layout.addWidget(lbl_4)
        
        self.combo = QComboBox()
        self.combo.addItems(["Selecciona...", "Configuración 1", "Configuración 2", "Configuración 3"])
        self.combo.setCursor(Qt.CursorShape.PointingHandCursor)
        layout.addWidget(self.combo)

        # --- 5. SECCIÓN QPUSHBUTTON ---
        lbl_5 = QLabel("5. Botones de Acción (QPushButton)") 
        lbl_5.setObjectName("etiqueta_seccion")
        layout.addWidget(lbl_5)

        # Botón Principal
        self.btn_accion = QPushButton("GUARDAR CAMBIOS")
        self.btn_accion.setCursor(Qt.CursorShape.PointingHandCursor) 
        
        # Botón Secundario
        self.btn_inactivo = QPushButton("FUNCIÓN PREMIUM")
        self.btn_inactivo.setEnabled(False)

        layout.addWidget(self.btn_accion)
        layout.addWidget(self.btn_inactivo)

        # Espaciador final
        layout.addStretch()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    app.setStyle("Fusion")

    # --- CARGA OBLIGATORIA DESDE ARCHIVO EXTERNO ---
    ruta_script = os.path.dirname(os.path.abspath(__file__))
    # Asegúrate de que este nombre coincida EXACTAMENTE con tu archivo .qss
    nombre_archivo_qss = "rodriguez_carlos_estilos_T3.3.1.qss"
    ruta_qss = os.path.join(ruta_script, nombre_archivo_qss)

    with open(ruta_qss, "r") as f:
        app.setStyleSheet(f.read())    

    ventana = VentanaTarea()
    ventana.show()
    sys.exit(app.exec())