#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QFormLayout>
#include <QHBoxLayout>
#include <QLineEdit>
#include <QPushButton>

#include "loginwidget.h"
#include <QStackedWidget>

class IConta;

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();
    bool loadPlugin();
private:
    void initialize();

    Ui::MainWindow *ui;
    IConta* m_contaPlugin;
    LoginWidget* m_loginWidget;
    QStackedWidget* m_stack;
};

#endif // MAINWINDOW_H
