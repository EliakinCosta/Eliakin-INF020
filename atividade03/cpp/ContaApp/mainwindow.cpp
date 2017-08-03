#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QDir>
#include <QPluginLoader>
#include <QApplication>
#include <QDebug>

#include "../ContaInterface/containterface.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    loadPlugin();
}

MainWindow::~MainWindow()
{
    delete m_contaPlugin;
    delete ui;
}

void MainWindow::initialize()
{

}

bool MainWindow::loadPlugin()
{
    QDir pluginsDir = QDir(qApp->applicationDirPath());
    #if defined(Q_OS_WIN)
        qDebug() << pluginsDir.dirName().toLower();
        if (pluginsDir.dirName().toLower() == "debug" || pluginsDir.dirName().toLower() == "release")
            pluginsDir.cdUp();
    #elif defined(Q_OS_MAC)
        if (pluginsDir.dirName() == "MacOS") {
            pluginsDir.cdUp();
            pluginsDir.cdUp();
            pluginsDir.cdUp();
        }
    #endif
    pluginsDir.cdUp();
    pluginsDir.cd("plugins/");
    qDebug() << "diretorio plugins: " << pluginsDir.path();
    IConta* plugin = 0;

    foreach (QString pluginFileName, pluginsDir.entryList(QDir::Files))
    {
        QPluginLoader loader(pluginsDir.absoluteFilePath(pluginFileName));
        QObject* obj = loader.instance();
        qDebug() << pluginFileName;
        if (obj)
        {
            plugin = qobject_cast<IConta *>(obj);
            qDebug() << plugin;
            plugin->initialize();
            m_contaPlugin = plugin;
            return true;
        }
    }
    return false;
}
