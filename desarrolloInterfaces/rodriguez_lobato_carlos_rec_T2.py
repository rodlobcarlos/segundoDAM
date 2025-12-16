from PySide6.QtWidgets import (
    QApplication, 
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLineEdit,
    QPushButton,
    QLabel,
    QTextEdit,
    QCheckBox
)
from PySide6.QtGui import QAction

class blocIncidencias(QMainWindow):
    def __init__(self):
        super().__init__()
        # --- Titulo de ventana ---
        self.setWindowTitle("Bloc de incidencias del aula")
        self.setMinimumSize(400, 200)

        # --- Contenedor y layout ---
        self.contenedor_principal = QWidget()
        self.layout_v = QVBoxLayout()

        # --- Entrada de grupo ---
        self.etiqueta_grupo = QLabel("Grupo")
        self.caja_grupo = QLineEdit()
        self.caja_grupo.setPlaceholderText("Escribe el grupo...")


        self.layout_v.addWidget(self.etiqueta_grupo)
        self.layout_v.addWidget(self.caja_grupo)

        # --- Entrada de alumno ---
        self.etiqueta_alumno = QLabel("Alumno")
        self.caja_alumno = QLineEdit()
        self.caja_alumno.setPlaceholderText("Nombre del alumno...")


        self.layout_v.addWidget(self.etiqueta_alumno)
        self.layout_v.addWidget(self.caja_alumno)
        
        # --- Tipo de incidencia ---
        self.etiqueta_incidencia = QLabel("Incidencia")
        self.caja_incidencia = QLineEdit()
        self.caja_incidencia.setPlaceholderText("Escribe la incidencia...")


        self.layout_v.addWidget(self.etiqueta_incidencia)
        self.layout_v.addWidget(self.caja_incidencia)

        # --- Descripcion incidencia ---
        self.descripcion_incidencia = QLabel("Descripción incidencia")
        self.caja_descripcion = QTextEdit()

        self.layout_v.addWidget(self.descripcion_incidencia)
        self.layout_v.addWidget(self.caja_incidencia)

        # --- Incidencia resuelta ---
        self.casilla_verificacion = QCheckBox("Casilla verificación")
        self.casilla_verificacion.setCheckable(True)

        self.layout_v.addWidget(self.casilla_verificacion)

        # --- Botones ---
        self.boton_añadir = QPushButton("Añadir incidencia")
        #self.boton_añadir.clicked.connect(self.añadir) No se añade al historial
        
        self.boton_limpiar = QPushButton("Limpiar formulario")
        self.boton_limpiar.clicked.connect(self.limpiar)

        self.layout_v.addWidget(self.boton_añadir)
        self.layout_v.addWidget(self.boton_limpiar)

        # --- Historial incidencia ---
        self.historial = QLabel("Historial de incidencias")
        self.historial_incidencia = QTextEdit("Esta caja de texto es solo de lectura")
        self.historial_incidencia.setDisabled(True)

        self.layout_v.addWidget(self.historial)
        self.layout_v.addWidget(self.historial_incidencia)

        # --- Menu ---
        self.barra_menu = self.menuBar()
        self.menu1 = self.barra_menu.addMenu("Archivo")
        self.menu2 = self.barra_menu.addMenu("Acerca de")

        # --- Acciones de menu ---
        self.accion_salir = QAction("Salir", self)
        self.accion_acercaDe = QAction("Acerca de", self)

        self.accion_salir.triggered.connect(self.salir)
        self.accion_acercaDe.triggered.connect(self.acerca)

        self.menu1.addAction(self.accion_salir)
        self.menu2.addAction(self.accion_acercaDe)        

        # --- Barra estado
        self.barra_estado = self.statusBar()
        self.barra_estado.showMessage("Inicio de la app...", 3000)

        # --- Widget central ---
        self.contenedor_principal.setLayout(self.layout_v)
        self.setCentralWidget(self.contenedor_principal)

    # --- Slots ---
    
    ''' NO ME AÑADE AL HISTORIAL
    
    def añadir(self):
        texto1 = self.caja_grupo.text()
        texto2 = self.caja_alumno.text()
        texto3 = self.caja_incidencia.text()
        texto4 = self.caja_descripcion
        texto5 = self.casilla_verificacion.checkState()

        if not texto1 or not texto2 or not texto3 or not texto4:
            self.barra_estado.showMessage("No están todos los campos completos.")
        else:
            self.historial_incidencia.setEnabled(True)
            self.historial_incidencia.setText(
                "Grupo", texto1,
                "Alumno", texto2,
                "Tipo", texto3,
                "Descripción", texto4,
                "Resuelta", texto5
            )
            self.barra_estado.showMessage("Historial modificado.")
    '''

    def limpiar(self):
        self.caja_grupo.clear()
        self.caja_alumno.clear()
        self.caja_incidencia.clear()
        self.caja_descripcion.clear()
        self.casilla_verificacion.setChecked(False)

    def salir(self):
        exit()

    def acerca(self):
        self.barra_estado.showMessage("Información: Esto es un bloc de incidencias.")

# --- Bucle aplicación ---
app = QApplication([])
window = blocIncidencias()
window.show()
app.exec()