#ifndef CONTAINTERFACE_H
#define CONTAINTERFACE_H

#include "containterface_global.h"
#include <QObject>

class CONTAINTERFACESHARED_EXPORT IConta
{

public:
    virtual ~IConta(){}

    virtual void initialize() = 0;
    virtual bool sacar(int valor) = 0;
    virtual bool depositar(int valor) = 0;
    virtual double consultarSaldo() = 0;
    virtual bool criarConta(QString nome, QString senha) = 0;
    virtual bool autenticar(QString nome, QString senha) = 0;
};

Q_DECLARE_INTERFACE(IConta, "org.qt-project.ContaInterface.IConta")

#endif // CONTAINTERFACE_H
