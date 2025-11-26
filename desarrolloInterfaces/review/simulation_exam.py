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
    QMessageBox
)
from PySide6.QtGui import QAction, QKeySequence
from PySide6.QtCore import Qt


class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        # TODO: tÃ­tulo y tamaÃ±o mÃ­nimo de la ventana
        self.setWindowTitle("Mini note blog")
        self.setMinimumSize(600, 400)

        # TODO: declarar atributos de widgets (title, categoria, prioridad, area de texto)
        self.line_edit_titulo = None
        self.line_edit_categoria = None
        self.line_edit_prioridad = None
        self.line_edit_areaDeTexto = None
        # ...

        # TODO: declarar acciones (limpiar, imprimir, salir, acerca de)
        self.accion_limpiar_nota = None
        self.accion_imprimir_nota = None
        self.accion_salir = None
        self.accion_acercaDe = None
        # ...

        # ConstrucciÃ³n general
        self.crear_central()      
        self.crear_acciones()     
        self.crear_menus()        
        self.crear_toolbar()      
        self.crear_statusbar()    
        self.conectar_senales()   

    # =========================
    # CREACIÃ“N DE LA ZONA CENTRAL
    # =========================
    def crear_central(self):
        widget_central = QWidget()

        # TODO: crear widgets del formulario
        self.line_edit_titulo = QLineEdit()
        self.line_edit_titulo.setPlaceholderText("Escribe aquí...")
        self.line_edit_titulo.setMaxLength(50)

        self.combo_categoria = QComboBox()
        self.combo_categoria.addItems(["Trabajo", "Ideas", "Otros"])

        self.radio_prioridad_normal = QRadioButton("Normal")
        self.radio_prioridad_normal.setChecked(True) # Marca por defecto
        self.radio_prioridad_alta = QRadioButton("Alta")
        layout_prioridad = QHBoxLayout() # Un layout horizontal para los botones
        layout_prioridad.addWidget(self.radio_prioridad_normal)
        layout_prioridad.addWidget(self.radio_prioridad_alta)
        layout_prioridad.addStretch() # Para que no se separen

        self.texto_nota = QTextEdit()
        self.texto_nota.setPlaceholderText("Escribe una nota...")

        # TODO: crear layouts (formulario + layout principal)
        layout_form = QFormLayout()
        layout_principal = QVBoxLayout()

        # TODO: aÃ±adir widgets al layout del formulario
        layout_form.addRow("Titulo:", self.line_edit_titulo)
        layout_form.addRow("Categoría:", self.combo_categoria)
        layout_form.addRow("Prioridad:", layout_prioridad)

        # TODO: aÃ±adir layouts al layout principal
        layout_principal.addLayout(layout_form)
        layout_principal.addWidget(self.texto_nota)

        # TODO: setLayout del widget 
        widget_central.setLayout(layout_principal)

        self.setCentralWidget(widget_central)

    # =========================
    # ACCIONES, MENÃš Y TOOLBAR
    # =========================
    def crear_acciones(self):
        # TODO: crear acciones (QAction) con texto y atajos
        self.accion_limpiar_nota = QAction("Limpiar nota", self)
        self.accion_limpiar_nota.setShortcut(QKeySequence("Ctrl+P"))  # Atajo de teclado
        self.accion_limpiar_nota.triggered.connect(self.slot_limpiar_nota)

        self.accion_imprimir_nota = QAction("Impimir nota", self)
        self.accion_imprimir_nota.setShortcut(QKeySequence("Ctrl+L"))  # Atajo de teclado
        self.accion_imprimir_nota.triggered.connect(self.slot_imprimir_nota)

        self.accion_salir = QAction("Salir", self)
        self.accion_salir.setShortcut(QKeySequence("Ctrl+K"))  # Atajo de teclado
        self.accion_salir.triggered.connect(self.slot_salir)

        self.accion_acercaDe = QAction("Acerca de", self)
        self.accion_acercaDe.setShortcut(QKeySequence("Ctrl+I"))  # Atajo de teclado
        self.accion_acercaDe.triggered.connect(self.slot_acerca_de)
        pass

    def crear_menus(self):
        # TODO: crear la barra de menÃºs y aÃ±adir los menÃºs Archivo y Ayuda
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("Archivo")
        menu_archivo.addAction(self.accion_limpiar_nota)
        menu_archivo.addAction(self.accion_imprimir_nota)
        menu_archivo.addAction(self.accion_salir)
        menu_archivo.addSeparator() # Línea separadora

        menu_archivo = barra_menus.addMenu("Ayuda")
        menu_archivo.addAction(self.accion_acercaDe)
        pass

    def crear_toolbar(self):
        # TODO: crear barra de herramientas y aÃ±adir las acciones bÃ¡sicas
        toolbar = QToolBar()
        self.addToolBar(toolbar) # Añadir la barra a la ventana
        toolbar.addAction(self.accion_limpiar_nota)
        toolbar.addAction(self.accion_imprimir_nota)
        pass

    def crear_statusbar(self):
        # TODO: crear barra de estado y mostrar un mensaje inicial
        barra_estado = QStatusBar()
        self.statusBar().showMessage("Listo...", 3000)
        pass

    # =========================
    # SEÃ‘ALES
    # =========================
    def conectar_senales(self):
        # TODO conectar seÃ±ales como textChanged, currentTextChanged, toggled...
        self.line_edit_titulo.textChanged.connect(self.slot_titulo_cambiado)
        self.combo_categoria.currentTextChanged.connect(self.slot_categoria_cambiada)
        self.radio_prioridad_normal.toggled.connect(self.slot_prioridad_cambiada)
        self.radio_prioridad_alta.toggled.connect(self.slot_prioridad_cambiada)
        pass

    # =========================
    # FUNCIONES DE UTILIDAD
    # =========================
    def obtener_prioridad_actual(self):
        # TODO devolver prioridad actual
        if self.radio_prioridad_alta.isChecked:
            prioridad = "ALTA"
        else:
            prioridad = "NORMAL"
        return prioridad   

    def limpiar_contenido_nota(self):
        # TODO borrar tÃ­tulo, categorÃ­a, prioridad y contenido
        self.line_edit_titulo.clear()
        self.combo_categoria.setCurrentIndex(0)
        self.radio_prioridad_normal.setChecked(True)
        self.texto_nota.clear()
        pass

    def imprimir_en_consola(self):
        # TODO imprimir la nota completa usando print con comas
        titulo = self.line_edit_titulo.text()
        categoria = self.combo_categoria.currentText()
        prioridad = self.obtener_prioridad_actual() # Necesitas esta función de utilidad
        contenido = self.texto_nota.toPlainText()

        print("--- NOTA ACTUAL ---")
        print("TÍTULO:", titulo)
        print("CATEGORÍA:", categoria)
        print("PRIORIDAD:", prioridad)
        print("CONTENIDO:")
        print(contenido)
        print("------------")
        pass

    # =========================
    # SLOTS (LOGICA)
    # =========================
    def slot_limpiar_nota(self):
        # TODO mostrar cuadro de confirmaciÃ³n y limpiar si aceptan
        self.limpiar_contenido_nota()
        self.statusBar().showMessage("Contenido de la nota limpiado.", 3000)
        pass

    def slot_imprimir_nota(self):
        # TODO llamar a imprimir_en_consola y mostrar mensaje
        self.imprimir_en_consola()
        self.statusBar().showMessage("Nota impresa en la consola.", 3000)
        pass

    def slot_salir(self):
        # TODO pedir confirmaciÃ³n antes de cerrar
        dialogo = QMessageBox.question(
            self, # Ventana padre
            "Confirmación de Salida",
            "¿Estás seguro de que quieres salir de Mini note blog?",
            # Botones que aparecerán en el cuadro
            QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No,
            QMessageBox.StandardButton.No # Botón por defecto seleccionado
        )

        # Si el usuario presiona 'Sí' (Yes), cerramos la ventana principal
        if dialogo == QMessageBox.StandardButton.Yes:
            self.close()
        pass

    def slot_acerca_de(self):
        # TODO mostrar QMessageBox.information
        QMessageBox.information(
            self, # Ventana padre
            "Acerca de Mini note blog",
            "**Mini note blog v1.0**\n\n"
            "Aplicación de gestión de notas simples desarrollada con PySide6.\n\n"
            "© 2025 - Desarrollo de Interfaces",
            QMessageBox.StandardButton.Ok
        )
        pass

    def slot_titulo_cambiado(self, nuevo_titulo):
        # TODO actualizar tÃ­tulo de la ventana y barra de estado
        self.setWindowTitle(f"Mini note blog {nuevo_titulo}")
        self.statusBar().showMessage(f"Titulo cambiado a: {nuevo_titulo}", 3000)
        pass

    def slot_categoria_cambiada(self, nueva_categoria):
        # TODO mostrar categorÃ­a en la barra
        self.statusBar().showMessage(f"Categoría cambiada a: {nueva_categoria}", 3000)
        pass

    def slot_prioridad_cambiada(self, checked):
        # TODO reaccionar solo si checked es True
        if checked:
            prioridad = self.obtener_prioridad_actual()
            self.statusBar().showMessage(f"Prioridad cambiada a: {prioridad}")
        pass


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()