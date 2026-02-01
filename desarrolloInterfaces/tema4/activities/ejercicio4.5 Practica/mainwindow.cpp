#include "mainwindow.h"
#include <QDesktopServices>
#include <QUrl>
#include <QDir>
#include <QLabel>

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent) {
    setWindowTitle("Gestor de Informes HTML - Qt");
    resize(1000, 700);

    // Widget central y layouts
    QWidget *centralWidget = new QWidget(this);
    setCentralWidget(centralWidget);
    QVBoxLayout *mainLayout = new QVBoxLayout(centralWidget);

    // --- EJERCICIO 1: Botones para Navegador Externo ---
    QLabel *lblEj1 = new QLabel("<b>Ejercicio 1:</b> Abrir en Navegador del Sistema", this);
    mainLayout->addWidget(lblEj1);

    QHBoxLayout *layoutBotones = new QHBoxLayout();
    QStringList informes = {"DI_U05_A02_03.html", "DI_U05_A02_08.html", "DI_U05_A03_11 (1).html"};

    for (const QString &nombre : informes) {
        QPushButton *btn = new QPushButton("Abrir " + nombre, this);
        // Conectamos usando una función lambda para pasar el nombre del archivo
        connect(btn, &QPushButton::clicked, this, [this, nombre]() {
            QString ruta = QDir::currentPath() + "/" + nombre;
            QDesktopServices::openUrl(QUrl::fromLocalFile(ruta));
        });
        layoutBotones->addWidget(btn);
    }
    mainLayout->addLayout(layoutBotones);

    mainLayout->addSpacing(20);

    // --- EJERCICIO 2: Visualización con QWebEngineView ---
    QLabel *lblEj2 = new QLabel("<b>Ejercicio 2:</b> Visualización Integrada", this);
    mainLayout->addWidget(lblEj2);

    selectorInformes = new QComboBox(this);
    selectorInformes->addItems(informes);
    mainLayout->addWidget(selectorInformes);

    visorWeb = new QWebEngineView(this);
    // Establecemos un tamaño mínimo para el visor
    visorWeb->setMinimumHeight(400);
    mainLayout->addWidget(visorWeb);

    // Conexión del ComboBox para cambiar el informe
    connect(selectorInformes, &QComboBox::currentTextChanged, this, &MainWindow::cargarInformeInterno);

    // Carga inicial del primer informe
    cargarInformeInterno(selectorInformes->currentText());
}

void MainWindow::cargarInformeInterno(const QString &nombreFichero) {
    // Obtenemos la ruta absoluta del fichero
    QString ruta = QDir::currentPath() + "/" + nombreFichero;
    visorWeb->load(QUrl::fromLocalFile(ruta));
}