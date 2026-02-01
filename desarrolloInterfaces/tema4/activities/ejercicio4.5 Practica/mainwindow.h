#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPushButton>
#include <QComboBox>
#include <QWebEngineView>
#include <QVBoxLayout>
#include <QHBoxLayout>

class MainWindow : public QMainWindow {
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);

private slots:
    void abrirEnNavegadorExterno();
    void cargarInformeInterno(const QString &nombreFichero);

private:
    QWebEngineView *visorWeb;
    QComboBox *selectorInformes;
};

#endif