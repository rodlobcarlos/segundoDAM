import sys

from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QTextEdit,
    QLineEdit,
    QComboBox,
    QRadioButton,
    QFormLayout,
    QVBoxLayout,
    QHBoxLayout,
    QToolBar,
    QStatusBar,
    QMessageBox,
    QDockWidget,
    QLabel
)
from PySide6.QtGui import QAction, QKeySequence
from PySide6.QtCore import Qt

class OtraVentana(QLabel):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Notas internas")


class CompañiaTelefonica(QMainWindow):
    def __init__(self):
        super().__init__()

        # Titulo y tamaño minimo de la ventana
        self.setWindowTitle("Encuesta de satisfación - Compañía de teléfono móvil")
        self.setMinimumSize(600, 400)

        # Declarar atributos de widgets
        self.line_edit_nombre = None
        self.line_edit_telefono = None
        self.line_edit_compañia = None
        self.line_edit_satisfacionGlobal = None
        self.otra_ventana = None 


        # Declarar acciones
        self.accion_iniciar_sesion = None
        self.accion_nueva_encuesta = None
        self.accion_ver_resumen = None
        self.accion_salir = None
        self.accion_acercaDe = None

        # Construccion general
        self.crear_central()      
        self.crear_acciones()     
        self.crear_menus()        
        self.crear_toolbar()      
        self.crear_statusbar()    
        self.conectar_señales()   

        # --- Creacion zona central ---
    def crear_central(self):
        widget_central = QWidget()
        widget_flotante = QDockWidget()

        # Crear widgets del formulario
        self.line_edit_nombre = QLineEdit()
        self.line_edit_nombre.setPlaceholderText("Inicia seción para rellenar el nombre")

        self.line_edit_telefono = QLineEdit()
        self.line_edit_telefono.setPlaceholderText("Número de teléfono")

        self.line_edit_compañia = QComboBox()
        self.line_edit_compañia.addItems(["Lowi", "MasMovil", "WifiGuay", "TuWifi"])

        self.line_edit_satisfacionGlobal = QComboBox()
        self.line_edit_satisfacionGlobal.addItems(["Baja", "Media","Alta"]) 

        self.radio_si = QRadioButton("Sí")
        self.radio_no = QRadioButton("No")
        layout_prioridad = QHBoxLayout() # Un layout horizontal para los botones
        layout_prioridad.addWidget(self.radio_si)
        layout_prioridad.addWidget(self.radio_no)
        layout_prioridad.addStretch() # Para que no se separen

        self.texto_nota = QTextEdit()
        self.texto_nota.setPlaceholderText("Notas internas sobre esta encuesta...")

        # Crear layouts (formulario + layout principal)
        layout_form = QFormLayout()
        layout_principal = QVBoxLayout()

        # Añadir widgets al layout del formulario
        layout_form.addRow("Nombre", self.line_edit_nombre)
        layout_form.addRow("Teléfono", self.line_edit_telefono)
        layout_form.addRow("Compañía", self.line_edit_compañia)
        layout_form.addRow("Satisfación global", self.line_edit_satisfacionGlobal)

        # Añadir layouts al layout principal
        layout_principal.addLayout(layout_form)
        layout_principal.addWidget(self.texto_nota)

        # setLayout del widget 
        widget_central.setLayout(layout_principal)

        self.setCentralWidget(widget_central)
        self.setCentralWidget(widget_flotante)

    # --- Acciones, menus y toolbar ---
    def crear_acciones(self):
        # Crear acciones (QAction) con texto y atajos
        self.accion_iniciar_sesion = QAction("Iniciar sesión", self)
        self.accion_iniciar_sesion.setShortcut(QKeySequence("Ctrl+P"))  # Atajo de teclado
        # self.accion_iniciar_sesion.triggered.connect(self.slot_iniciar_sesion) ERROR

        self.accion_nueva_encuesta = QAction("Nueva encuesta", self)
        self.accion_nueva_encuesta.setShortcut(QKeySequence("Ctrl+L"))  # Atajo de teclado
        # self.accion_nueva_encuesta.triggered.connect(self.slot_nueva_encuesta) ERROR

        self.accion_ver_resumen = QAction("Ver resumen", self)
        self.accion_ver_resumen.setShortcut(QKeySequence("Ctrl+O"))  # Atajo de teclado
        # self.accion_ver_resumen.triggered.connect(self.slot_ver_resumen) ERROR 

        self.accion_salir = QAction("Salir", self)
        self.accion_salir.setShortcut(QKeySequence("Ctrl+I"))  # Atajo de teclado
        self.accion_salir.triggered.connect(self.slot_salir)

        self.accion_acercaDe = QAction("Acerca de", self)
        self.accion_acercaDe.setShortcut(QKeySequence("Ctrl+K"))  # Atajo de teclado
        self.accion_acercaDe.triggered.connect(self.slot_acercaDe)
        pass

    def crear_menus(self):
        # Crear barra de menus y añadir los menus encuesta y ayuda
        barra_menus = self.menuBar()
        menu_encuesta = barra_menus.addMenu("Encuesta")
        menu_encuesta.addAction(self.accion_iniciar_sesion)
        menu_encuesta.addAction(self.accion_nueva_encuesta)
        menu_encuesta.addAction(self.accion_ver_resumen)
        menu_encuesta.addAction(self.accion_salir)
        menu_encuesta.addSeparator() # Línea separadora

        menu_encuesta = barra_menus.addMenu("Ayuda")
        menu_encuesta.addAction(self.accion_acercaDe)
        pass

    def crear_toolbar(self):
        # Crear barra de herramientas y añadir las acciones basicas
        toolbar = QToolBar()
        self.addToolBar(toolbar) # Añadir la barra a la ventana
        toolbar.addAction(self.accion_nueva_encuesta)
        toolbar.addAction(self.accion_ver_resumen)
        pass

    def crear_statusbar(self):
        barra_estado = QStatusBar()
        self.statusBar().showMessage("Listo...", 3000)
        pass

    # --- Señales ---
    def conectar_señales(self):
        # Conectar señales
        #self.line_edit_nombre.textChanged.connect(self.slot_nombre_cambiado)
        #self.line_edit_telefono.textChanged.connect(self.slot_telefono_cambiado)
        #self.line_edit_compañia.currentTextChanged.connect(self.slot_compañia_cambiada)
        #self.line_edit_compañia.currentTextChanged.connect(self.slot_compañia_cambiada)
        pass

    # --- Funciones de utilidad ---
    def obtener_satisfaccion_actual(self):
        # devolver satisfaccion actual
        if self.radio_si:
            satisfaccion = "SI"
        else:
            satisfaccion = "NO"
        return satisfaccion
    
    def obtener_compañia_actual(self): 
        if self.line_edit_compañia == "Lowi":
            compañia = "LOWI"
        elif self.line_edit_compañia == "MasMovil":
            compañia = "MASMOVIL"
        elif self.line_edit_compañia == "WifiGuay":
            compañia = "WIFIGUAY"
        else:
            compañia = "TUWIFI"
        return compañia
    
    def iniciar_sesion(self):
        # Iniciar sesion desde el menu encuesta
        if self.otra_ventana is None:
            self.otra_ventana = OtraVentana("Iniciar sesión")
            self.otra_ventana.show()

    def nueva_encuesta(self):
        self.line_edit_Nombre.clear()
        self.line_edit_telefono.clear()
        self.line_edit_Compañia.setCurrentIndex(0)
        self.line_edit_satisfacionGlobal.setCurrentIndex(0)
        self.radio_no.setChecked(False)
        self.radio_si.setChecked(False)
        self.texto_nota.clear()
        pass
    
    # --- Slots (logica) --- ERRORES
    #def slot_nombre_cambiado(self, nuevo_nombre): 
    #    self.line_edit_Nombre.setText("Nombre", {nuevo_nombre})
    #    self.statusBar().showMessage(f"Mombre cambiado a: {nuevo_nombre}", 3000)
    #    pass
