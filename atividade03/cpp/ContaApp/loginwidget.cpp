#include "loginwidget.h"

#include <QDebug>

LoginWidget::LoginWidget(QWidget *parent) : QWidget(parent),
                                            m_formLayout(new QFormLayout()),
                                            m_agenciaLineEdit(new QLineEdit()),
                                            m_contaLineEdit(new QLineEdit()),
                                            m_senhaLineEdit(new QLineEdit()),
                                            m_loginButton(new QPushButton("Entrar"))
{
    init();
}

void LoginWidget::init()
{
    m_formLayout->addRow("Agência", m_agenciaLineEdit);
    m_formLayout->addRow("Conta", m_contaLineEdit);
    m_formLayout->addRow("Senha", m_senhaLineEdit);
    m_formLayout->addRow(m_loginButton);
    this->setLayout(m_formLayout);
}
