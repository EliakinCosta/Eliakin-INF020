#ifndef CONTACORRENTE_H
#define CONTACORRENTE_H

#include "contacorrente_global.h"

#include <QObject>
#include <QtPlugin>

#include <../ContaInterface/containterface.h>


class CONTACORRENTESHARED_EXPORT ContaCorrente: public QObject, IConta
{
    Q_OBJECT
    Q_PLUGIN_METADATA(IID "org.qt-project.ContaInterface.IConta" FILE "ContaCorrente.json")
    Q_INTERFACES(IConta)

public: 
    virtual ~ContaCorrente(){}
    virtual void initialize();
    virtual bool sacar(int valor);
    virtual bool depositar(int valor);
    virtual double consultarSaldo();
    virtual bool criarConta(QString nome, QString senha);
    virtual bool autenticar(QString nome, QString senha);
};

#endif // CONTACORRENTE_H