#
    #def slot_telefono_cambiado(self, nuevo_telefono):
    #    self.line_edit_telefono.setText("Telefono", {nuevo_telefono})
    #    self.statusBar().showMessage(f"Telefono cambiado a: {nuevo_telefono}", 3000)
    #    pass
#
    #def slot_compañia_cambiada(self, nueva_compañia):
    #    self.statusBar().showMessage(f"Compañía cambiada a: {nueva_compañia}", 3000)
    #    pass
#
    #def slot_iniciar_sesion(self):
    #    self.iniciar_sesion()
    #    self.statusBar().showMessage("Has iniciado sesión.", 3000)
    #    pass
#
    #def slot_nueva_encuesta(self):
    #    self.nueva_encuesta()
    #    self.statusBar().showMessage("Has creado una nueva encuesta.", 3000)


    #def slot_ver_resumen(self):  ERROR
    #    QMessageBox.information(
    #        self, # Ventana padre
    #        "Nombre:",
    #        "Compañía:",
    #        "Satisfación:" ,
    #        "Recomendación:",
    #        QMessageBox.StandardButton.Ok
    #    )
        
    def slot_salir(self):
        dialogo = QMessageBox.question(
            self, # Ventana padre
            "Confirmación de Salida",
            "¿Estás seguro de que quieres salir de la ventana?",
            # Botones que aparecerán en el cuadro
            QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No,
            QMessageBox.StandardButton.No # Botón por defecto seleccionado
        )

        # Si el usuario presiona 'Sí' (Yes), cerramos la ventana principal
        if dialogo == QMessageBox.StandardButton.Yes:
            self.close()
        pass

    def slot_acercaDe(self):
        QMessageBox.information(
            self, # Ventana padre
            "Acerca de la ventana",
            "Examen de desarrollo de interfaces",
            QMessageBox.StandardButton.Ok
        )
        pass

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = CompañiaTelefonica()
    ventana.show()
    app.exec()